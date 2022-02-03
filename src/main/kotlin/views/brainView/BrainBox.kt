package views.brainView

import brain.Brain
import org.hexworks.zircon.api.component.ColorTheme
import org.hexworks.zircon.api.component.Component
import org.hexworks.zircon.api.component.data.ComponentMetadata
import org.hexworks.zircon.api.uievent.MouseEvent
import org.hexworks.zircon.api.uievent.UIEventPhase
import org.hexworks.zircon.api.uievent.UIEventResponse
import org.hexworks.zircon.internal.component.impl.DefaultComponent
import org.hexworks.zircon.internal.component.renderer.DefaultComponentRenderingStrategy

class BrainBox constructor(
    val brainGridX: Int,
    val brainGridY: Int,
    private val brain: Brain,
    metadata: ComponentMetadata,
    renderingStrategy: DefaultComponentRenderingStrategy<BrainBox>
    ): Component, DefaultComponent(
    metadata = metadata,
    renderer = renderingStrategy
) {
    override fun convertColorTheme(colorTheme: ColorTheme) = colorTheme.toPrimaryContentStyle()
    override fun focusGiven(): UIEventResponse {
        Brain.Debug.replaceWithDebugItem(brain, brainGridX, brainGridY)
        return UIEventResponse.pass()
    }

    override fun mouseWheelRotatedDown(event: MouseEvent, phase: UIEventPhase): UIEventResponse {
        //Brain.Debug.replaceWithDebugItem(brain, brainGridX, brainGridY)
        return super.mouseWheelRotatedDown(event, phase)
    }

    override fun activated(): UIEventResponse {
        brain.getBrainItemAt(brainGridX, brainGridY).rotateCircuitry()
        return super.activated()
    }
}