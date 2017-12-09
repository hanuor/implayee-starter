package com.raywenderlich.implayee

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button


class VideoActivity : AppCompatActivity() {

    private var playPauseButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        playPauseButton = findViewById(R.id.playPauseButton)

        playPauseButton?.setOnClickListener({
        })

    }

}
