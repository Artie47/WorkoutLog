package app.sport.workoutlog

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.sport.workoutlog.localDB.UserLocal
import app.sport.workoutlog.model.User
import app.sport.workoutlog.retrofit.RetrofitService
import app.sport.workoutlog.retrofit.UserAPI
import retrofit2.Call
import retrofit2.Response
import java.util.logging.Level
import java.util.logging.Logger


class PersonalAccount : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        val userData = UserLocal(
            user.name, user.email,
            user.password, user.date_of_reg, user.group.toString())

        findViewById<TextView>(R.id.text_name).text = userData.name
        findViewById<TextView>(R.id.text_v_sport).text = userData.sportkind
        findViewById<TextView>(R.id.text_group).text = userData.id_group
        findViewById<TextView>(R.id.text_price).text = userData.taxPrice
        findViewById<TextView>(R.id.text_term).text = userData.nextPayData
        findViewById<TextView>(R.id.text_sch).text = userData.nextLesson

        setContentView(R.layout.activity_personal_account)

        }

}



