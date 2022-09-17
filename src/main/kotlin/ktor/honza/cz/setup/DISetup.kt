package ktor.honza.cz.setup

import ktor.honza.cz.service.AuthorService
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

fun DI.MainBuilder.registerServices() {
  bind<AuthorService>() with singleton { AuthorService() }
}

