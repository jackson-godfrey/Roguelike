package brain.brainItems

import main.CardinalDirection

class Memory(
    defaultGlyph: Char,
    inGameName: String,
    outletDirections: MutableList<CardinalDirection> = mutableListOf(),
    passiveAbilityHolder: PassiveAbilityHolder = object:PassiveAbilityHolder {},

) : Relic(
    defaultGlyph,
    inGameName,
    outletDirections,
    passiveAbilityHolder)
{

}