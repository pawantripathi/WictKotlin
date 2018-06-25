package wict.wictphiladelphia.org.wict.adaptors

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.bios_row_item.view.*
import kotlinx.android.synthetic.main.schedule_row_item.view.*
import org.w3c.dom.Text
import wict.wictphiladelphia.org.wict.R
import wict.wictphiladelphia.org.wict.models.Biodata
import wict.wictphiladelphia.org.wict.models.Schedule

class BiosAdapter(private val biosList: ArrayList<Biodata>,
                  private val context: Context,
                  private val listener: (Biodata) -> Unit) : RecyclerView.Adapter<BiosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BiosViewHolder {

        return BiosViewHolder(LayoutInflater.from(context).inflate(R.layout.bios_row_item, parent, false))
    }

    override fun getItemCount(): Int {
        return biosList.size
    }


    override fun onBindViewHolder(holder: BiosViewHolder, position: Int) {

        val biodata = biosList.get(position)
        holder.nameView.text = biodata.name
        holder.designationView.text = biodata.designation
        holder.avatarView.setImageResource(biodata.imageRes)


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
