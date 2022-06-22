package app.sport.workoutlog

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import app.sport.workoutlog.databinding.ActivityPersonalAccountBinding
import app.sport.workoutlog.model.ProfileDTO
import app.sport.workoutlog.model.User
import app.sport.workoutlog.retrofit.RetrofitService
import app.sport.workoutlog.retrofit.UserAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


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

        userAPI.getProfileData(user).enqueue(object : Callback<ProfileDTO> {
            override fun onFailure(call: Call<ProfileDTO>, t: Throwable) {
            }

            override fun onResponse(call: Call<ProfileDTO>, response: Response<ProfileDTO>) {

                val userdata = response.body()

                if (userdata != null) {
                    findViewById<TextView>(R.id.text_name).text = userdata.name
                    findViewById<TextView>(R.id.text_price).text =
                        findViewById<TextView>(R.id.text_price).text as String + " " + userdata.price
                    findViewById<TextView>(R.id.text_sch).text =
                        findViewById<TextView>(R.id.text_sch).text as String + " " + userdata.nextLesson

                    findViewById<TextView>(R.id.text_term).text =
                        findViewById<TextView>(R.id.text_term).text as String + " " + userdata.abonement_time

                    findViewById<TextView>(R.id.text_v_sport).text =
                        findViewById<TextView>(R.id.text_v_sport).text as String + " " + userdata.sportkind

                    findViewById<TextView>(R.id.text_group).text =
                        findViewById<TextView>(R.id.text_group).text as String + " " + userdata.groupName

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
                }
            }
        }
    )}
}




