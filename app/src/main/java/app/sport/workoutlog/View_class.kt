package app.sport.workoutlog

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class View_class (context: Context, layerheight: ArrayList<Double>): View(context) {

    private var layerheight: ArrayList<Double> = layerheight
    override fun onDraw (canvas: Canvas) {

        canvas.drawRGB (255, 255, 255)
        val width = width
        val footingpaint = Paint ()
        val textpaint = Paint ()
        val brush3 = Paint ()
        val brush4 = Paint ()

        footingpaint.setARGB (255, 128, 128, 128)
        textpaint.setARGB (255, 255, 255, 255)
        brush3.setARGB (255, 138, 36, 36)
        brush4.setARGB (255, 138, 36, 36)

        canvas.drawRect (((width/2)-10).toFloat(), 0f, ((width/2)+ 10) .toFloat (), 40f, footingpaint)
        canvas.drawRect (70f, 40f, (width - 70) .toFloat (), 80f, footingpaint)
        for(i in (0..layerheight.size)){
            println(layerheight)
        }

    }
}