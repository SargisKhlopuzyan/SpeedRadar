package com.sargis.khlopuzyan.data.di

import org.koin.dsl.module

private val databaseModule = module {

}

private val repositoryModule = module {

}

private val utilitiesModule = module {
}

val dataModule = listOf(databaseModule, repositoryModule, utilitiesModule)