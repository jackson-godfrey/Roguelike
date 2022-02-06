package brain.brainItems

import brain.Circuitry
import main.CardinalDirection

abstract class BrainItem(
    val inGameName: String,
    renderer: BrainItemRenderer,
    outletDirections: MutableList<CardinalDirection> = mutableListOf(),

) : Circuitry(outletDirections),
        BrainItemRenderer by renderer
{

//    override fun render(graphics: TileGraphics) {
//        super.render(graphics)
//        renderCircuitry(graphics)
//    }
}
