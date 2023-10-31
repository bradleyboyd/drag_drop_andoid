package com.example.drag_drop_android

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


lateinit var draggableImage: TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        draggableImage = findViewById(R.id.draggableImage)
        // Hide the action bar
        //val actionBar = supportActionBar

        //actionBar!!.hide()
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels
        Log.d("width", (height).toString());
        Log.d("height", (width).toString());

        var dx_square = 100

        var width_cool = 0.8*width
        var height_cool = 0.8*height

        var listener = View.OnTouchListener(function = {view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {

                //view.x = motionEvent.rawX - view.width/2 + (0.1*(view.height).toDouble()).toInt()
                //view.y = motionEvent.rawY - view.height/2 + (0.1*(view.height).toDouble()).toInt()

                //var x_loc = (motionEvent.rawX  - view.width/2 - (0.1*(width).toDouble()))-width/2.0
                //var y_loc = (motionEvent.rawY - view.height  - (0.1*(height).toDouble()))-height/2.0

                var x_move =  - (0.1*(width).toDouble()) - view.width/2
                var y_move =  - (0.1*(height).toDouble()) - view.height/2

                var x_offset = width/2.0
                var y_offset = height/2.0

                var x_loc = (motionEvent.rawX)-x_offset
                var y_loc = (motionEvent.rawY)-y_offset

                var x_max = ( 0.5*(width_cool))-0.5*dx_square
                var x_min = (- 0.5*(width_cool))+0.5*dx_square

                var y_max = (0.5*(height_cool))-1.0*dx_square
                var y_min = (-0.5*(height_cool))+0.5*dx_square

                if (x_loc>x_max){
                    x_loc = x_max
                }
                else if (x_loc < x_min){
                    x_loc = x_min
                }

                if (y_loc>y_max){
                    y_loc = y_max
                }
                else if (y_loc < y_min){
                    y_loc = y_min
                }

                //view.y = motionEvent.rawY - view.height - (0.1*(height).toDouble()).toInt()
                //view.x = motionEvent.rawX  - view.width/2 - (0.1*(width).toDouble()).toInt()

                view.x = (x_loc+x_offset+x_move).toFloat()
                view.y = (y_loc+y_offset+y_move).toFloat()
                Log.d("rawY", (motionEvent.rawY).toString());
                Log.d("height", (((view.height).toDouble()).toInt()).toString());
            }

            true

        })

        // Declared in our activity_shapes_view.xml file.
        draggableImage.setOnTouchListener(listener)

    }
}