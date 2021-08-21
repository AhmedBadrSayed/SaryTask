package com.mondiamedia.ahmedbadr.sarytask.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mondiamedia.ahmedbadr.sarytask.models.Banner
import com.mondiamedia.ahmedbadr.sarytask.ui.banners.BannersFragment

class BannersPagerAdapter(
    fragment: Fragment,
    private val banners: List<Banner>
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = banners.size

    override fun createFragment(position: Int): Fragment =
        BannersFragment.newInstance(
            banners[position].photo,
            banners[position].title
        )
}