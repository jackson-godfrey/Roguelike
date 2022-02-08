package brain.brainItems

import brain.Circuitry
import main.CardinalDirection
import main.GameConfig
import main.GameConfig.BRAIN_ITEM_HEIGHT
import main.GameConfig.BRAIN_ITEM_WIDTH
import main.Render.Companion.drawTile
import org.hexworks.zircon.api.builder.data.TileBuilder
import org.hexworks.zircon.api.color.TileColor
import org.hexworks.zircon.api.data.Position
import org.hexworks.zircon.api.graphics.Symbols
import org.hexworks.zircon.api.graphics.TileGraphics

interface BrainItemRenderer {

    companion object {
        private val Center = Position.create(2, 2)

        fun BrainItem.render(graphics: TileGraphics) {
            if(graphics.width != BRAIN_ITEM_WIDTH || graphics.height != BRAIN_ITEM_HEIGHT)
                throw Exception("BrainItemRenderer: Graphics object with incorrect size passed to render()")
            renderCentralGlyph(graphics)
            renderCorners(graphics)
            renderCircuitry(graphics, lowlight)
        }

        private fun BrainItemRenderer.renderCentralGlyph(graphics: TileGraphics){
            graphics.draw(
                TileBuilder.newBuilder()
                    .withCharacter(glyph)
                    .withForegroundColor(GameConfig.brainStyleSet.backgroundColor)
                    .withBackgroundColor(lowlight)
                    .build(),
                Center
            )
        }

        private fun BrainItemRenderer.renderCorners(graphics: TileGraphics){
            val foreground: TileColor = highlight
            val background: TileColor = GameConfig.brainStyleSet.backgroundColor

            graphics.drawTile(cornering.topLeft,
                Center + Position.create(-1, -1), foreground, background)
            graphics.drawTile(cornering.topRight,
                Center + Position.create(1, -1), foreground, background)
            graphics.drawTile(cornering.bottomLeft,
                Center + Position.create(-1, 1), foreground, background)
            graphics.drawTile(cornering.bottomRight,
                Center + Position.create(1, 1), foreground, background)
        }

        private fun Circuitry.renderCircuitry(graphics: TileGraphics, unpoweredColor: TileColor){
            getRotatedOutletDirections().forEach {

                val char: Char = when(it){
                    CardinalDirection.NORTH -> Symbols.DOUBLE_LINE_VERTICAL
                    CardinalDirection.SOUTH -> Symbols.DOUBLE_LINE_VERTICAL
                    CardinalDirection.WEST -> Symbols.DOUBLE_LINE_HORIZONTAL
                    CardinalDirection.EAST -> Symbols.DOUBLE_LINE_HORIZONTAL
                }

                for (i in 1..2) {
                    graphics.draw(
                        TileBuilder.newBuilder()
                            .withCharacter(char)
                            .withBackgroundColor(GameConfig.brainStyleSet.backgroundColor)
                            .withForegroundColor(unpoweredColor)
                            //.withModifiers(Modifiers.blink())
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

    val lowlight: TileColor
        get() = TileColor.create(173, 173, 173)
    val highlight: TileColor
        get() = TileColor.create(220, 220, 220)
}