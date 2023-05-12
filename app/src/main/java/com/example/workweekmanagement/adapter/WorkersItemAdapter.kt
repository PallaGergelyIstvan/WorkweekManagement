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
    private val workertitle: EditText,
    private val workerstart: EditText,
    private val workerend: EditText,
    private val workercomment: EditText,
    private val workerfinished: EditText,
    private val workerid: TextView,
    private val workerclosed: CheckBox,
    private val context: Context,
    private val dataset: List<Workers> ) :
    RecyclerView.Adapter<WorkersItemAdapter.ItemViewHolder>()
{

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view)
    {
        val textViewName: TextView = view.findViewById(R.id.workername)
        val textViewEmail: TextView = view.findViewById(R.id.workeremail)
        val textViewTitle: TextView = view.findViewById(R.id.workerworkertitle)
        val textViewStart: TextView = view.findViewById(R.id.workerworkerstart)
        val textViewEnd: TextView = view.findViewById(R.id.workerworkerend)
        val textViewComment: TextView = view.findViewById(R.id.workercomment)
        val textViewFinished: TextView = view.findViewById(R.id.workerfinished)
        val textViewClosed: TextView = view.findViewById(R.id.workerclosed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_workers, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]
        val closed: String
        if(item.closed == 0){
            closed = "folyamatban"
        } else {
            closed = "lezárva"
        }
        holder.textViewName.setText(item.name)
        holder.textViewEmail.setText(item.workeremail)
        holder.textViewTitle.setText(item.workertitle)
        holder.textViewStart.setText(item.workerstart)
        holder.textViewEnd.setText(item.workerend)
        holder.textViewComment.setText(item.comment)
        holder.textViewFinished.setText(item.finished)
        holder.textViewClosed.setText(closed)
        holder.itemView.setOnClickListener {
            buttonaddworker.isGone = true
            workerrvll.isGone = true
            tuskupdatelinearlayout.isVisible = true
            tuskupdatemenulinearlayout.isVisible = true
            workerclosed.isChecked = item.closed != 0
            workerid.setText(item.workerID.toString())
            workername.setText(item.name)
            workertitle.setText(item.workertitle)
            workerstart.setText(item.workerstart)
            workerend.setText(item.workerend)
            workercomment.setText(item.comment)
            workerfinished.setText(item.finished)
            Toast.makeText(context, item.workertitle, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}