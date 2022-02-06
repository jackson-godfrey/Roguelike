package brain.brainItems

import main.CardinalDirection

class Memory(
    inGameName: String,
    renderer:BrainItemRenderer,
    outletDirections: MutableList<CardinalDirection> = mutableListOf(),
    passiveAbilityHolder: PassiveAbilityHolder = object:PassiveAbilityHolder {},

) : Relic(
    inGameName,
    renderer,
    outletDirections,
    passiveAbilityHolder)
{

}