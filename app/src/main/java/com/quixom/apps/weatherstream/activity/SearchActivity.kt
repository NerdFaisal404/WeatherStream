package com.quixom.apps.weatherstream.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.quixom.apps.weatherstream.Methods
import com.quixom.apps.weatherstream.R
import com.quixom.apps.weatherstream.utilities.KeyUtil.REQ_CODE_SPEECH_INPUT
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        ivTextToSpeech.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            ivTextToSpeech ->{
                Methods.promptSpeechInput(this@SearchActivity)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQ_CODE_SPEECH_INPUT -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val result: ArrayList<String> = arrayListOf(RecognizerIntent.EXTRA_RESULTS)
                    Toast.makeText(this, "result == " + result[0], Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}