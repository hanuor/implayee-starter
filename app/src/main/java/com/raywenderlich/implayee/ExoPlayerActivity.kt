/*
 * Copyright 2018 Google, Inc.
 *
 * ...
 */
package com.raywenderlich.implayee

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.SimpleExoPlayerView

class ExoPlayerActivity : AppCompatActivity() {
    private var simpleExoPlayerView: SimpleExoPlayerView? = null
    private var exoPlayer: SimpleExoPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exo_player)
        simpleExoPlayerView = findViewById<SimpleExoPlayerView>(R.id.player_view)
    }

    override fun onStop() {
        super.onStop()
    }
}
