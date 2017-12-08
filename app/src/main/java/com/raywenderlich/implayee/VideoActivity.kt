package com.raywenderlich.implayee

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.widget.Button


class VideoActivity : AppCompatActivity() {

    var mp: MediaPlayer? = null
    var playPauseButton: Button?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        mp = MediaPlayer.create(this, R.raw.sample_video)

        val sv = findViewById<View>(R.id.surfaceView1) as SurfaceView
        playPauseButton = findViewById(R.id.playPauseButton)
        playPauseButton?.setOnClickListener({
            if(mp?.isPlaying as Boolean){
                mp?.pause()
                playPauseButton?.setText("Play")
            }else{
                mp?.start()
                playPauseButton?.setText("Pause")
            }
        })
        val holder = sv.holder
        holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun surfaceDestroyed(p0: SurfaceHolder?) {
             //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun surfaceCreated(p0: SurfaceHolder?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                mp?.setDisplay(holder)
                mp?.start()
            }

        })

    }

    override fun onPause() {
        super.onPause()

        if (null != mp){
            mp?.pause()
        }
    }
}
