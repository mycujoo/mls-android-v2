package tv.mycujoo.cast

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import tv.mycujoo.cast.databinding.ItemEventBinding
import tv.mycujoo.mclscore.model.MCLSEventListItem
import java.util.*

class MCLSEventsAdapter(
    private val onClick: (MCLSEventListItem) -> Unit
) : RecyclerView.Adapter<MCLSEventsAdapter.MCLSEventVH>() {

    private val eventList = ArrayList<MCLSEventListItem>()

    private var activeEventId: String? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setActiveEventId(eventId: String) {
        this.activeEventId = eventId
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(events: List<MCLSEventListItem>) {
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

        fun bind(event: MCLSEventListItem) {
            binding.title.text = event.title
            binding.dateAndTime.text = event.getFormattedStartTimeDate(Locale.ENGLISH)
            binding.play.setOnClickListener {
                onClick(event)
            }

            if (activeEventId == event.id) {
                binding.play.setImageDrawable(
                    ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.baseline_pause_circle_24
                    )
                )
            } else {
                binding.play.setImageDrawable(
                    ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.baseline_play_circle_24
                    )
                )
            }
        }
    }
}