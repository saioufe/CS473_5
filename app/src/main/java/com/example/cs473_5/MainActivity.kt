package com.example.cs473_5

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var totalScore:Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn_nextapp.setOnClickListener(){
            var intent = Intent(this , RecyclerList::class.java)
            startActivity(intent)

        }
        btn_reset.setOnClickListener(){
            totalScore = 0
            radioGroup.clearCheck()
            checkBox.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
        }


        btn_submit.setOnClickListener(){
            var builder = AlertDialog.Builder(this);

            builder.setMessage("Congratulations! You submitted on current date and time, Your achieved $totalScore%")
            builder.setTitle("Question Submitted!")

            builder.setPositiveButton("Yes") { dialog: DialogInterface?, which: Int ->
               dialog?.dismiss()
            }


            val alertDialog = builder.create()
            alertDialog.show()
        }
    }



    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked
            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rdo_main ->
                    if (checked) {
                        totalScore+=50;
                    }
                R.id.rdo_start ->
                    if (checked) {
                        if(totalScore >0){
                            totalScore-=50
                        }
                    }
                R.id.rdo_run ->
                    if (checked) {
                        if(totalScore >0){
                            totalScore-=50
                        }
                    }
            }
        }
    }

    fun onCheckButtonClicked(view: View) {
        if (view is CheckBox) {
            // Is the button now checked?
            val checked = view.isChecked
            // Check which radio button was clicked
            when (view.getId()) {
                R.id.checkBox ->
                    if (checked) {
                        totalScore+=25;
                    }
                R.id.checkBox2 ->
                    if (checked) {
                        totalScore+=25;
                    }
                R.id.checkBox3 ->
                    if (checked) {
                        totalScore-=25;
                    }
            }
        }
    }
}