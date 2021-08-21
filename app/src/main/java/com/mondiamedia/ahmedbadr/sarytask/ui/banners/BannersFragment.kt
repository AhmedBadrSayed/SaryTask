package com.mondiamedia.ahmedbadr.sarytask.ui.banners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.RoundedCornersTransformation
import com.mondiamedia.ahmedbadr.sarytask.databinding.FragmentBannersBinding

class BannersFragment : Fragment() {

    private var _binding: FragmentBannersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var bannerPhotoUrl: String
    private lateinit var bannerTitle: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBannersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        bannerPhotoUrl = arguments?.getString(ARG_PHOTO_URL) ?: ""
        bannerTitle = arguments?.getString(ARG_TITLE) ?: ""
        binding.bannerPhoto.load(bannerPhotoUrl) {
            crossfade(true)
            transformations(RoundedCornersTransformation(32f))
        }

        binding.bannerPhoto.setOnClickListener {
            Toast.makeText(activity, bannerTitle, Toast.LENGTH_LONG).show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_PHOTO_URL = "photo_url"
        const val ARG_TITLE = "title"

        @JvmStatic
        fun newInstance(bannerPhotoUrl: String, bannerTitle: String): BannersFragment {
            return BannersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PHOTO_URL, bannerPhotoUrl)
                    putString(ARG_TITLE, bannerTitle)
                }
            }
        }
    }
}