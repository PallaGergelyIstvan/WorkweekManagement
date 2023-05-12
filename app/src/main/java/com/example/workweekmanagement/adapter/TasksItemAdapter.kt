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
import com.example.workweekmanagement.model.Tasks

class TasksItemAdapter(
    private val rv: RecyclerView,
    private val tuskupdatelinearlayout: LinearLayout,
    private val tuskupdatemenulinearlayout: LinearLayout,
    private val taskrvll: LinearLayout,
    private val buttonaddtask: Button,
    private val taskname: EditText,
    private val tasktitle: EditText,
    private val taskstart: EditText,
    private val taskend: EditText,
    private val taskcomment: EditText,
    private val taskfinished: EditText,
    private val taskid: TextView,
    private val taskclosed: CheckBox,
    private val context: Context,
    private val dataset: List<Tasks> ) :
    RecyclerView.Adapter<TasksItemAdapter.ItemViewHolder>()
{

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view)
    {
        val textViewName: TextView = view.findViewById(R.id.taskname)
        val textViewEmail: TextView = view.findViewById(R.id.taskemail)
        val textViewTitle: TextView = view.findViewById(R.id.tasktasktitle)
        val textViewStart: TextView = view.findViewById(R.id.tasktaskstart)
        val textViewEnd: TextView = view.findViewById(R.id.tasktaskend)
        val textViewComment: TextView = view.findViewById(R.id.taskcomment)
        val textViewFinished: TextView = view.findViewById(R.id.taskfinished)
        val textViewClosed: TextView = view.findViewById(R.id.taskclosed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_tasks, parent, false)
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
        holder.textViewTitle.setText(item.tasktitle)
        holder.textViewStart.setText(item.taskstart)
        holder.textViewEnd.setText(item.taskend)
        holder.textViewComment.setText(item.comment)
        holder.textViewFinished.setText(item.finished)
        holder.textViewClosed.setText(closed)
        holder.itemView.setOnClickListener {
            buttonaddtask.isGone = true
            taskrvll.isGone = true
            tuskupdatelinearlayout.isVisible = true
            tuskupdatemenulinearlayout.isVisible = true
            taskclosed.isChecked = item.closed != 0
            taskid.setText(item.taskID.toString())
            taskname.setText(item.name)
            tasktitle.setText(item.tasktitle)
            taskstart.setText(item.taskstart)
            taskend.setText(item.taskend)
            taskcomment.setText(item.comment)
            taskfinished.setText(item.finished)
            Toast.makeText(context, item.tasktitle, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}