package br.com.dossantos.recyclercontrol.model

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dossantos.recyclercontrol.databinding.BodyItemBinding

class BodyAdapter(var list: MutableList<BodyModel>, ) :
    RecyclerView.Adapter<BodyAdapter.ViewHolder>() {

    private lateinit var outBinding: BodyItemBinding
    private lateinit var fatherRecycler: RecyclerView

    class ViewHolder(val binding: BodyItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(bodyModel: BodyModel) {
            binding.text1.text = bodyModel.text1
            binding.text2.text = bodyModel.text2
            binding.text3.text = bodyModel.text3
            binding.text4.text = bodyModel.text4
            binding.text5.text = bodyModel.text5
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        outBinding = BodyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(outBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    fun setFatherRecycler(newRecyclerView: RecyclerView) {
        fatherRecycler = newRecyclerView
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshItems() {
        fatherRecycler.animate().apply {
            alpha(0f)
            duration = 500L
        }.withEndAction {
            notifyDataSetChanged()
            fatherRecycler.animate().apply {
                alpha(1f)
                duration = 500L
            }
        }
    }
}