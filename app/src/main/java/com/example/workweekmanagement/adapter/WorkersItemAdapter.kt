package com.example.workweekmanagement.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.workweekmanagement.R
import com.example.workweekmanagement.model.Workers

class WorkersItemAdapter(
    private val rv: RecyclerView,
    private val tuskupdatelinearlayout: LinearLayout,
    private val tuskupdatemenulinearlayout: LinearLayout,
    private val workerrvll: LinearLayout,
    private val buttonaddworker: Button,
    private val workername: EditText,
    private val workeremail: EditText,
    private val workerstrength: EditText,
    private val workerid: TextView,
    private val context: Context,
    private val dataset: List<Workers>
) : RecyclerView.Adapter<WorkersItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.workername)
        val textViewEmail: TextView = view.findViewById(R.id.workeremail)
        val textViewStrength: TextView = view.findViewById(R.id.workerstrength)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item_workers, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]
        holder.textViewName.setText(item.workername)
        holder.textViewEmail.setText(item.workeremail)
        holder.textViewStrength.setText(item.workerstrength.toString())
        holder.itemView.setOnClickListener {
            buttonaddworker.isGone = true
            workerrvll.isGone = true
            tuskupdatelinearlayout.isVisible = true
            tuskupdatemenulinearlayout.isVisible = true
            workerid.setText(item.workerID.toString())
            workername.setText(item.workername)
            workeremail.setText(item.workeremail)
            workerstrength.setText(item.workerstrength.toString())
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}