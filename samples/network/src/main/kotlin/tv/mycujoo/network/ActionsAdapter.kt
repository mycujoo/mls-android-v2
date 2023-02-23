package tv.mycujoo.network

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.network.databinding.ItemActionBinding

class ActionsAdapter : RecyclerView.Adapter<ActionsAdapter.ActionsAdapterVH>() {

    private val annotationActionsList = ArrayList<AnnotationAction>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitAnnotationActions(actions: List<AnnotationAction>) {
        annotationActionsList.clear()
        annotationActionsList.addAll(actions)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionsAdapterVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemActionBinding.inflate(inflater, parent, false)
        return ActionsAdapterVH(binding)
    }

    override fun getItemCount(): Int = annotationActionsList.size

    override fun onBindViewHolder(holder: ActionsAdapterVH, position: Int) {
        holder.bind(annotationActionsList[position])
    }

    class ActionsAdapterVH(
        private val binding: ItemActionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(action: AnnotationAction) {
            binding.actionType.text = action.javaClass.simpleName
        }
    }
}