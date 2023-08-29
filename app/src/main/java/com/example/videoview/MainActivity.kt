package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import java.net.URI

class MainActivity : AppCompatActivity() {

    private var btnOnce: Button? = null
    private var btnContinusly: Button? = null
    private var btnStop: Button? = null
    private var vv: VideoView? = null
    private var mediaControler: MediaController? = null
    private var uri: Uri? = null
    private var isContinusly = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOnce = findViewById(R.id.btnOnce)
        btnContinusly = findViewById(R.id.btnConti)
        btnStop = findViewById(R.id.btnStop)
        vv = findViewById(R.id.vv)

        mediaControler = MediaController(this)
        mediaControler!!.setAnchorView(vv)
        val uriPath = "android.resource://com.example.videoview/" + R.raw.post_malone
        uri = Uri.parse(uriPath)

        vv!!.setOnCompletionListener {
            if (isContinusly){
                vv!!.start()
            }
        }

        btnStop!!.setOnClickListener {
            vv!!.stopPlayback()
        }

        btnOnce!!.setOnClickListener {
            isContinusly = false
            vv!!.setMediaController(mediaControler)
            vv!!.setVideoURI(uri)
            vv!!.requestFocus()
            vv!!.start()
        }

        btnContinusly!!.setOnClickListener {
            isContinusly = true
            vv!!.setMediaController(mediaControler)
            vv!!.setVideoURI(uri)
            vv!!.requestFocus()
            vv!!.start()
        }

    }
}