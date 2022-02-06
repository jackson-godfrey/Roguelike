package views.brainView

import brain.Brain
import brain.brainItems.BrainItemRenderer.Companion.render

import org.hexworks.zircon.api.component.renderer.ComponentRenderContext
import org.hexworks.zircon.api.component.renderer.ComponentRenderer
import org.hexworks.zircon.api.graphics.TileGraphics

class BrainBoxRenderer (val brain: Brain) : ComponentRenderer<BrainBox> {
    override fun render(tileGraphics: TileGraphics, context: ComponentRenderContext<BrainBox>) {
        val brainBox = context.component
        val item = brain.getBrainItemAt(brainBox.brainGridX, brainBox.brainGridY)

//        item.getRotatedOutletDirections().forEach {
//            val length = when (it) {
//                CardinalDirection.NORTH -> 2
//                CardinalDirection.EAST -> 2
//                CardinalDirection.SOUTH -> 2
//                CardinalDirection.WEST -> 2
//            }
//
//            for (i in 1..length) {
//                tileGraphics.draw(
//                    TileBuilder.newBuilder()
//                        .withCharacter('=')
//                        .withBackgroundColor(TileColor.transparent())
//                        .withModifiers(Modifiers.blink())
//                        .build(),
//                    center + it.toRelativePosition()*i
//                )
//            }
//        }

        item.render(graphics = tileGraphics)
    }
}