package brain.brainItems

import main.CardinalDirection
import org.hexworks.zircon.api.color.TileColor
import org.hexworks.zircon.api.graphics.Symbols

object BrainItemLibrary {

    object EmptyBrainItem : BrainItem("Empty Brain Item",
        object: BrainItemRenderer {
            override val cornering = BrainItemCornering.EmptyCornering
            override val glyph = Symbols.SOLID_SQUARE
            //override val highlightForeground = TileColor.transparent()
            override val lowlight = TileColor.create(80, 80, 80)
        })
    { }

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
     * Returns a BrainItem constructed using [block] and adds a key-value pair corresponding to [block] to the builderMap
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
                -> Memory("Shop Memory",
                outletDirections = mutableListOf(CardinalDirection.NORTH, CardinalDirection.EAST),
                passiveAbilityHolder = object : PassiveAbilityHolder {
                    override fun extraShopOptions() = 1
                },

                renderer = object : BrainItemRenderer {
                    override val glyph = 'M'
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
                -> Phobia("Shop Phobia",
                outletDirections = mutableListOf(CardinalDirection.NORTH),
                passiveAbilityHolder = object: PassiveAbilityHolder {
                    override fun extraShopOptions() = -1
                },

                renderer = object: BrainItemRenderer {
                    override val glyph = 'P'
                }
            )
            },

            buildBrainItem{
                Phobia("Test Source Phobia",
                outletDirections = mutableListOf(CardinalDirection.SOUTH),

                renderer = object: BrainItemRenderer {
                    override val glyph = 'T'
                },
                isNaturalPowerSource = true
            )

            }

        )
    }
    //endregion
}