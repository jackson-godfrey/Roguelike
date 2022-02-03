package views.brainView

import brain.Brain
import brain.brainItems.BrainItem
import brain.brainItems.BrainItemLibrary
import main.GameConfig.BASE_WINDOW_HEIGHT
import main.GameConfig.BASE_WINDOW_WIDTH
import main.GameConfig.BRAIN_HEIGHT
import main.GameConfig.BRAIN_ITEM_HEIGHT
import main.GameConfig.BRAIN_ITEM_WIDTH
import main.GameConfig.BRAIN_WIDTH
import main.GameConfig.DEBUG_EXTRA_HEIGHT
import main.GameConfig.DEBUG_EXTRA_WIDTH
import main.GameConfig.WINDOW_HEIGHT
import main.GameConfig.isDebugMode
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.Panel
import org.hexworks.zircon.api.data.Position
import org.hexworks.zircon.api.data.Size
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.view.base.BaseView
import org.hexworks.zircon.internal.fragment.impl.VerticalScrollableList

class BrainView(
    grid: TileGrid,
    private val brain: Brain
) : BaseView(grid, ColorThemes.arc()){

    init{
        val mainPanel = Components.panel()
            .withPosition(0, 0)
            .withPreferredSize(BRAIN_ITEM_WIDTH * BRAIN_WIDTH, BRAIN_ITEM_HEIGHT * BRAIN_HEIGHT)
            .build()

            .apply {
                for(x in 0 until BRAIN_WIDTH)
                    for(y in 0 until BRAIN_HEIGHT)
                        addComponent(
                            BrainBoxBuilder(x, y, brain)
                                .withPreferredSize(BRAIN_ITEM_WIDTH, BRAIN_ITEM_HEIGHT)
                                .withPosition(x*BRAIN_ITEM_WIDTH, y*BRAIN_ITEM_HEIGHT)
                                .build())
            }

        screen.addComponents(mainPanel)

        if(isDebugMode()) {
            val debugPanel = Components.panel()
                .withPosition(BASE_WINDOW_WIDTH, 0)
                .withPreferredSize(DEBUG_EXTRA_WIDTH, WINDOW_HEIGHT)
                .build()


            debugPanel.addFragment(
                VerticalScrollableList(
                    size = Size.create(DEBUG_EXTRA_WIDTH, WINDOW_HEIGHT),
                    position = Position.create(0, 0),
                    BrainItemLibrary.allBrainItems,
                    onItemActivated = { item, _ ->
                        Brain.Debug.itemToPlace = item
                    },
                    renderItem = {
                        it.inGameName
                    }
                )
            )

            screen.addComponents(debugPanel)
        }

    }
}