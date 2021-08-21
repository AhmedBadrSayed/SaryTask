package com.mondiamedia.ahmedbadr.sarytask.ui.home

import CatalogItemData
import CatalogResponse
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mondiamedia.ahmedbadr.sarytask.R
import com.mondiamedia.ahmedbadr.sarytask.databinding.FragmentHomeBinding
import com.mondiamedia.ahmedbadr.sarytask.models.BannersResponse
import com.mondiamedia.ahmedbadr.sarytask.ui.adapters.BannersPagerAdapter
import com.mondiamedia.ahmedbadr.sarytask.ui.adapters.CatalogAdapter
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var catalogAdapter: CatalogAdapter
    private lateinit var catalogItems: List<CatalogItemData>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        lifecycleScope.launch {
            getBanners()
            getCatalog()
        }

        return root
    }

    private suspend fun getCatalog() {
        homeViewModel.getCatalog()
            .onStart { showProgress() }
            .catch { exception ->
                hideProgress()
                Log.e(
                    HomeFragment::class.simpleName,
                    "getCatalog: ",
                    exception.cause
                )
                showErrorMessage()
            }
            .collect { result ->
                hideProgress()
                setupCatalogs(result)
            }
    }

    private fun setupCatalogs(result: CatalogResponse) {
        val catalogItemsList = result.catalogItemsList

        catalogItemsList.forEach {
            val recyclerView = RecyclerView(activity as Context)
            val params = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 16, 0, 16)
            recyclerView.layoutParams = params

            val textView = TextView(activity as Context)
            textView.text = it.title
            textView.setTextColor(Color.BLACK)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                textView.setTextAppearance(R.style.catalog_title)
            }

            catalogItems = it.data
            val layoutManager = GridLayoutManager(activity, it.rowCount)
            recyclerView.layoutManager = layoutManager
            catalogAdapter = CatalogAdapter(catalogItems, it.dataType, it.rowCount)
            recyclerView.adapter = catalogAdapter

            if (it.showTitle) {
                binding.catalogLayout.addView(textView)
            }
            binding.catalogLayout.addView(recyclerView)
        }
    }

    private suspend fun getBanners() {
        homeViewModel.getBanners()
            .onStart { showProgress() }
            .catch { exception ->
                hideProgress()
                Log.e(
                    HomeFragment::class.simpleName,
                    "getBanners: ",
                    exception.cause
                )
                showErrorMessage()
            }
            .collect { result ->
                hideProgress()
                setupBannersPagerAdapter(result)
            }
    }

    private fun setupBannersPagerAdapter(result: BannersResponse) {
        val pagerAdapter =
            BannersPagerAdapter(this@HomeFragment, result.bannersList)
        binding.bannersPager.adapter = pagerAdapter
    }

    private fun showProgress() {
        binding.progress.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        binding.progress.visibility = View.GONE
    }

    private fun showErrorMessage() {
        Toast.makeText(
            activity,
            activity?.resources?.getString(R.string.connection_error),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}