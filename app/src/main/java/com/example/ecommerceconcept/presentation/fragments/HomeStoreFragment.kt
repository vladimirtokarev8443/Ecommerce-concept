package com.example.ecommerceconcept.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceconcept.adapters.*
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

        initLists()
        observeViewModel()

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
            setPageTransformer(AnimePageTransformer())
        }
    }

    private fun initBestSeller(){
        with(binding.itemList){
            bestSellerAdapter = BestSellerAdapter {  }
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

    private fun openFilter(){
        binding.navigationGroup.isVisible = true
        binding.filterGroup.isVisible = true
//        val items = listOf("Material", "Design", "Components", "Android")
//        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
//        (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }

    private fun closeFilter(){}

    override fun onDestroyView() {
        super.onDestroyView()
        categoryAdapter = null
        hotSalesAdapter = null
        bestSellerAdapter = null

    }


}