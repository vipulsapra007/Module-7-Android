package com.example.converttexttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import com.example.converttexttospeech.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var textToSpeech:TextToSpeech?=null
    lateinit var binding: ActivityMainBinding
    private lateinit var message:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSpeak.setOnClickListener {
         message=binding.etTxt.text.toString().trim()

          textToSpeech = TextToSpeech(this, TextToSpeech.OnInitListener {
              if(it==TextToSpeech.SUCCESS){

                  textToSpeech!!.language= Locale.US
                  textToSpeech!!.setSpeechRate(1.0f)
                  textToSpeech!!.speak(message,TextToSpeech.QUEUE_ADD,null)
              }
          })


      }






    }
}