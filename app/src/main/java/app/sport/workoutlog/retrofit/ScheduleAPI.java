package app.sport.workoutlog.retrofit;

import java.util.List;

import app.sport.workoutlog.model.Schedule;
import retrofit2.Call;
import retrofit2.http.GET;

public class ScheduleAPI {
    @GET("/schedule/getLessons")
    Call<List<Schedule>> getLessons() {
        return null;
    }

}
