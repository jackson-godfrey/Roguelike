package main

import org.hexworks.zircon.api.data.Position

enum class CardinalDirection (private val i: Int) {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    companion object {
        fun fromInt(value: Int) = CardinalDirection.values().first { it.i == (value%4) }
    }

    fun toRelativePosition() : Position {
        return when(this){
            NORTH   -> Position.create(0, -1)
            EAST    -> Position.create(1, 0)
            SOUTH   -> Position.create(0, 1)
            WEST    -> Position.create(-1, 0)
        }
    }
    operator fun plus(toAdd: CardinalDirection) = fromInt(toAdd.i + this.i)
    operator fun inc() = fromInt(this.i + 1)
}