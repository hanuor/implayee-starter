package com.raywenderlich.implayee

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class ExoPlayerActivity : AppCompatActivity() {

    companion object {
        var  BUFFER_SEGMENT_SIZE = 64 * 1024
        var BUFFER_SEGMENT_COUNT = 256
    }
    private var simpleExoPlayerView: SimpleExoPlayerView? = null
    private var window: Timeline.Window? = null
    private var mediaDataSourceFactory: DataSource.Factory? = null
    private var trackSelector: DefaultTrackSelector? = null
    private var shouldAutoPlay: Boolean = false
    var mediaSource: MediaSource?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exo_player)
        simpleExoPlayerView = findViewById<SimpleExoPlayerView>(R.id.player_view)
        simpleExoPlayerView?.requestFocus()


        // 1. Create a default TrackSelector
        val mainHandler = Handler()
        var bandwidthMeter = DefaultBandwidthMeter()
        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
        val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)

// 2. Create the player
        val playero = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
        simpleExoPlayerView?.player = playero
        // Measures bandwidth during playback. Can be null if not required.
// Produces DataSource instances through which media data is loaded.
        val dataSourceFactory = DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "yourApplicationName"), bandwidthMeter)
// Produces Extractor instances for parsing the media data.
        val extractorsFactory = DefaultExtractorsFactory()
// This is the MediaSource representing the media to be played.
        val videoSource = ExtractorMediaSource(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"),
                dataSourceFactory, extractorsFactory, null, null)
// Prepare the player with the source.
        playero?.prepare(videoSource)
    }
}
