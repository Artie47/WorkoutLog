package app.sport.workoutlog.retrofit;

import app.sport.workoutlog.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {
    @POST("/signUp")
    Call<User> signUp(@Body User user);

    @POST("/signIn")
    Call<User> signIn(@Body User user);

    @POST("/getUser")
    Call<User> getUser(@Body User user);

}
