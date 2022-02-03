package brain

import main.CardinalDirection
import org.hexworks.zircon.api.data.Position

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
}