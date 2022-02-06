package brain.brainItems

import main.CardinalDirection

// Relics represent items which have passive effects
abstract class Relic(
    inGameName: String,
    renderer: BrainItemRenderer,
    outletDirections: MutableList<CardinalDirection> = mutableListOf(),
    passiveAbilityHolder: PassiveAbilityHolder = object:PassiveAbilityHolder {},
) : BrainItem(
    inGameName,
    renderer,
    outletDirections),

    PassiveAbilityHolder by passiveAbilityHolder{


}