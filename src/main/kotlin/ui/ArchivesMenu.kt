package ui

import data.AppState
import java.util.Scanner

class ArchivesMenu(private val state: AppState) {
    private val scanner = Scanner(System.`in`)

    fun start() {
        val menu = MenuScreen(
            header = { "Список архивов:" },
            actionsProvider = {
                val items = mutableListOf<MenuAction>()
                items.add(MenuAction("Создать архив") {
                    CreateArchiveMenu(state, scanner).startOnce()
                })
                state.archives.forEachIndexed { idx, archive ->
                    items.add(MenuAction(archive.name) {
                        ArchiveMenu(state, idx, scanner).start()
                    })
                }
                items.add(MenuAction("Выход") { })
                items
            },
            scanner = scanner
        )

        menu.loopUntilExit { choice, size ->
            choice == size - 1
        }
    }
}