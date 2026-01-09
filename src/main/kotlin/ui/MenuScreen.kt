package ui

import java.util.Scanner

class MenuScreen(
    private val header: () -> String,
    private val actionsProvider: () -> MutableList<MenuAction>,
    private val scanner: Scanner
) {
    fun loopUntilExit(isExitChoice: (Int, Int) -> Boolean) {
        while (true) {
            val actions = actionsProvider()

            println()
            println(header())
            actions.forEachIndexed { index, item ->
                println("$index. ${item.title}")
            }

            print("Ваш выбор: ")
            val input = scanner.nextLine().trim()

            val choice = input.toIntOrNull()
            if (choice == null) {
                println("Ошибка: нужно ввести цифру.")
                continue
            }

            if (choice !in actions.indices) {
                println("Ошибка: пункта с таким номером нет.")
                continue
            }

            if (isExitChoice(choice, actions.size)) return

            actions[choice].action.invoke()
        }
    }
}

fun readNonEmpty(scanner: Scanner, prompt: String): String {
    while (true) {
        print(prompt)
        val s = scanner.nextLine().trim()
        if (s.isBlank()) {
            println("Ошибка: значение не может быть пустым.")
            continue
        }
        return s
    }
}