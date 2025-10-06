package com.sargis.khlopuzyan.domain.di

import org.koin.dsl.module

private val useCaseModule = module {

}

val domainModule = listOf(useCaseModule)
