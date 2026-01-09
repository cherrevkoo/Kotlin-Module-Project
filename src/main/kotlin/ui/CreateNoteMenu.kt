package ui

import data.AppState
import data.Note
import java.util.Scanner

class CreateNoteMenu(
    private val state: AppState,
    private val archiveIndex: Int,
    private val scanner: Scanner
) {
    fun startOnce() {
        val archive = state.archives[archiveIndex]
        println()
        println("Создание заметки (архив: ${archive.name})")

        val title = readNonEmpty(scanner, "Введите название заметки: ")
        val content = readNonEmpty(scanner, "Введите текст заметки: ")

        archive.notes.add(Note(title, content))
        println("Заметка \"$title\" создана.")
    }
}