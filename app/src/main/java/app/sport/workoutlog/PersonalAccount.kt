package app.sport.workoutlog

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import app.sport.workoutlog.databinding.ActivityPersonalAccountBinding
import app.sport.workoutlog.model.User
import app.sport.workoutlog.retrofit.RetrofitService
import app.sport.workoutlog.retrofit.UserAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PersonalAccount : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    fun onShowSettings(): String {
        val sp: SharedPreferences = sharedPreferences
        val ret: String? = sp.getString("credSetKey", String.toString())
        if (ret != null) {
               return  ret
            }
        return "Error"
    }

    fun onPutSettings(email: String) {
        val sp: SharedPreferences? = null
        val emailSetting: MutableSet<String> = java.util.HashSet()
        emailSetting.add(email)
        val e: SharedPreferences.Editor? = sharedPreferences.edit()
        if (e != null) {
            e.putStringSet("credSetKey", emailSetting)
        }
        if (e != null) {
            e.apply()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var binding: ActivityPersonalAccountBinding

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val retrofitService = RetrofitService()
        val userAPI = retrofitService.retrofit.create(UserAPI::class.java)

        val user = User()
        user.email = onShowSettings()

        userAPI.getUser(user).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {

                val userdata: User? = response.body()

                if (userdata != null) {
                    findViewById<TextView>(R.id.text_name).text = userdata.name
                }

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
            }
        }
    )}
}




