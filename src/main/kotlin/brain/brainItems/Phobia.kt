package brain.brainItems

import main.CardinalDirection

class Phobia(
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