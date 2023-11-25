package com.note.storetoapi_b1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONObject

class FirstPage : AppCompatActivity() {
    lateinit var list: ListView
    lateinit var add: FloatingActionButton
    var arraylisr = ArrayList<DataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        list = findViewById(R.id.list)
        add = findViewById(R.id.add)

        var que = Volley.newRequestQueue(this)
        var url = "http://workfordemo.in/bunch1/get_category.php"
        var stringrequest = StringRequest(Request.Method.GET, url, { Response ->

            var objecttt = JSONObject(Response)
            var arrayy = objecttt.getJSONArray("category_list")

            for (i in 0 until arrayy.length()) {

                var mapp = arrayy.getJSONObject(i)
                var cat_id = mapp.getString("cat_id")
                var cat_name = mapp.getString("cat_name")
                var cat_qty = mapp.getString("cat_qty")
                var cat_description = mapp.getString("cat_description")

                var data = DataClass(cat_id, cat_name, cat_qty, cat_description)

                Log.e("hellooo", "onCreate: ${data.cat_name}")
                arraylisr.add(data)
            }
            arraylisr.reverse()
            var adapter = MyAdadpter(arraylisr, this)
            list.adapter = adapter
        }, {

            Log.e("===", "onCreate: ${it.localizedMessage}")

        })

        que.add(stringrequest)

        add.setOnClickListener {

            startActivity(Intent(this@FirstPage, MainActivity::class.java))

        }

        list.setOnItemClickListener { parent, view, position, id ->

            startActivity(
                Intent(this, EditPage::class.java).putExtra("pos", position)
                    .putExtra("name", arraylisr[position].cat_name)
                    .putExtra("qty", arraylisr[position].cat_qty)
                    .putExtra("description", arraylisr[position].cat_description)
                    .putExtra("id", arraylisr[position].cat_id)
            )

        }
    }
}