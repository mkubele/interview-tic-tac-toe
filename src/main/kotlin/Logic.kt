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
			println("$turn turn" )
		}
	}

	fun gameEnded(player: Player): Boolean {
		return when {
			isWinner() -> {
				println("$player won!")
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
		return false
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
