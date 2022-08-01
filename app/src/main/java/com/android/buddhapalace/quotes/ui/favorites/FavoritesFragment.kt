package com.android.buddhapalace.quotes.ui.favorites

import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.buddhapalace.quotes.MainActivity
import com.android.buddhapalace.quotes.R
import com.android.buddhapalace.quotes.ui.allglobal.UpdateQuotes
import com.android.buddhapalace.quotes.ui.allglobal.extentions.makeGone
import com.android.buddhapalace.quotes.ui.allglobal.extentions.makeVisible
import com.android.buddhapalace.quotes.ui.allglobal.extentions.toast
import com.android.buddhapalace.quotes.ui.favorites.adapter.CallbackFavoritesCardAdapter
import com.android.buddhapalace.quotes.ui.favorites.adapter.FavoritesCardAdapter
import com.android.buddhapalace.quotes.ui.favorites.adapter.SwipeControllerActionsDelete
import com.android.buddhapalace.quotes.ui.favorites.adapter.SwipeControllerProduct
import com.android.data.database.entity.quotes.Quote
import kotlinx.android.synthetic.main.favorites_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : Fragment(R.layout.favorites_fragment), CallbackFavoritesCardAdapter,
    UpdateQuotes {

    private val viewModel: FavoritesViewModel by viewModel()

    private val adapterRecycler by lazy { FavoritesCardAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { state -> render(state = state) }
        initData()
        initListener()
    }

    private fun initData() {
        recycler_favorite.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = adapterRecycler

            val swipeControllerProduct =
                SwipeControllerProduct(requireActivity(), object : SwipeControllerActionsDelete() {
                    override fun onRightClicked(position: Int) {
                        val quote = adapterRecycler.getTaskForPosition(position)
                        adapterRecycler.deleteItem(position)
                        (requireActivity() as MainActivity).update(quote)
                        viewModel.deleteItem(quote)
                    }
                })

            val itemTouchHelper = ItemTouchHelper(swipeControllerProduct)
            itemTouchHelper.attachToRecyclerView(this)
            this.addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                    swipeControllerProduct.onDraw(c)
                }
            })
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden)
            viewModel.setQuotes()

    }

    private fun initListener() {

    }

    override fun deleteItemAdapter(id: Int) {
    }

    private fun render(state: FavoritesState) {
        when (state) {
            is FavoritesState.Suspense -> {
            }
            is FavoritesState.Loading -> {

            }
            is FavoritesState.Success -> setListAdapter(list = state.list)

            is FavoritesState.Error -> {
                toast(state.message, Toast.LENGTH_SHORT)
            }
            is FavoritesState.EmptyList -> {
                adapterRecycler.setQuotes(mutableListOf())
                list_no_item.makeVisible()
            }
        }
    }

    private fun setListAdapter(list: List<Quote>) {
        list_no_item.makeGone()
        adapterRecycler.setQuotes(list)
    }

    override fun update(quote: Quote) {

    }
}