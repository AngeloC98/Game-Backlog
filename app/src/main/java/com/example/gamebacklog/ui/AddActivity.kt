package com.example.gamebacklog.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamebacklog.R
import com.example.gamebacklog.model.Game

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()

    }

    private fun initViews() {
        fab.setOnClickListener {
            val game = Game(
                title = etTitle.text.toString(),
                platform = etPlatform.text.toString(),
                releaseDate = "${etDay.text} ${etMonth.text} ${etYear.text}"
            )

            val intent = Intent()
            intent.putExtra("ADD_GAME", game)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}
