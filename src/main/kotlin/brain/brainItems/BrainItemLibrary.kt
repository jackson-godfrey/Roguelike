package brain.brainItems

import main.CardinalDirection

object BrainItemLibrary {

    object EmptyBrainItem : BrainItem(' ', "Empty Brain Item") { }

    val allBrainItems: List<BrainItem>
    private val builderMap = HashMap<String, () -> BrainItem> ()

    init {
        val allBrainItems: MutableList<BrainItem> = mutableListOf(EmptyBrainItem)
        allBrainItems.run{
            addAll(initialiseMemories())
            addAll(initialisePhobias())
        }

        this.allBrainItems = allBrainItems.toList()
    }

    /**
     * Returns a BrainItem constructed using [block] and adds ([itemName], [block]) as a key-value pair
     * to the builderMap
     *
     * @param[T] Sub-class of BrainItem
     * @param[block] A lambda expression of the form {name -> T(..., name, ...)}, where T() is a constructor call for T
     */
    private fun <T:BrainItem> buildBrainItem(block: () -> T) : T {
        val brainItem: T = block.invoke()

        val key = brainItem.inGameName
        if (builderMap[key]!= null) throw Exception("Overriding key: $key of builderMap")
        else builderMap[key] = block

        return brainItem
    }

    fun buildFromExistingBrainItem(item: BrainItem): BrainItem {
        if(item == EmptyBrainItem) return EmptyBrainItem
        val key = item.inGameName

        return builderMap[key]?.invoke() ?: throw Exception("No value corresponding to $key in builderMap")
    }

    //region fun initialiseMemories()
    private fun initialiseMemories() : List<Memory> {
        return listOf(

            buildBrainItem{
                -> Memory('A',
                    "Shop Memory",
                    mutableListOf(CardinalDirection.NORTH, CardinalDirection.EAST),
                    object : PassiveAbilityHolder {
                        override fun extraShopOptions() = 1
                    }
                )
            }

        )
    }
    //endregion

    //region fun initialisePhobias()
    private fun initialisePhobias(): List<Phobia> {
        return listOf(

            buildBrainItem{
                -> Phobia('B',
                    "Shop Phobia",
                    mutableListOf(CardinalDirection.NORTH),
                    object: PassiveAbilityHolder {
                        override fun extraShopOptions() = -1
                    }
                )
            }

        )
    }
    //endregion
}