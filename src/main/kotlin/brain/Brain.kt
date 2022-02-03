package brain

import brain.brainItems.BrainItem
import brain.brainItems.BrainItemLibrary
import main.GameConfig.BRAIN_HEIGHT
import main.GameConfig.BRAIN_WIDTH

class Brain {
    companion object Debug {
        var itemToPlace: BrainItem = BrainItemLibrary.EmptyBrainItem
        fun replaceWithDebugItem(brain: Brain, brainGridX: Int, brainGridY: Int){
            brain.brainGrid[brainGridX][brainGridY] = BrainItemLibrary.buildFromExistingBrainItem(itemToPlace)
        }
    }

    private val brainGrid: Array<Array<BrainItem>> = Array(BRAIN_WIDTH) { row ->
        Array(BRAIN_HEIGHT) { col ->
            BrainItemLibrary.EmptyBrainItem
        }
    }

    init {
        //brainGrid[3][3] = Relic()
    }

    fun getBrainItemAt(x: Int, y: Int) : BrainItem {
        return brainGrid[x][y] //Array indexing in Kotlin comes with error returning bound checks
    }

}