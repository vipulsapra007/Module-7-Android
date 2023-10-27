package com.example.playsongfromserver

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.playsongfromserver.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnPlay.setOnClickListener {

            if (mediaPlayer==null){
                var audioUrl = "https://pagalnew.com/download128/43406.mp3"
                mediaPlayer= MediaPlayer()
                mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
                try {
                    mediaPlayer!!.setDataSource(audioUrl)
                    mediaPlayer!!.prepare()
                    mediaPlayer!!.start()
                }catch (e:Exception){
                    e.printStackTrace()
                }
                Toast.makeText(this, "Audio Player Started", Toast.LENGTH_SHORT).show()
            }else{
                mediaPlayer!!.start()
                Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show()
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


}