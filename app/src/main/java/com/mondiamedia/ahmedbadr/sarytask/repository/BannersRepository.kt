package com.mondiamedia.ahmedbadr.sarytask.repository

import com.mondiamedia.ahmedbadr.sarytask.api.BannersInterface
import com.mondiamedia.ahmedbadr.sarytask.models.BannersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class BannersRepository(private val bannersService: BannersInterface) {

    suspend fun getBanners(): Flow<BannersResponse> {
        return flow {
            val result = bannersService.getBanners()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}