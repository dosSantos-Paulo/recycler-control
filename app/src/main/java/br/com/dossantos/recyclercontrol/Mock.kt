package br.com.dossantos.recyclercontrol

import br.com.dossantos.recyclercontrol.model.BodyModel
import br.com.dossantos.recyclercontrol.model.CarouselModel

class Mock {
    companion object {
        fun getCarousel(): MutableList<CarouselModel> {
            val list = mutableListOf<CarouselModel>()
            for (i in 0..10) {
                list.add(CarouselModel("Título $i", "Mensagem $i"))
            }
            return list
        }

        fun CarouselModel.getItemsFromIt(): MutableList<BodyModel> {
            val list = mutableListOf<BodyModel>()
            for (i in 0..10) {
                list.add(
                    BodyModel(
                    " ${this.title} ** Mensagem 1",
                    " ${this.title} ** Mensagem 2",
                    " ${this.title} ** Mensagem 3",
                    " ${this.title} ** Mensagem 4",
                    " ${this.title} ** Mensagem 5",
                )
                )
            }
            return list
        }
    }
}