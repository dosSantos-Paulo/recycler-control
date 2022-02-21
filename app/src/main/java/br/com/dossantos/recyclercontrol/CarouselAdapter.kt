package br.com.dossantos.recyclercontrol

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dossantos.recyclercontrol.databinding.CarouselItemBinding
import br.com.dossantos.recyclercontrol.model.CarouselModel

class CarouselAdapter(
    private val list: MutableList<CarouselModel>,
    private val onClick: (CarouselModel) -> Unit
) : RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {
    class ViewHolder(val binding: CarouselItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: CarouselModel, onClick: (CarouselModel) -> Unit) {
            binding.title.text = model.title
            binding.message.text = model.message
            binding.root.setOnClickListener { onClick(model) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CarouselItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position], onClick)
    }

    override fun getItemCount() = list.size
}