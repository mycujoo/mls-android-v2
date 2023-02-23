package tv.mycujoo.network

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.network.databinding.ItemActionBinding

class ActionsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val annotationActionsList = ArrayList<AnnotationAction>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitAnnotationActions(actions: List<AnnotationAction>) {
        annotationActionsList.clear()
        annotationActionsList.addAll(actions)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemActionBinding.inflate(inflater, parent, false)

        if (viewType == 0) {
            return EmptyResultVH(binding)
        }

        return ActionsAdapterVH(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return if (annotationActionsList.isEmpty()) {
            0
        } else {
            1
        }
    }
    override fun getItemCount(): Int {
        return if (annotationActionsList.size != 0) {
            annotationActionsList.size
        } else {
            1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ActionsAdapterVH) {
            holder.bind(annotationActionsList[position])
        }
    }

    class ActionsAdapterVH(
        private val binding: ItemActionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(action: AnnotationAction) {
            binding.actionType.text = action.javaClass.simpleName
        }
    }

    class EmptyResultVH(
        binding: ItemActionBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.actionType.text = "Empty Actions List"
        }
    }
}