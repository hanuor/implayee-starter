/*
 * Copyright 2018 Google, Inc.
 *
 * ...
 */
package com.raywenderlich.implayee

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.SurfaceView
import android.view.View
import android.widget.Button


class VideoActivity : AppCompatActivity() {
    private var mp: MediaPlayer? = null
    private var playPauseButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        val sv = findViewById<View>(R.id.surfaceView) as SurfaceView
        playPauseButton = findViewById(R.id.playPauseButton)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }
}
