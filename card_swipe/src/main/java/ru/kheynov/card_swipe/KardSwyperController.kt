package ru.kheynov.card_swipe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberKardSwyperController() : KardSwyperController {
    return remember { KardSwyperControllerImpl() }
}

interface KardSwyperController {
    var currentCardController: CardController?
    fun swipeRight()
    fun swipeLeft()
}

class KardSwyperControllerImpl: KardSwyperController {
    override var currentCardController: CardController?=null

    override fun swipeRight() {
        currentCardController?.swipeRight()
    }

    override fun swipeLeft() {
        currentCardController?.swipeLeft()
    }
}