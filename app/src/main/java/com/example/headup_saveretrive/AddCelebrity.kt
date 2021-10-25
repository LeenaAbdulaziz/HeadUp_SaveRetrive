package com.example.headup_saveretrive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_celebrity.*
import kotlinx.android.synthetic.main.activity_main.*

class AddCelebrity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_celebrity)
        btnsave.setOnClickListener {
            var s0=edname.text.toString()
            var s1=edtaboo1.text.toString()
            var s2=edtaboo2.text.toString()
            var s3=edtaboo3.text.toString()
            var dbobject=DBHlpr(applicationContext)
            dbobject.addcelebrity(s0,s1,s2,s3)
            Toast.makeText(applicationContext,"Celebrity added",Toast.LENGTH_SHORT).show()
            edname.text.clear()
            edtaboo1.text.clear()
            edtaboo2.text.clear()
            edtaboo3.text.clear()
        }

    }
}