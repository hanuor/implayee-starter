/*
 * Copyright 2018 Google, Inc.
 *
 * ...
 */
package com.raywenderlich.implayee

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button


class AudioActivity : AppCompatActivity() {
    private var playPauseAudio: Button? = null
    private var restartAudio: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)
        initViews()
        onClicks()

    }

    private fun initViews() {
        //play / pause audio button (mediaplayer class)
        playPauseAudio = findViewById(R.id.playPauseAudio)

        //restart Audio button
        restartAudio = findViewById(R.id.restartAudio)
    }

    private fun onClicks() {
        playPauseAudio?.setOnClickListener({
        })
        restartAudio?.setOnClickListener({
        })
    }
}