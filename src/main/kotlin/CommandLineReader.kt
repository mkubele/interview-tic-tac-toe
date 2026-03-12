package org.eljabali.sami

class CommandLineReader {

	fun readInput(): Input {
		var valuesEnteredCorrect = false
		var col: Int = -1
		var row: Int = -1

		while (!valuesEnteredCorrect) {
			println("enter row:")
			row = readln().toInt() - 1

			println("enter col:")
			col = readln().toInt() - 1
			if (col > -1 && col < 3 && row > -1 && row < 3)
				valuesEnteredCorrect = true
			else println("Values not entered correctly, please try again")
		}

		return Input(row, col)
	}
}

data class Input(val row: Int, val col: Int)