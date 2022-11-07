package com.example.ecommerceconcept.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.HotSales
import com.example.ecommerceconcept.adapters.*
import com.example.ecommerceconcept.databinding.FragmentHomeStoreBinding
import com.example.ecommerceconcept.presentation.viewmodel.HomeStoreViewModel
import com.example.ecommerceconcept.utils.AnimePageTransformer
import com.example.ecommerceconcept.utils.BaseFragment
import com.example.ecommerceconcept.utils.ItemOffsetDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeStoreFragment: BaseFragment<FragmentHomeStoreBinding>(FragmentHomeStoreBinding::inflate) {

    private val viewModel: HomeStoreViewModel by viewModels()
    private var categoryAdapter: CategoryAdapter? = null
    private var hotSalesAdapter: HotSalesAdapter? = null
    private var bestSellerAdapter: BestSellerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapters()
        initLists()
        observeViewModel()

    }

    private fun initAdapters(){
        categoryAdapter = CategoryAdapter {
            viewModel.onSelectedCategory(it)
        }
        hotSalesAdapter = HotSalesAdapter {  }
        bestSellerAdapter = BestSellerAdapter {  }

    }

    private fun initLists(){
        with(binding.categoryList){
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            addItemDecoration(ItemOffsetDecoration(requireContext()))
        }

        with(binding.viewPager){
            adapter = hotSalesAdapter
            offscreenPageLimit = 1
            addItemDecoration(ItemOffsetDecoration(requireContext()))
            setPageTransformer(AnimePageTransformer())
        }

        with(binding.itemList){
            adapter = bestSellerAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)

        }
    }

    private fun observeViewModel() {
        viewModel.uiStateLiveData.observe(viewLifecycleOwner){
            categoryAdapter?.items = it.categories
            when{
                0 -> hotSalesAdapter?.items = it.hotSalesPhones.filter { it is HotSales.Phones }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        categoryAdapter = null
        hotSalesAdapter = null
        bestSellerAdapter = null
        //entityAdapter = null
        //pagerAdapter = null
    }


}