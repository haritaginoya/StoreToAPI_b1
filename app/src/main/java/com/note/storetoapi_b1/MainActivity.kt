package com.note.storetoapi_b1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var qty: EditText
    lateinit var description: EditText
    lateinit var radiogroup: RadioGroup
    lateinit var submit: Button
    var type = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        qty = findViewById(R.id.qty)
        submit = findViewById(R.id.submit)
        description = findViewById(R.id.description)
        radiogroup = findViewById(R.id.radiogroup)

        radiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->

            when (checkedId) {
                R.id.vegetarian -> {
                    type = "Vegetarian"
                }

                R.id.nonvegetarian -> {
                    type = "Non-vegetarian"
                }

                R.id.eggatarian -> {
                    type = "Eggatarian"
                }

                R.id.vegan -> {
                    type = "Vegan"
                }

            }
        })
        submit.setOnClickListener {


            var que = Volley.newRequestQueue(this)

            var url = "http://workfordemo.in/bunch1/insert_category.php?cat_type=${type}&cat_name=${name.text.toString()}&cat_description=${description.text.toString()}&cat_qty=${qty.text.toString()}       "

            var stringrequest = StringRequest(Request.Method.GET, url, { Response ->

            }, {})

            que.add(stringrequest)
            startActivity(Intent(this@MainActivity, FirstPage::class.java))
        }

    }
}