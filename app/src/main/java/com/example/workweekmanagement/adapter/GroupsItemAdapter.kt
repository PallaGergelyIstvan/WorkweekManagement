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
import com.example.workweekmanagement.model.Groups

class GroupsItemAdapter(
    private val rv: RecyclerView,
    private val tuskupdatelinearlayout: LinearLayout,
    private val tuskupdatemenulinearlayout: LinearLayout,
    private val grouprvll: LinearLayout,
    private val buttonaddgroup: Button,
    private val groupid: TextView,
    private val groupnameforgroup: TextView,
    private val groupnameformember: TextView,
    private val groupnameformemberreal: TextView,
    private val groupmembernametext: TextView,
    private val groupparent: TextView,
    private val groupmemberid: TextView,
    private val groupname: EditText,
    private val groupmembername: EditText,
    private val buttonaddgroupmember: Button,
    private val context: Context,
    private val dataset: List<Groups>
) : RecyclerView.Adapter<GroupsItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textViewMemberName: TextView = view.findViewById(R.id.groupgroupmember)
        val textViewGroupName: TextView = view.findViewById(R.id.groupnameparent)
        val linearLayoutRv: LinearLayout = view.findViewById(R.id.groupRvLinearLayout)
        val linearLayoutRvParrent: LinearLayout = view.findViewById(R.id.groupRvLinearLayoutParent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item_groups, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]
        if (item.parent == 0) {
            if (!item.groupmembername.equals(null)) {
                holder.linearLayoutRvParrent.isGone = true
                holder.linearLayoutRv.isVisible = true
                holder.textViewMemberName.setText(item.groupmembername)
            }
        } else {
            holder.linearLayoutRvParrent.isVisible = true
            holder.linearLayoutRv.isGone = true
            holder.textViewGroupName.setText(item.groupname)
        }
        holder.itemView.setOnClickListener {
            buttonaddgroup.isGone = true
            grouprvll.isGone = true
            tuskupdatelinearlayout.isVisible = true
            tuskupdatemenulinearlayout.isVisible = true
            if (item.parent == 0) {
                groupid.setText(item.groupID.toString())
                groupnameforgroup.isGone = true
                groupname.isGone = true
                groupnameformember.isVisible = true
                groupnameformemberreal.isVisible = true
                groupnameformemberreal.setText(item.groupname)
                groupmembernametext.isVisible = true
                groupmembername.isVisible = true
                groupmembername.setText(item.groupmembername)
                buttonaddgroupmember.isGone = true
            } else {
                groupid.setText(item.groupID.toString())
                groupnameforgroup.isVisible = true
                groupname.isVisible = true
                groupname.setText(item.groupname)
                groupnameformember.isGone = true
                groupnameformemberreal.isGone = true
                groupnameformemberreal.setText(item.groupname)
                groupmembernametext.isGone = true
                groupmembername.isGone = true
                buttonaddgroupmember.isVisible = true
            }
            groupparent.setText(item.parent.toString())
            groupmemberid.setText(item.groupMemberID.toString())
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}