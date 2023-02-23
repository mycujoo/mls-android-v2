package tv.mycujoo.network

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tv.mycujoo.network.databinding.ItemEventBinding
import tv.mycujoo.mclscore.model.MCLSEvent
import java.util.*
import kotlin.collections.ArrayList

class MCLSEventsAdapter(
    private val onClick: (MCLSEvent) -> Unit
) : RecyclerView.Adapter<MCLSEventsAdapter.MCLSEventVH>() {

    private val eventList = ArrayList<MCLSEvent>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(events: List<MCLSEvent>) {
        eventList.clear()
        eventList.addAll(events)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MCLSEventVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEventBinding.inflate(layoutInflater, parent, false)
        return MCLSEventVH(binding)
    }

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(holder: MCLSEventVH, position: Int) {
        holder.bind(eventList[position])
    }

    inner class MCLSEventVH(
        private val binding: ItemEventBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(event: MCLSEvent) {
            binding.title.text = event.title
            binding.dateAndTime.text = event.getFormattedStartTimeDate(Locale.ENGLISH)
            binding.status.text = event.status.name.split("_").last()

            binding.root.setOnClickListener {
                onClick(event)
            }
        }
    }
}