package com.example.exo_viewpager_fun.ui

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.FrameLayout
import com.example.exo_viewpager_fun.models.PlayerViewEffect
import com.example.exo_viewpager_fun.players.AppPlayer
import kotlinx.coroutines.flow.Flow

class FakeAppPlayerView(
    context: Context,
    private val taps: Flow<Unit>
) : AppPlayerView {
    val viewId = View.generateViewId()
    override val view: View = FrameLayout(context).apply {
        id = viewId
        setBackgroundColor(Color.GREEN)
    }
    var didStart: Boolean = false
    var didStop: Boolean = false
    var latestEffect: PlayerViewEffect? = null

    override fun onStart(appPlayer: AppPlayer) {
        didStart = true
    }

    override fun onStop() {
        didStop = true
    }

    override fun renderEffect(playerViewEffect: PlayerViewEffect) {
        latestEffect = playerViewEffect
    }

    override fun taps(): Flow<Unit> = taps
}
