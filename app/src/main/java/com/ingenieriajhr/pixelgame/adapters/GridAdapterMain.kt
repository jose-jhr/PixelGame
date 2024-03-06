package com.ingenieriajhr.pixelgame.adapters

import android.content.Context
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ingenieriajhr.pixelgame.R
import com.ingenieriajhr.pixelgame.model.ModelMain

internal class GridAdapterMain(val context:Context,val arrayModelMain:ArrayList<ModelMain>): BaseAdapter() {


    //inflater layout init
    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return arrayModelMain.size
    }

    override fun getItem(p0: Int): ModelMain {
        return arrayModelMain[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val holder: ViewHolder

        if (convertView == null) {
            if (layoutInflater == null) {
                layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            }
            convertView = layoutInflater!!.inflate(R.layout.grid_main_item, parent, false)
            holder = ViewHolder()
            // Inicializa los elementos de la vista solo cuando convertView es nulo
            holder.imgMain = convertView.findViewById(R.id.imgMain)
            holder.txtMain = convertView.findViewById(R.id.txtMain)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }

        // Configura los elementos de la vista
        holder.imgMain?.setBackgroundResource(arrayModelMain[position].image)
        holder.txtMain?.text = arrayModelMain[position].tittle

        return convertView!!
    }


}

private class ViewHolder(){
    var imgMain:ImageView? = null
    var txtMain:TextView? = null
}