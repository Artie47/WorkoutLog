package app.sport.workoutlog.retrofit;

import app.sport.workoutlog.model.Trainer;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TrainerAPI {
    @POST("/trainerSignIn")
    Call<Trainer> trainerSignIn(@Body Trainer trainer);

    @POST("/trainerSignUp")
    Call<Trainer> trainerSignUp(@Body Trainer trainer);

}