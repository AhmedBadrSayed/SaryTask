package com.mondiamedia.ahmedbadr.sarytask.ui.home

import CatalogResponse
import androidx.lifecycle.ViewModel
import com.mondiamedia.ahmedbadr.sarytask.models.BannersResponse
import com.mondiamedia.ahmedbadr.sarytask.repository.BannersRepository
import com.mondiamedia.ahmedbadr.sarytask.repository.CatalogRepository
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    private val bannersRepository: BannersRepository,
    private val catalogRepository: CatalogRepository
) : ViewModel() {

    suspend fun getBanners(): Flow<BannersResponse> {
        return bannersRepository.getBanners()
    }

    suspend fun getCatalog(): Flow<CatalogResponse> {
        return catalogRepository.getCatalog()
    }
}