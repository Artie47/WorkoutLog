package app.sport.workoutlog.retrofit;

import app.sport.workoutlog.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {
    @POST("/user/save")
    Call<User> save(@Body User user);

    @POST("/user/check")
    Call<User> check(@Body User user);

}
