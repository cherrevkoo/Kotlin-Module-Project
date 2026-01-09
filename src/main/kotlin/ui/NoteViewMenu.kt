package ui

import data.AppState
import java.util.Scanner

class NoteViewMenu(
    private val state: AppState,
    private val archiveIndex: Int,
    private val noteIndex: Int,
    private val scanner: Scanner
) {
    fun startOnce() {
        val note = state.archives[archiveIndex].notes[noteIndex]

        val menu = MenuScreen(
            header = {
                "Заметка: ${note.title}\n\n${note.content}\n"
            },
            actionsProvider = {
                mutableListOf(
                    MenuAction("Назад") {

                    }
                )
            },
            scanner = scanner
        )
        menu.loopUntilExit { choice, _ -> choice == 0 }
    }
}