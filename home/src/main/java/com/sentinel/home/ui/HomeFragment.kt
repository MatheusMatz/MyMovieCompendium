package com.sentinel.home.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.sentinel.home.R
import com.sentinel.home.databinding.FragmentHomeBinding
import com.sentinel.home.ui.adapter.TrendyAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by activityViewModels()
    private val adapter = TrendyAdapter()

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            homeTrendyPage.trendyViewPager.adapter = adapter

            val compositePageTransformer = CompositePageTransformer();
            compositePageTransformer.addTransformer(MarginPageTransformer(40));
            compositePageTransformer.addTransformer { page, position ->
                val r = (1 - kotlin.math.abs(position))
                page.scaleY = 0.85f + r * 0.15f
            }

            homeTrendyPage.trendyViewPager.setPageTransformer(compositePageTransformer)

            homeTrendyPage.trendyViewPager.clipToPadding = false;
            homeTrendyPage.trendyViewPager.clipChildren = false;
            homeTrendyPage.trendyViewPager.offscreenPageLimit = 3;
            homeTrendyPage.trendyViewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER;
        }

        homeViewModel.loadHome()

        homeViewModel.trendiesMovies.observe(viewLifecycleOwner, {
            adapter.addTrendyMovies(it)
        })
    }
}
