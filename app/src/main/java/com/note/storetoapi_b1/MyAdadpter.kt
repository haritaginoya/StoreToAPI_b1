package com.note.storetoapi_b1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdadpter(var arraylist: ArrayList<DataClass>, var firstPage: FirstPage) : BaseAdapter() {
    override fun getCount(): Int {
        return arraylist.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var secondname: TextView
        var secondtype: TextView
        var seconddes: TextView
        var seconqty: TextView
        var view = LayoutInflater.from(firstPage).inflate(R.layout.abc, parent, false)

        secondname = view.findViewById(R.id.secondname)
        secondtype = view.findViewById(R.id.secondtype)
        seconddes = view.findViewById(R.id.seconddes)
        seconqty = view.findViewById(R.id.seconqty)

        secondname.setText("Name :"+arraylist[position].cat_name)
        secondtype.setText("Id :"+arraylist[position].cat_id)
        seconddes.setText("Description :"+arraylist[position].cat_description)
        seconqty.setText("Qty :"+arraylist[position].cat_qty)


        return view
    }


}
