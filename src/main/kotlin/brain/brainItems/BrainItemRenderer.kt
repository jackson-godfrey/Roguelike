package brain.brainItems

import brain.Circuitry
import main.CardinalDirection
import main.GameConfig.BRAIN_ITEM_HEIGHT
import main.GameConfig.BRAIN_ITEM_WIDTH
import main.Render.Companion.drawTileBackTransparent
import org.hexworks.zircon.api.Modifiers
import org.hexworks.zircon.api.builder.data.TileBuilder
import org.hexworks.zircon.api.color.TileColor
import org.hexworks.zircon.api.data.Position
import org.hexworks.zircon.api.graphics.TileGraphics

interface BrainItemRenderer {
    companion object {
        private val Center = Position.create(2, 2)

        fun BrainItem.render(graphics: TileGraphics) {
            if(graphics.width != BRAIN_ITEM_WIDTH || graphics.height != BRAIN_ITEM_HEIGHT)
                throw Exception("BrainItemRenderer: Graphics object with incorrect size passed to render()")
            renderCentralGlyph(graphics)
            renderCorners(graphics)
            renderCircuitry(graphics)
        }

        private fun BrainItemRenderer.renderCentralGlyph(graphics: TileGraphics){
            graphics.draw(
                TileBuilder.newBuilder()
                    .withCharacter(glyph)
                    .withForegroundColor(TileColor.transparent())
                    .withBackgroundColor(TileColor.create(80, 0, 0))
                    .build(),
                Center
            )
        }

        private fun BrainItemRenderer.renderCorners(graphics: TileGraphics){
            val foreground: TileColor = TileColor.create(52, 52, 52)
            graphics.drawTileBackTransparent(cornering.topLeft,
                Center + Position.create(-1, -1), foreground)
            graphics.drawTileBackTransparent(cornering.topRight,
                Center + Position.create(1, -1), foreground)
            graphics.drawTileBackTransparent(cornering.bottomLeft,
                Center + Position.create(-1, 1), foreground)
            graphics.drawTileBackTransparent(cornering.bottomRight,
                Center + Position.create(1, 1), foreground)
        }

        private fun Circuitry.renderCircuitry(graphics: TileGraphics){
            getRotatedOutletDirections().forEach {
                val length = when (it) {
                    CardinalDirection.NORTH -> 2
                    CardinalDirection.EAST -> 2
                    CardinalDirection.SOUTH -> 2
                    CardinalDirection.WEST -> 2
                }

                for (i in 1..length) {
                    graphics.draw(
                        TileBuilder.newBuilder()
                            .withCharacter('=')
                            .withBackgroundColor(TileColor.transparent())
                            .withModifiers(Modifiers.blink())
                            .build(),
                        Center + it.toRelativePosition()*i
                    )
                }
            }
        }

        private operator fun Position.times(i: Int) = Position.create(this.x*i, this.y*i)
    }
    //Implementations of an interface containing vals are only required to provide getters. Since we do so below, then
    //we essentially have a default property for [cornering]
    val cornering: BrainItemCornering
        get() = BrainItemCornering.DefaultCornering

    val glyph: Char
}