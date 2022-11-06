package com.example.ecommerceconcept.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceconcept.adapters.CategoryAdapter
import com.example.ecommerceconcept.adapters.EntityAdapter
import com.example.ecommerceconcept.adapters.PagerAdapter
import com.example.ecommerceconcept.databinding.FragmentHomeStoreBinding
import com.example.ecommerceconcept.presentation.viewmodel.HomeStoreViewModel
import com.example.ecommerceconcept.utils.AnimePageTransformer
import com.example.ecommerceconcept.utils.BaseFragment
import com.example.ecommerceconcept.utils.ItemOffsetDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeStoreFragment: BaseFragment<FragmentHomeStoreBinding>(FragmentHomeStoreBinding::inflate) {

    private val viewModel: HomeStoreViewModel by viewModels()
    private var entityAdapter: EntityAdapter? = null
    private var pagerAdapter: EntityAdapter? = null
    private var categoryAdapter: CategoryAdapter? = null

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
        pagerAdapter = EntityAdapter {  }

        entityAdapter = EntityAdapter {  }

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
            adapter = pagerAdapter
            offscreenPageLimit = 1
            addItemDecoration(ItemOffsetDecoration(requireContext()))
            setPageTransformer(AnimePageTransformer())
        }

        with(binding.itemList){
            adapter = entityAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)

        }
    }

    private fun observeViewModel(){
        viewModel.categoryLiveData.observe(viewLifecycleOwner){
            categoryAdapter?.items = it
        }
        viewModel.hotSalesLiveData.observe(viewLifecycleOwner){
            pagerAdapter?.items = it
            //pagerAdapter?.notifyItemRangeChanged(0,it.size)
        }
        viewModel.bestSellerLiveData.observe(viewLifecycleOwner){
            Log.d("qqq", "$it")
            entityAdapter?.items = it
        }
    }

    private fun getGridLayout(): GridLayoutManager{
        return GridLayoutManager(requireContext(), 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
                override fun getSpanSize(position: Int): Int {
                    return when(position){
                        0 -> 1
                        else -> 2
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        entityAdapter = null
        categoryAdapter = null
        pagerAdapter = null
    }

    companion object{
        const val CATEGORY = 0
    }
}