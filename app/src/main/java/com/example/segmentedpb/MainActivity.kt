package com.example.segmentedpb

import androidx.appcompat.app.AppCompatActivity
import android.widget.ProgressBar
import android.annotation.SuppressLint
import android.os.Bundle
import com.example.segmentedpb.R
import com.example.segmentedpb.SeperatedProgressbar
import androidx.core.content.ContextCompat
import android.os.CountDownTimer
import android.view.View

class MainActivity : AppCompatActivity() {
    var progressB = 1
    var progressBar: ProgressBar? = null
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById<View>(R.id.progress_bar_test) as ProgressBar
        val bgProgress = SeperatedProgressbar(ContextCompat.getColor(this, R.color.black),
            ContextCompat.getColor(this, R.drawable.custom_seek_bar), this)
        progressBar!!.progressDrawable = bgProgress
        progressBar!!.max = 100
        progressBar!!.progress = 50
        object : CountDownTimer(100000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                progressB = progressB + 1
                progressBar!!.progress = progressB
            }

            override fun onFinish() {}
        }.start()
    }
}