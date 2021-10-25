package com.example.headup_saveretrive

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_add_celebrity.*
import kotlinx.android.synthetic.main.activity_main.*

class AddCelebrity : AppCompatActivity() {
    lateinit var recycle:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_celebrity)
        recycle=findViewById(R.id.recycle)
        var db = DBHlpr(applicationContext)

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
            updatedrecycle(db.viewceleb())
        }

    }
    fun updatedrecycle(list:ArrayList<Celebrity>){

        recycle.adapter = RecycleView (this, list)
        recycle.layoutManager = LinearLayoutManager(this)
        recycle.adapter?.notifyDataSetChanged()


    }

    fun update(celebrity: Celebrity) {
        var db = DBHlpr(applicationContext)
        db.update(celebrity)
        updatedrecycle(db.viewceleb())
    }
    fun deleteitem(celebrity: Celebrity) {
        var db = DBHlpr(applicationContext)
        db.delete(celebrity)
        updatedrecycle(db.viewceleb())
        Toast.makeText(applicationContext,"Successfully deleted",Toast.LENGTH_SHORT).show()

    }

    fun Updatecelb(celebrity:Celebrity) {
            var c=celebrity
            val d = AlertDialog.Builder(this)
            lateinit var input: EditText
            lateinit var tb1: EditText
            lateinit var tb2: EditText
            lateinit var tb3: EditText
            lateinit var vv: View

            d.setCancelable(false)
            d.setPositiveButton("update") { _, _ ->
                c.name = input.text.toString()
                c.taboo1 = tb1.text.toString()
                c.taboo2 = tb2.text.toString()
                c.taboo3 = tb3.text.toString()
                var db = DBHlpr(applicationContext)
                db.update(c)
            }
                .setNegativeButton("Cancel") { d, _ -> d.cancel() }


            val alert = d.create()
            alert.setTitle("Edit celebrity")
        vv=layoutInflater.inflate(R.layout.alert,null)
            alert.setView(vv)
            input= vv.findViewById(R.id.edn)
            tb1=vv.findViewById(R.id.edatb1)
            tb2=vv.findViewById(R.id.edatb2)
            tb3=vv.findViewById(R.id.edatb3)
            input.setText(c.name)
            tb1.setText(c.taboo1)
            tb2.setText(c.taboo2)
            tb3.setText(c.taboo3)

            alert.show()

        }


    fun confirm(celebrity: Celebrity){
        var at= AlertDialog.Builder(this)
        at.setTitle("delete Celebrity")
        at.setPositiveButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
            deleteitem(celebrity)
        })
        at.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        at.show()
    }

}