package com.android.buddhapalace.quotes.ui.quotes

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DefaultItemAnimator
import com.android.buddhapalace.quotes.MainActivity
import com.android.buddhapalace.quotes.R
import com.android.buddhapalace.quotes.ui.quotes.adapter.CallbackCardAdapter
import com.android.buddhapalace.quotes.ui.quotes.adapter.CardQuoteAdapter
import com.android.data.database.entity.quotes.Quote
import com.yuyakaido.android.cardstackview.*
import kotlinx.android.synthetic.main.quotes_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuotesFragment : Fragment(R.layout.quotes_fragment), CardStackListener {

    private val viewModel: QuotesViewModel by viewModel()

    private val manager by lazy { CardStackLayoutManager(requireActivity(), this) }
    private val adapter by lazy { CardQuoteAdapter(createQuotes(), clickButton()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { state -> render(state = state) }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            (requireActivity() as MainActivity).onBackPressedLast()
        }

        initialize()
    }

    private fun render(state: QuotesState) {
        when (state) {
            QuotesState.Suspense -> {
            }
            QuotesState.Loading -> {
            }
        }
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
    }

    override fun onCardRewound() {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }

    private fun createQuotes(): List<Quote> {
        val quotes = ArrayList<Quote>()
        quotes.add(
            Quote(
                id = 0,
                like = false,
                autor = "Buddha & Love: Timeless Wisdom for Modern Relationships (2012)",
                date = "September 18th",
                text = "A generous relationship rarely knows dramas. One is happy when the partner is happy. And one is happy when growing on three levels: on the physical level, which gives love, material things, and protection; on the inner level — through compassion and wisdom — which provides the motivation for development; and on a deep-lying, secret level where both partners enrich themselves with the qualities of the other and increasingly find their center.B"
            )
        )
        quotes.add(
            Quote(
                id = 0,
                like = false,
                autor = "Buddha & Love: Timeless Wisdom for Modern Relationships (2012)",
                date = "October 21th",
                text = "A generous relationship rarely knows dramas. One is happy when the partner is happy. And one is happy when growing on three levels: on the physical level, which gives love, material things, and protection; on the inner level — through compassion and wisdom — which provides the motivation for development; and on a deep-lying, secret level where both partners enrich themselves with the qualities of the other and increasingly find their center."
            )
        )
        quotes.add(
            Quote(
                id = 0,
                like = true,
                autor = "Buddha & Love: Timeless Wisdom for Modern Relationships (2012)",
                date = "November 15th",
                text = "A generous relationship rarely knows dramas. One is happy when the partner is happy. And one is happy when growing on three levels: on the physical level, which gives love, material things, and protection; on the inner level — through compassion and wisdom — which provides the motivation for development; and on a deep-lying, secret level where both partners enrich themselves with the qualities of the other and increasingly find their center."
            )
        )
        quotes.add(
            Quote(
                id = 0,
                like = false,
                autor = "Buddha & Love: Timeless Wisdom for Modern Relationships (2012)",
                date = "September 15th",
                text = "A generous relationship rarely knows dramas. One is happy when the partner is happy. And one is happy when growing on three levels: on the physical level, which gives love, material things, and protection; on the inner level — through compassion and wisdom — which provides the motivation for development; and on a deep-lying, secret level where both partners enrich themselves with the qualities of the other and increasingly find their center."
            )
        )
        quotes.add(
            Quote(
                id = 0,
                like = true,
                autor = "Buddha & Love: Timeless Wisdom for Modern Relationships (2012)",
                date = "September 15th",
                text = "A generous relationship rarely knows dramas. One is happy when the partner is happy. And one is happy when growing on three levels: on the physical level, which gives love, material things, and protection; on the inner level — through compassion and wisdom — which provides the motivation for development; and on a deep-lying, secret level where both partners enrich themselves with the qualities of the other and increasingly find their center."
            )
        )


        return quotes
    }

    private fun initialize() {
        manager.setStackFrom(StackFrom.Bottom)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(12.0f)
        manager.setScaleInterval(0.88f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(80.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        card_stack_view.layoutManager = manager
        card_stack_view.adapter = adapter
        card_stack_view.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    override fun onStart() {
        super.onStart()
        (requireActivity() as MainActivity).setStateBackGround(false)
    }

    private fun clickButton() =
        object : CallbackCardAdapter {
            override fun back() {
                val setting = RewindAnimationSetting.Builder()
                    .setDirection(Direction.Bottom)
                    .setDuration(Duration.Slow.duration)
                    .setInterpolator(DecelerateInterpolator())
                    .build()
                manager.setRewindAnimationSetting(setting)
                card_stack_view.rewind()
            }

            override fun early() {
                val setting = SwipeAnimationSetting.Builder()
                    .setDirection(Direction.Left)
                    .setDuration(Duration.Slow.duration)
                    .setInterpolator(AccelerateInterpolator())
                    .build()
                manager.setSwipeAnimationSetting(setting)
                card_stack_view.swipe()
            }

            override fun like(state: Boolean) {

            }
        }

}