package views.brainView

import brain.Brain
import org.hexworks.zircon.api.builder.Builder
import org.hexworks.zircon.api.component.builder.base.BaseComponentBuilder

class BrainBoxBuilder(
    private val brainGridX: Int,
    private val brainGridY: Int,
    private val brain: Brain
): BaseComponentBuilder<BrainBox, BrainBoxBuilder>(
    BrainBoxRenderer(brain)
) {

    init {
        withPreferredSize(5, 5)
    }

    override fun createCopy(): Builder<BrainBox> {
        println("BrainBoxBuilder calling 'createCopy()") //Want to see when and if this is ever called
        return BrainBoxBuilder(brainGridX, brainGridY, brain)
    }

    override fun build(): BrainBox {
        return BrainBox(brainGridX,
            brainGridY,
            brain,
            metadata = createMetadata(),
            renderingStrategy = createRenderingStrategy())
    }
}