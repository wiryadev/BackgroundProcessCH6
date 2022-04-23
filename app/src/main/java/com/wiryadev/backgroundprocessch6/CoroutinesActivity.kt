package com.wiryadev.backgroundprocessch6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.wiryadev.backgroundprocessch6.databinding.ActivityCoroutinesBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoroutinesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutinesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRun.setOnClickListener {
            val sleepTime = try {
                binding.etTime.text.toString().toInt()
            } catch (e: NumberFormatException) {
                1
            }
            launchCoroutines(sleepTime)
        }
    }

    private fun launchCoroutines(times: Int) {
        lifecycleScope.launch {
            binding.tvResult.text = "Sleeping"
            for (i in 1..times) {
                delay((i * 1000).toLong())
                binding.tvResult.text = "Slept for $i seconds"
            }

            binding.tvResult.text = "Finished: Slept for $times seconds"
        }
    }
}