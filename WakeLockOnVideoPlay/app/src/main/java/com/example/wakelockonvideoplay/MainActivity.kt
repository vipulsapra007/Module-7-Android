package com.example.wakelockonvideoplay

import android.app.Activity
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import android.widget.VideoView
import com.example.wakelockonvideoplay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE_FOR_PICKUP = 100
    private lateinit var videoView: VideoView
    private var videoUri: Uri? = null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videoView = binding.videoView

        binding.ivThumbnail.setOnClickListener {

            var intent = Intent()
            intent.type = "video/*"
            intent.action = Intent.ACTION_OPEN_DOCUMENT
            startActivityForResult(
                Intent.createChooser(intent, "Select Audio"),
                REQUEST_CODE_FOR_PICKUP
            )
        }

        binding.ivPlay.setOnClickListener {

            playVideoSong()

        }
        binding.ivPause.setOnClickListener {
            if (videoView.isPlaying) {

                videoView.pause()

            } else {
                Toast.makeText(this, "Please Play Video", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun playVideoSong() {
        videoView.setVideoURI(videoUri)
        videoView.start()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_FOR_PICKUP && resultCode == RESULT_OK) {

            videoUri = data?.data

        }
    }

}
