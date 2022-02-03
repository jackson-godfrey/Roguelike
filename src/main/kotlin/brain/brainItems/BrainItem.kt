package brain.brainItems

import brain.Circuitry
import main.CardinalDirection

abstract class BrainItem(
    val defaultGlyph: Char,
    val inGameName: String,
    outletDirections: MutableList<CardinalDirection> = mutableListOf(),
) : Circuitry(outletDirections)
{
    open fun getGlyph() = defaultGlyph
}
