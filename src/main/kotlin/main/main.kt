package main

import com.example.views.MainMenuView
import org.hexworks.zircon.api.SwingApplications

fun main(args: Array<String>) {
    val grid = SwingApplications.startTileGrid(GameConfig.buildAppConfig())
    MainMenuView(grid).dock()
}