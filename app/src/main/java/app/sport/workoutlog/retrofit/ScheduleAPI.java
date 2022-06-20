package app.sport.workoutlog.retrofit;

import java.util.List;

import app.sport.workoutlog.model.Schedule;
import app.sport.workoutlog.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ScheduleAPI {
    @GET("/schedule/getLessons")
    Call<List<Schedule>> getLessons(User user);

}
