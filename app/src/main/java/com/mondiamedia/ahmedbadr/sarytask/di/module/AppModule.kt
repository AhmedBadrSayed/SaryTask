package com.mondiamedia.ahmedbadr.sarytask.di.module

import com.mondiamedia.ahmedbadr.sarytask.api.BannersInterface
import com.mondiamedia.ahmedbadr.sarytask.api.CatalogInterface
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { provideRetrofit("https://staging.sary.co/") }
    single { provideBannersApiService(get()) }
    single { provideCatalogApiService(get()) }
}

private fun provideRetrofit(
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

private fun provideBannersApiService(retrofit: Retrofit): BannersInterface =
    retrofit.create(BannersInterface::class.java)

private fun provideCatalogApiService(retrofit: Retrofit): CatalogInterface =
    retrofit.create(CatalogInterface::class.java)