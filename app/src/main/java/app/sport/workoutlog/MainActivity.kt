package app.sport.workoutlog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.sport.workoutlog.localDB.AppDatabase
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var counter: Int = 0
    private var stop: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val m_activity = Intent(this@MainActivity, Login::class.java)
        Thread {
            stop = true
            while (stop) {
                Thread.sleep(150)
                if (counter == 35)
                    stop = false
                counter++
                runOnUiThread {
                    if (counter == 30) startActivity(m_activity)
                }

            }
        }.start()
    }

    companion object {
        lateinit var ID_USER: String
    }
}

