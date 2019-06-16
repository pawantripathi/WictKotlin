package org.wictphiladelphia.wict.adaptors

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import org.wictphiladelphia.wict.R


import org.wictphiladelphia.wict.models.Biodata;
import android.content.Context
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.bios_row_item.view.*


class BiosAdapter(private val biosList: ArrayList<Biodata>,
                  private val context: Context,
                  private val listener: (Biodata) -> Unit) : RecyclerView.Adapter<BiosViewHolder>() {

    private var glide: RequestManager?= null

    init {
        glide = Glide.with(context)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BiosViewHolder {

        return BiosViewHolder(LayoutInflater.from(context).inflate(R.layout.bios_row_item, parent, false))
    }

    override fun getItemCount(): Int {
        return biosList.size
    }


    override fun onBindViewHolder(holder: BiosViewHolder, position: Int) {


        val biodata = biosList.get(position)
        if (biodata == null){
            Log.d("bios", biodata.toString());

        }

        holder.nameView.text = biodata.name
        holder.designationView.text = biodata.designation
//        holder.avatarView.setImageResource(biodata.imageRes)
        glide!!.load(biodata.imageRes).into(holder.avatarView)


        holder.itemView.setOnClickListener {
            listener(biodata)
        }




    }


}

class BiosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameView: TextView = view.name
    val designationView: TextView = view.designation
    val avatarView: ImageView = view.avatar

}
