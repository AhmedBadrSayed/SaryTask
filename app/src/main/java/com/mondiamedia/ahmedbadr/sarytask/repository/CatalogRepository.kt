package com.mondiamedia.ahmedbadr.sarytask.repository

import CatalogResponse
import com.mondiamedia.ahmedbadr.sarytask.api.CatalogInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CatalogRepository(private val catalogService: CatalogInterface) {

    suspend fun getCatalog(): Flow<CatalogResponse> {
        return flow {
            val result = catalogService.getCatalog()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}