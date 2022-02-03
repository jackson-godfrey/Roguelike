package views.brainView

import brain.Brain
import org.hexworks.zircon.api.builder.data.TileBuilder
import org.hexworks.zircon.api.component.renderer.ComponentRenderContext
import org.hexworks.zircon.api.component.renderer.ComponentRenderer
import org.hexworks.zircon.api.data.Position
import org.hexworks.zircon.api.graphics.TileGraphics

class BrainBoxRenderer (val brain: Brain) : ComponentRenderer<BrainBox> {
    override fun render(tileGraphics: TileGraphics, context: ComponentRenderContext<BrainBox>) {

        val center = Position.create(2, 2)
        val item = brain.getBrainItemAt(context.component.brainGridX, context.component.brainGridY)
        tileGraphics.draw(
            TileBuilder.newBuilder()
                .withCharacter(item.getGlyph())
                .build(),
            center
        )
        item.getRotatedOutletDirections().forEach {tileGraphics.draw(
            TileBuilder.newBuilder()
                .withCharacter('=')
                .build(),
            center + it.toRelativePosition()
        )}
    }

}