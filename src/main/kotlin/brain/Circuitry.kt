package brain

import main.CardinalDirection

abstract class Circuitry (
    private val outletDirections: MutableList<CardinalDirection> = mutableListOf(),
    private val rotatable: Boolean = true
) {

    //Default rotation is zero degrees
    private var rotation = CardinalDirection.NORTH
    fun rotateCircuitry(){
        if(rotatable) { rotation++ }
    }

    fun getRotatedOutletDirections(): List<CardinalDirection> = outletDirections.toList().map { it + rotation }
    fun addRandomOutletDirection() {

    }

//    fun BrainItemRenderer.renderCircuitry(graphics: TileGraphics){
//        graphics.draw(
//            TileBuilder.newBuilder()
//                .withCharacter('=')
//                .withBackgroundColor(TileColor.transparent())
//                .withModifiers(Modifiers.blink())
//                .build(),
//            Position.create(00)
//        )
//    }
}