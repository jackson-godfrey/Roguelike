package brain.brainItems

import brain.Circuitry
import main.CardinalDirection

abstract class BrainItem(
    val inGameName: String,
    renderer: BrainItemRenderer,
    outletDirections: MutableList<CardinalDirection> = mutableListOf(),
    isNaturalPowerSource: Boolean = false

) : Circuitry(outletDirections, isNaturalPowerSource = isNaturalPowerSource),
        BrainItemRenderer by renderer
{

}
