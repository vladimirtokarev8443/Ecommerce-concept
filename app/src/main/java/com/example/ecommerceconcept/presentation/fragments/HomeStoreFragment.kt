package com.example.ecommerceconcept.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.adapters.home.BestSellerAdapter
import com.example.ecommerceconcept.adapters.home.CategoryAdapter
import com.example.ecommerceconcept.adapters.home.HotSalesAdapter
import com.example.ecommerceconcept.databinding.FragmentHomeStoreBinding
import com.example.ecommerceconcept.presentation.viewmodel.HomeStoreViewModel
import com.example.ecommerceconcept.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeStoreFragment: BaseFragment<FragmentHomeStoreBinding>(FragmentHomeStoreBinding::inflate) {

    private val viewModel: HomeStoreViewModel by viewModels()
    private var categoryAdapter: CategoryAdapter? = null
    private var hotSalesAdapter: HotSalesAdapter? = null
    private var bestSellerAdapter: BestSellerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigation.setupWithNavController(findNavController())

        initLists()
        observeViewModel()
        createBadgeToCart()
        initFilter()
        filterListeners()

    }

    private fun initLists(){
        initCategory()
        initHotSales()
        initBestSeller()
    }

    private fun initCategory(){
        categoryAdapter = CategoryAdapter {
            viewModel.onSelectedCategory(it)
        }
        with(binding.categoryList){
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            addItemDecoration(ItemOffsetCategory(requireContext()))
        }
    }

    private fun initHotSales(){
        with(binding.viewPager){
            hotSalesAdapter = HotSalesAdapter {  }
            adapter = hotSalesAdapter
            offscreenPageLimit = 1
            addItemDecoration(ItemOffsetHotSales(requireContext()))
            setPageTransformer(ZoomOutTransformation())
        }
    }

    private fun initBestSeller(){
        with(binding.itemList){
            bestSellerAdapter = BestSellerAdapter {
                findNavController().navigate(HOME_TO_DETAILS)
            }
            adapter = bestSellerAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
            addItemDecoration(ItemOffsetBestSeller(requireContext()))
        }
    }

    private fun observeViewModel() {
        viewModel.uiStateLiveData.observe(viewLifecycleOwner){
            categoryAdapter?.items = it.categories
            hotSalesAdapter?.items = it.hotSalesPhones
            bestSellerAdapter?.items = it.bestSellerPhones
        }
    }

    private fun initFilter(){
        val adapterBrand = ArrayAdapter(requireContext(), R.layout.item_auto_complete_text, resources.getStringArray(R.array.brand))
        (binding.brandTextImput.editText as? AutoCompleteTextView)?.setAdapter(adapterBrand)

        val adapterPrice = ArrayAdapter(requireContext(), R.layout.item_auto_complete_text, resources.getStringArray(R.array.price))
        (binding.priceTextImput.editText as? AutoCompleteTextView)?.setAdapter(adapterPrice)

    }

    private fun filterListeners(){
        binding.toolbar.setOnMenuItemClickListener {
            binding.bottomContainer.transitionToEnd()
            true
        }
        binding.closeButton.setOnClickListener {
            binding.bottomContainer.transitionToStart()
        }
    }

    private fun createBadgeToCart(){
        binding.bottomNavigation.getOrCreateBadge(R.id.cartFragment).apply {
            number = 2
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        categoryAdapter = null
        hotSalesAdapter = null
        bestSellerAdapter = null

    }

}