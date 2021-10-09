package com.example.nytimes.screen.home



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.nytimes.R
import com.example.nytimes.data.model.ResultsItem

class HomeAdapter(
    val results: List<ResultsItem>,
    val listener : ItemClickListener
) : RecyclerView.Adapter<HomeAdapter.ViewHolder?>() {

    override fun getItemCount(): Int {
        return results.size
    }


    class ViewHolder(@param:NonNull val root: View?) : RecyclerView.ViewHolder(root!!) {
        val tvTitle: TextView? = root!!.findViewById(R.id.tvTitle)
        val tvAuthor: TextView? =root!!.findViewById(R.id.tvAuthor)
        val tvDate: TextView? = root!!.findViewById(R.id.tvDate)
        val ivItem: ImageView? = root!!.findViewById(R.id.ivItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: ResultsItem? = results!![position]
        holder.tvTitle!!.setText(item!!.title)
        holder.tvAuthor!!.setText(item.byline)
        holder.tvDate!!.setText(item.publishedDate)

        //ColorDrawable colorDrawable = new ColorDrawable(NYTimesUtils.getColor(R.color.colorPrimary));
        Glide.with(holder.root!!.context).load(item.uri)
            .apply(
                RequestOptions
                    .circleCropTransform()
                    .placeholder(R.drawable.image_place_holder)
            )
            .into(holder.ivItem!!)
        holder.root!!.setOnClickListener { v: View? ->
            listener.onItemClick(item.uri)
        }
    }

    interface ItemClickListener {
        fun onItemClick(item: String)
    }
}