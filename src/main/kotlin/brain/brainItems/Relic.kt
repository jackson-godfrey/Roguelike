package brain.brainItems

import main.CardinalDirection

// Relics represent items which have passive effects
abstract class Relic(
    defaultGlyph: Char,
    inGameName: String,
    outletDirections: MutableList<CardinalDirection> = mutableListOf(),
    passiveAbilityHolder: PassiveAbilityHolder = object:PassiveAbilityHolder {},
) : BrainItem(
    defaultGlyph,
    inGameName,
    outletDirections),
PassiveAbilityHolder by passiveAbilityHolder{

}