package com.wiryadev.backgroundprocessch6

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.wiryadev.backgroundprocessch6.databinding.ActivityAsyncTaskBinding

class AsyncTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAsyncTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsyncTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRun.setOnClickListener {
            val runner = AsyncTaskRunner()
            val sleepTime = binding.etTime.text.toString()
            Log.d("AsyncTask", "onCreate: $sleepTime")
            runner.execute(sleepTime)
        }
    }

    private inner class AsyncTaskRunner : AsyncTask<String, String, String>() {

        private var resp: String = ""

        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg params: String): String {
            publishProgress("Sleeping...") // Calls onProgressUpdate()

            resp = try {
                for (i in 1..params[0].toInt()) {
                    Log.d("AsyncTask", "doInBackground: $i")
                    Thread.sleep((i * 1000).toLong())
                    publishProgress("Slept for $i seconds")
                }
                "Slept for ${params[0]} seconds"
            } catch (e: InterruptedException) {
                e.printStackTrace()
                e.message.toString()
            } catch (e: Exception) {
                e.printStackTrace()
                e.message.toString()
            }
            return resp
        }

        @Deprecated("Deprecated in Java")
        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            binding.tvResult.text = "Finished: $result"
        }

        @Deprecated("Deprecated in Java")
        override fun onProgressUpdate(vararg values: String?) {
            super.onProgressUpdate(*values)
            binding.tvResult.text = values[0]
        }

    }
}