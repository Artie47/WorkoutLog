package app.sport.workoutlog

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import app.sport.workoutlog.databinding.ActivityPersonalAccountBinding
import app.sport.workoutlog.databinding.ActivityScheduleBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class PersonalAccount : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var binding: ActivityPersonalAccountBinding


//        userAPI.getUser(UserLocal.ID_USER.toInt()).enqueue(object : retrofit2.Callback<User?> {
//            override fun onResponse(call: Call<User?>, response: Response<User?>) {
//                user = response.body() as User
//            }
//
//            override fun onFailure(call: Call<User?>, t: Throwable) {
//                Logger.getLogger(Register::class.java.name)
//                    .log(Level.SEVERE, "Ошибка обнаружена", t)
//            }
//        })


        binding = ActivityPersonalAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.btn_schedule -> {
                    val intent = Intent(this@PersonalAccount, ScheduleActivity::class.java)
                    startActivity(intent)
                }


                R.id.btn_personal_account -> {
                    val intent = Intent(this@PersonalAccount, PersonalAccount::class.java)
                    startActivity(intent)
                }
            }
            true
        }


        findViewById<TextView>(R.id.text_name).text = "Иванов Иван Иванович"
        findViewById<TextView>(R.id.text_v_sport).text = "Вид спорта: Волейбол"
        findViewById<TextView>(R.id.text_group).text = "Группа: Волейбол-1"
        findViewById<TextView>(R.id.text_price).text = "Стоимость: 1000 руб"
        findViewById<TextView>(R.id.text_term).text = "Срок: 01.06 - 01.07"
        findViewById<TextView>(R.id.text_sch).text = "След. занятие: 22.06"



        }

}



