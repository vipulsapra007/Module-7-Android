package com.example.playsongfromrawresource

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.playsongfromrawresource.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var mMediaPlayer:MediaPlayer?=null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }

    fun playSound(view: View) {
        if(mMediaPlayer==null){
            mMediaPlayer=MediaPlayer.create(this,R.raw.chaleya)
            mMediaPlayer!!.isLooping=true
            mMediaPlayer!!.start()
        }else{
            mMediaPlayer!!.reset()
        }

    }

    fun pauseSound(view: View) {

        if (mMediaPlayer?.isPlaying==true)
            mMediaPlayer?.pause()
    }


}