package com.example.playsongfromstorage

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.playsongfromstorage.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE_FOR_PICKUP = 100
    private var mediaPlayer: MediaPlayer? = null
    private var songUri: Uri? = null
    lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.ivThumbnail.setOnClickListener {
            var intent = Intent()
            intent.type = "audio/*"
            intent.action = Intent.ACTION_OPEN_DOCUMENT
            startActivityForResult(
                Intent.createChooser(intent, "Select Audio"),
                REQUEST_CODE_FOR_PICKUP
            )
        }

        binding.btnPlay.setOnClickListener {
            if (mediaPlayer==null){
                playSelectedSong()
            }else{
                mediaPlayer!!.start()
                Toast.makeText(this, "Audio has been resumed", Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnPause.setOnClickListener {

            if (mediaPlayer!!.isPlaying){
                mediaPlayer!!.pause()
                Toast.makeText(this, "Audio has been paused", Toast.LENGTH_SHORT).show()

            }else{

                Toast.makeText(this, "Please play song", Toast.LENGTH_SHORT).show()

            }
        }


    }

    private fun playSelectedSong() {
        mediaPlayer = MediaPlayer().apply {
            setDataSource(this@MainActivity, songUri!!)
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )
            prepare()
            start()

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_FOR_PICKUP && resultCode == RESULT_OK) {

            songUri = data?.data

        }
    }
}
