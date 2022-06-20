package app.sport.workoutlog

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class ScheduleDataDialog() : DialogFragment() {

    private lateinit var message: String

    @JvmName("setMessage1")
    public fun setMessage(message: String){
        this.message = message
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Данные о занятии")
                .setMessage(this.message)
                .setPositiveButton("Закрыть") {
                        dialog, _ ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }




}