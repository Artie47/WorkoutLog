package app.sport.workoutlog.retrofit;

import app.sport.workoutlog.model.Trainer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TrainerAPI {
    @POST("/trainerSignIn")
    Call<Trainer> trainerSignIn(@Body Trainer trainer);

}