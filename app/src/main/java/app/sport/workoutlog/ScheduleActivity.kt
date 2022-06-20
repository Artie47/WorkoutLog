package app.sport.workoutlog

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import app.sport.workoutlog.databinding.ActivityScheduleBinding
import java.lang.String
import java.text.SimpleDateFormat
import java.util.*


class ScheduleActivity : AppCompatActivity() {
        lateinit var binding: ActivityScheduleBinding

        @SuppressLint("SimpleDateFormat")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = ActivityScheduleBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val calendarView = findViewById<CalendarView>(R.id.calendarView)

            calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(year-1900, month, dayOfMonth);
                val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
                val manager: FragmentManager = supportFragmentManager
                val transaction: FragmentTransaction = manager.beginTransaction()
                val firstText = "Дата занятия: "
                val pattern = "yyyy-MM-dd"
                val simpleDateFormat = SimpleDateFormat(pattern)

                val date = Date(year-1900, month, dayOfMonth)
                val dateString: kotlin.String = simpleDateFormat.format(date)
                val message = firstText.plus(dateString).plus("\n").plus("Начало: 15:00 \nКонец: 16:30")
                val myDialogFragment = ScheduleDataDialog()
                myDialogFragment.setMessage(message)
                when (dayOfWeek){
                    Calendar.MONDAY -> {
                        myDialogFragment.show(transaction, message)
                    }
                    Calendar.WEDNESDAY ->{
                        myDialogFragment.show(transaction, message)
                    }
                    Calendar.FRIDAY ->{
                        myDialogFragment.show(transaction, message)
                    }
                }
            }



            binding.bNav.setOnNavigationItemReselectedListener {
                when (it.itemId) {
                    R.id.btn_schedule -> {
                        val intent = Intent(this@ScheduleActivity, ScheduleActivity::class.java)
                        startActivity(intent)
                    }


                    R.id.btn_personal_account -> {
                        val intent = Intent(this@ScheduleActivity, PersonalAccount::class.java)
                        startActivity(intent)
                    }
                }
                true
            }
        }

        fun ChangeDate (savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)


            }
        }
