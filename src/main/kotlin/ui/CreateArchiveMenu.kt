package ui

import data.AppState
import data.Archive
import java.util.Scanner

class CreateArchiveMenu(
    private val state: AppState,
    private val scanner: Scanner
) {
    fun startOnce() {
        println()
        println("Создание архива")
        val name = readNonEmpty(scanner, "Введите имя архива: ")
        state.archives.add(Archive(name))
        println("Архив \"$name\" создан.")
    }
}