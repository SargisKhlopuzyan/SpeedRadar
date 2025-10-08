package com.sargis.khlopuzyan.data.di

import com.sargis.khlopuzyan.data.gps.GpsCheckerImpl
import com.sargis.khlopuzyan.data.loger.LoggerImpl
import com.sargis.khlopuzyan.data.repository.CurrentLocationRepositoryImpl
import com.sargis.khlopuzyan.domain.gps.GpsChecker
import com.sargis.khlopuzyan.domain.loger.Logger
import com.sargis.khlopuzyan.domain.repository.CurrentLocationRepository
import org.koin.dsl.module

private val databaseModule = module {

}

private val repositoryModule = module {
    single<CurrentLocationRepository> { CurrentLocationRepositoryImpl(get(), get()) }
}

private val utilitiesModule = module {
    single<Logger> { LoggerImpl() }
    single<GpsChecker> { GpsCheckerImpl(get()) }
}

val dataModule = listOf(databaseModule, repositoryModule, utilitiesModule)