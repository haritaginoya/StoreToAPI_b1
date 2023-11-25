package com.note.storetoapi_b1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class EditPage : AppCompatActivity() {

    lateinit var nameE: EditText
    lateinit var qtyE: EditText
    lateinit var descriptionE: EditText
    lateinit var radiogroupE: RadioGroup
    lateinit var submitE: Button
    var typeE = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_page)


        var pos = intent.getIntExtra("pos", 0)
        var name = intent.getStringExtra("name")
        var qty = intent.getStringExtra("qty")
        var description = intent.getStringExtra("description")
        var type = intent.getStringExtra("type")
        var id = intent.getStringExtra("id")

        nameE = findViewById(R.id.nameE)
        qtyE = findViewById(R.id.qtyE)
        submitE = findViewById(R.id.submitE)
        descriptionE = findViewById(R.id.descriptionE)
        radiogroupE = findViewById(R.id.radiogroupE)


        nameE.setText(name)
        qtyE.setText(qty)
        descriptionE.setText(description)
        radiogroupE.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->

            when (checkedId) {
                R.id.vegetarian -> {
                    typeE = "Vegetarian"
                }

                R.id.nonvegetarian -> {
                    typeE = "Non-vegetarian"
                }

                R.id.eggatarian -> {
                    typeE = "Eggatarian"
                }

                R.id.vegan -> {
                    typeE = "Vegan"
                }

            }
        })

        submitE.setOnClickListener {


            var que2 = Volley.newRequestQueue(this)

            var url2 =
                "http://workfordemo.in/bunch1/update_category.php?cat_id=$id&cat_type=${typeE}&cat_name=${nameE.text.toString()}&cat_description=${descriptionE.text.toString()}&cat_qty=${qtyE.text.toString()}"


            var stringrequest2 = StringRequest(Request.Method.GET, url2, { Response ->


            }, {})

            que2.add(stringrequest2)
            startActivity(Intent(this,FirstPage::class.java))
        }
    }
}