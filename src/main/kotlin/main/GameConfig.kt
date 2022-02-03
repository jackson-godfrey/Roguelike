package main

import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.application.AppConfig
import org.hexworks.zircon.api.data.Size3D

object GameConfig {

    // look & feel
    private val TILESET = CP437TilesetResources.rogueYun16x16() // 2
    val THEME = ColorThemes.zenburnVanilla()            // 3

    //Sizing for the main application's window
    const val BASE_WINDOW_WIDTH = 80
    const val BASE_WINDOW_HEIGHT = 60

    const val DEBUG_EXTRA_WIDTH = 25
    const val DEBUG_EXTRA_HEIGHT = 0

    private const val DEBUG_MODE = 1
    fun isDebugMode(): Boolean = DEBUG_MODE == 1

    infix fun toInt(v: Boolean) : Int{
        return if(v) 1
        else 0
    }

    const val WINDOW_HEIGHT = BASE_WINDOW_HEIGHT + DEBUG_MODE * DEBUG_EXTRA_HEIGHT
    const val WINDOW_WIDTH = BASE_WINDOW_WIDTH + DEBUG_MODE * DEBUG_EXTRA_WIDTH


    fun buildAppConfig() = AppConfig.newBuilder()       // 5
        .withDefaultTileset(TILESET)
        .withSize(WINDOW_WIDTH, WINDOW_HEIGHT)
        .build()

    //Sizing of the brain with respect to brain items
    const val BRAIN_WIDTH = 10
    const val BRAIN_HEIGHT = 10

    const val BRAIN_ITEM_WIDTH = 5
    const val BRAIN_ITEM_HEIGHT = BRAIN_ITEM_WIDTH

//    val WORLD_SIZE = Size3D.create(WINDOW_WIDTH, WINDOW_HEIGHT, 1)
//    val GAME_AREA_SIZE = Size3D.create(
//        xLength = WINDOW_WIDTH - SIDEBAR_WIDTH,
//        yLength = WINDOW_HEIGHT - LOG_AREA_HEIGHT,
//        zLength = DUNGEON_LEVELS
//    )

}