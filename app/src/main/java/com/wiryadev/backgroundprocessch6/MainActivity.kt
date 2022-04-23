package com.wiryadev.backgroundprocessch6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wiryadev.backgroundprocessch6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnHandler.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, HandlerActivity::class.java)
                )
            }
            btnAsyncTask.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, AsyncTaskActivity::class.java)
                )
            }
            btnCoroutines.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, CoroutinesActivity::class.java)
                )
            }
        }
    }
}