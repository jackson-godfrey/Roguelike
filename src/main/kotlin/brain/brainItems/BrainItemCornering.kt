package brain.brainItems

import org.hexworks.zircon.api.graphics.Symbols

data class BrainItemCornering(
    val topLeft: Char,
    val topRight: Char,
    val bottomLeft: Char,
    val bottomRight: Char
)
{
    companion object {
        val DefaultCornering = BrainItemCornering(Symbols.SINGLE_LINE_TOP_LEFT_CORNER,
            Symbols.SINGLE_LINE_TOP_RIGHT_CORNER,
            Symbols.SINGLE_LINE_BOTTOM_LEFT_CORNER,
            Symbols.SINGLE_LINE_BOTTOM_RIGHT_CORNER)
        val EmptyCornering = BrainItemCornering(' ', ' ', ' ', ' ')
    }
}