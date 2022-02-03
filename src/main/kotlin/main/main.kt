package com.example

import com.example.views.MainMenuView
import main.GameConfig
import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.SwingApplications
import org.hexworks.zircon.api.application.AppConfig
import org.hexworks.zircon.api.extensions.toScreen

fun main(args: Array<String>) {
    val grid = SwingApplications.startTileGrid(GameConfig.buildAppConfig())
    MainMenuView(grid).dock()
}