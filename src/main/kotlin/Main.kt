import data.AppState
import ui.ArchivesMenu

fun main() {
    val state = AppState()
    ArchivesMenu(state).start()
}