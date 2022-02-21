package br.com.dossantos.recyclercontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dossantos.recyclercontrol.Mock.Companion.getItemsFromIt
import br.com.dossantos.recyclercontrol.databinding.ActivityMainBinding
import br.com.dossantos.recyclercontrol.model.BodyAdapter

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var carouselList = Mock.getCarousel()

    /** Lista inicia com o primeiro item do carrosel */
    private var bodyList = carouselList[0].getItemsFromIt()

    private var bodyAdapter = BodyAdapter(bodyList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecycler()
    }

    fun setupRecycler() {
        binding.carousel.apply {
            adapter = CarouselAdapter(carouselList) {newCarouselModel ->
                bodyList.clear()
                bodyList.addAll(newCarouselModel.getItemsFromIt())
                bodyAdapter.refreshItems()
            }
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        binding.bodyRecycler.apply {
            bodyAdapter.setFatherRecycler(this)
            adapter = bodyAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}