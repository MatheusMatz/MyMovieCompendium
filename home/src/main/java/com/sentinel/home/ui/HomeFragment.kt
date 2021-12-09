package com.sentinel.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.forfun.category.presenter.GenreAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.sentinel.home.databinding.FragmentHomeBinding
import com.sentinel.home.databinding.PagerHighlightBinding
import com.sentinel.home.ui.adapter.PopularAdapter
import com.sentinel.home.ui.adapter.TrendyAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by activityViewModels()

    private val trendyAdapter by lazy {
        TrendyAdapter()
    }

    private val popularAdapter by lazy {
        PopularAdapter()
    }

    private val genreAdapter by lazy {
        GenreAdapter()
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val concatAdapter = ConcatAdapter(trendyAdapter, popularAdapter, genreAdapter)

        with(binding.root) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = concatAdapter
        }

        homeViewModel.loadHome()

        homeViewModel.trendiesMovies.observe(viewLifecycleOwner, {
            trendyAdapter.addTrendyMovies(it)
        })

        homeViewModel.popularMoviesMovies.observe(viewLifecycleOwner, {
            popularAdapter.setMovieList(it)
        })

        homeViewModel.genreMovieLiveData.observe(viewLifecycleOwner, {
            genreAdapter.submitList(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun highlightListSetup(pagerHighlightBinding: PagerHighlightBinding) {
        val trendyViewPager = pagerHighlightBinding.trendyViewPager

        val trendyTabs = pagerHighlightBinding.trendyTabs

        trendyViewPager.adapter = trendyAdapter

        TabLayoutMediator(trendyTabs, trendyViewPager) { _, _ ->
        }.attach()


        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = (1 - abs(position))
            page.scaleY = 0.85f + r * 0.15f
        }

        trendyViewPager.setPageTransformer(compositePageTransformer)

        trendyViewPager.clipToPadding = false
        trendyViewPager.clipChildren = false
        trendyViewPager.offscreenPageLimit = 3
        trendyViewPager.getChildAt(0).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
    }
}
