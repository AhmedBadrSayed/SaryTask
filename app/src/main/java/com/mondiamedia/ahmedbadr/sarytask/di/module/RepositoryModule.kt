package com.mondiamedia.ahmedbadr.sarytask.di.module

import com.mondiamedia.ahmedbadr.sarytask.repository.BannersRepository
import com.mondiamedia.ahmedbadr.sarytask.repository.CatalogRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        BannersRepository(get())
    }

    single {
        CatalogRepository(get())
    }
}