package org.eljabali.sami

class Logic(
	val board: Board,
	val player1: Player,
	val player2: Player,
	val commandLineReader: CommandLineReader
) {
	var turn = player1

	fun gameLoop() {
		board.draw()

		while (true) {
			handleInputFor(turn)
			if (gameEnded(turn)) {
				break
			}
			board.draw()
			turn = if (turn == player1) player2 else player1
			println("Player ${turn.character} turn")
		}
	}

	fun gameEnded(player: Player): Boolean {
		return when {
			isWinner() -> {
				println("${player.character} won!")
				true
			}

			isDraw() -> {
				println("draw!")
				true
			}

			else -> false
		}
	}

	fun isWinner(): Boolean {
		val matrix = board.matrix

		return when {
			matrix.any { row -> row.all { it == turn.character } } -> true // rows
			(0 until 3).any { col -> matrix.all { row -> row[col] == turn.character } } -> true // columns
			(0 until 3).all { i -> matrix[i][i] == turn.character } -> true // diagonal
			(0 until 3).all { i -> matrix[i][2 - i] == turn.character } -> true // opposite diagonal

			else -> false
		}
	}

	fun isDraw(): Boolean = board.hasEmptyFields().not()

	fun handleInputFor(player: Player) {
		while (true) {
			val input = commandLineReader.readInput()
			if (board.checkAvailable(input)) {
				board.updateBoard(input, player)
				break
			} else {
				println("Occupied field!")
			}
		}
	}
}
