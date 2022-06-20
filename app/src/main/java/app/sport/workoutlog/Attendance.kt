package app.sport.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import app.sport.workoutlog.localDB.UserLocal
import app.sport.workoutlog.model.User
import app.sport.workoutlog.retrofit.RetrofitService
import app.sport.workoutlog.retrofit.ScheduleAPI
import app.sport.workoutlog.retrofit.UserAPI
import retrofit2.Call
import retrofit2.Response
import java.util.logging.Level
import java.util.logging.Logger


class Attendance : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_attendance)

        val retrofitService = RetrofitService()
        val userAPI = retrofitService.retrofit.create(UserAPI::class.java)
        var user = User()

        userAPI.getUser(UserLocal.ID_USER.toInt()).enqueue(object : retrofit2.Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                user = response.body() as User
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                Logger.getLogger(Register::class.java.name)
                    .log(Level.SEVERE, "Ошибка обнаружена", t)
            }
        })

        val scheduleAPI = retrofitService.retrofit.create(ScheduleAPI::class.java)

        val list = scheduleAPI.getLessons(user)

        findViewById<TextView>(R.id.was).text = list.toString()


    }
}
