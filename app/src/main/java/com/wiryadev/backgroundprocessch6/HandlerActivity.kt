package com.wiryadev.backgroundprocessch6

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.wiryadev.backgroundprocessch6.databinding.ActivityHandlerBinding


class HandlerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHandlerBinding

    private lateinit var handler: Handler

    private var i = 1
    private var max = i

    private val runTask: Runnable = object : Runnable {
        override fun run() {
            if (i <= max) {
                binding.tvResult.text = "Slept for $i seconds"
                i++
                // Repeat this task again another i * 1000 seconds
                handler.postDelayed(this, (i * 1000).toLong())
            } else {
                handler.removeCallbacks(this)
                binding.tvResult.text = "Finished: Slept for $max seconds"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(mainLooper)

        with(binding) {
            btnRun.setOnClickListener {
                i = 1
                binding.tvResult.text = "Sleeping"
                max = try {
                    etTime.text.toString().toInt()
                } catch (e: NumberFormatException) {
                    1
                }
                handler.post(runTask)
            }
        }
    }
}