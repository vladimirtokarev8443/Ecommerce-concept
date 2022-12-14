package com.example.ecommerceconcept.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.Cart
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.adapters.cart.BasketAdapter
import com.example.ecommerceconcept.databinding.FragmentCartBinding
import com.example.ecommerceconcept.presentation.viewmodel.CartViewModel
import com.example.ecommerceconcept.utils.BaseFragment
import com.example.ecommerceconcept.utils.ItemOffsetBasket
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate) {

    private val viewModel: CartViewModel by viewModels()
    private var basketAdapter: BasketAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBasketList()
        observeViewModel()

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initBasketList() {
        basketAdapter = BasketAdapter()
        with(binding.cartRecycler) {
            adapter = basketAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(ItemOffsetBasket(requireContext()))
            setHasFixedSize(true)
        }
    }

    private fun observeViewModel() {
        viewModel.cartLiveData.observe(viewLifecycleOwner, ::bindCart)
    }

    private fun bindCart(cart: Cart) {
        basketAdapter?.items = cart.basketList
        binding.totalResultTextView.text = getString(R.string.cart_total_result, cart.total)
        binding.deliveryResultTextView.text = cart.delivery
    }

    override fun onDestroyView() {
        super.onDestroyView()
        basketAdapter = null
    }
}