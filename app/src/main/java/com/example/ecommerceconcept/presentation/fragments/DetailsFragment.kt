package com.example.ecommerceconcept.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.models.DetailsProduct
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.adapters.details.DetailsAdapter
import com.example.ecommerceconcept.adapters.details.ImageAdapter
import com.example.ecommerceconcept.databinding.FragmentDetailsBinding
import com.example.ecommerceconcept.presentation.viewmodel.DetailsViewModel
import com.example.ecommerceconcept.utils.BaseFragment
import com.example.ecommerceconcept.utils.DETAILS_TO_CART
import com.example.ecommerceconcept.utils.getShop
import com.google.android.material.tabs.TabLayoutMediator
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.mig35.carousellayoutmanager.CenterScrollListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment: BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val viewModel: DetailsViewModel by viewModels()
    private var imageAdapter: ImageAdapter? = null
    private var detailsAdapter: DetailsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initImageList()
        initDetailsViewPager()
        observeViewModel()

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.toCartButton.setOnClickListener {
            findNavController().navigate(DETAILS_TO_CART)
        }

    }

    private fun initImageList(){
        imageAdapter = ImageAdapter()
        with(binding.imageRecycler){
            adapter = imageAdapter
            layoutManager = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true).apply {
                setPostLayoutListener(CarouselZoomPostLayoutListener(0.7f))
            }
            setHasFixedSize(true)
            addOnScrollListener(CenterScrollListener())

        }
    }

    private fun initDetailsViewPager(){
        detailsAdapter = DetailsAdapter()
        with(binding.detailsViewPager){
            adapter = detailsAdapter
            offscreenPageLimit = 1
        }

    }

    private fun observeViewModel(){
        viewModel.detailsLiveData.observe(viewLifecycleOwner){
            binding.titleTextView.text = it.title
            binding.ratingBar.rating = it.rating
            binding.priceTextView.text = getString(R.string.price_string_with_usd, it.price)
            binding.favoritesButton.foregroundTintList = resources.getColorStateList(if (it.isFavorites) R.color.orange else R.color.white, null)

            imageAdapter?.updateItems(it.images)

            setItemsDetailsAdapter(it)
        }
    }

    private fun setItemsDetailsAdapter(it: DetailsProduct){
        detailsAdapter?.items = listOf(it.getShop(0), it.getShop(1), it.getShop(2))
        initTabs()
    }

    private fun initTabs(){
        TabLayoutMediator(binding.tabLayout, binding.detailsViewPager){tab, position ->

            tab.text = when(position){
                0 -> getString(R.string.details_tab_shop)
                1 -> getString(R.string.details_tab_details)
                else -> getString(R.string.details_tab_feature)
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        imageAdapter = null
        detailsAdapter = null
    }
}