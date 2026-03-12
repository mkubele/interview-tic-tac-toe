package org.eljabali.sami

class Board {

	val matrix = arrayOf(
		arrayOf(Character.EMPTY, Character.EMPTY, Character.EMPTY),
		arrayOf(Character.EMPTY, Character.EMPTY, Character.EMPTY),
		arrayOf(Character.EMPTY, Character.EMPTY, Character.EMPTY)
	)

	fun draw() {
		matrix.forEach { row ->
			println(row.joinToString("|") { it.char.toString() })
		}
	}

	fun checkAvailable(input: Input): Boolean {
		return matrix[input.row][input.col] == Character.EMPTY
	}

	fun updateBoard(input: Input, player: Player) {
		matrix[input.row][input.col] = player.character
	}

	fun hasEmptyFields(): Boolean {
		return matrix.any { row ->
			row.any { it == Character.EMPTY }
		}
	}
}

enum class Character(val char: Char) {
	X('x'), O('o'), EMPTY(' ')
}