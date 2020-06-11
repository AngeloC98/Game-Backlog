package com.example.gamebacklog.ui

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.gamebacklog.R
import com.example.gamebacklog.model.Game

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class AddActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViews() {
        val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)

        fab.setOnClickListener {
            val date = LocalDate.of(etYear.text.toString().toInt(), etMonth.text.toString().toInt(), etDay.text.toString().toInt())
            val formattedDate = date.format(formatter)
            val game = Game(
                title = etTitle.text.toString(),
                platform = etPlatform.text.toString(),
                releaseDate = formattedDate.toString()
            )

            val intent = Intent()
            intent.putExtra("ADD_GAME", game)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}
