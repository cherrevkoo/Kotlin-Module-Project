package ui

import data.AppState
import java.util.Scanner

class ArchiveMenu(
    private val state: AppState,
    private val archiveIndex: Int,
    private val scanner: Scanner
) {
    fun start() {
        val menu = MenuScreen(
            header = {
                val archive = state.archives[archiveIndex]
                "Архив: ${archive.name}\nСписок заметок:"
            },
            actionsProvider = {
                val archive = state.archives[archiveIndex]
                val items = mutableListOf<MenuAction>()

                items.add(MenuAction("Создать заметку") {
                    CreateNoteMenu(state, archiveIndex, scanner).startOnce()
                })

                archive.notes.forEachIndexed { idx, note ->
                    items.add(MenuAction(note.title) {
                        NoteViewMenu(state, archiveIndex, idx, scanner).startOnce()
                    })
                }

                items.add(MenuAction("Назад") { })
                items
            },
            scanner = scanner
        )

        menu.loopUntilExit { choice, size ->
            choice == size - 1
        }
    }
}