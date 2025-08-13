package org.eljabali.sami

import kotlin.math.abs

val matrix = arrayOf(
    arrayOf(' ', ' ', ' '),
    arrayOf(' ', ' ', ' '),
    arrayOf(' ', ' ', ' ')
)
const val o = 'O'
const val x = 'X'
fun main() {

    var turn = o
    val matrixEmpty = doesMatrixContainsEmptyChars()

    while (matrixEmpty) {
        println("It's $turn's turn")
        val input = readInputs()
        matrix[input.first][input.second] = turn
        printTicTacToe()
        val winner = determineWinner()
        if (winner != ' ') {
            println("$winner won the game")
            break
        }
        if (!doesMatrixContainsEmptyChars()) {
            println("Game tied")
            break
        }
        turn = if (turn == o) x else o
    }
}

fun determineWinner(): Char {
    val winner = ' '
    val listHorizontalAlignment = mutableListOf<Char>()
    val listVerticalAlignment = mutableListOf<Char>()
    val listDiagonalAlignment = mutableListOf<Char>()
    val listOppositeDiagonalAlignment = mutableListOf<Char>()
    for (i in 0..2) {
        for (j in 0..2) {
            if (matrix[i][j] != ' ') listHorizontalAlignment.add(matrix[i][j])
            if (matrix[j][i] != ' ') listVerticalAlignment.add(matrix[j][i])
            if (i == j && matrix[j][i] != ' ') listDiagonalAlignment.add(matrix[j][i])
            if (i + j == abs(2) && matrix[j][i] != ' ') listOppositeDiagonalAlignment.add(matrix[j][i])
        }
        if (listHorizontalAlignment.size == 3) {
            if (listHorizontalAlignment.contains(o) && !listHorizontalAlignment.contains(x)) return o
            if (listHorizontalAlignment.contains(x) && !listHorizontalAlignment.contains(o)) return x
        } else listHorizontalAlignment.removeAll { true }
        if (listVerticalAlignment.size == 3) {
            if (listVerticalAlignment.contains(o) && !listVerticalAlignment.contains(x)) return o
            if (listVerticalAlignment.contains(x) && !listVerticalAlignment.contains(o)) return x
        } else listVerticalAlignment.removeAll { true }
    }
    if (listDiagonalAlignment.size == 3) {
        if (listDiagonalAlignment.contains(o) && !listDiagonalAlignment.contains(x)) return o
        if (listDiagonalAlignment.contains(x) && !listDiagonalAlignment.contains(o)) return x
    }
    if (listOppositeDiagonalAlignment.size == 3) {
        if (listOppositeDiagonalAlignment.contains(o) && !listOppositeDiagonalAlignment.contains(x)) return o
        if (listOppositeDiagonalAlignment.contains(x) && !listOppositeDiagonalAlignment.contains(o)) return x
    }
    return winner
}

fun doesMatrixContainsEmptyChars(): Boolean {
    for (i in 0..2) {
        for (j in 0..2) {
            if(matrix[i][j] == ' ')
                return true
        }
    }
    return false
}

fun readInputs(): Pair<Int, Int> {
    var valuesEnteredCorrect = false
    var col: Int = -1
    var row: Int = -1

    while (!valuesEnteredCorrect) {
        println("enter row:")
        col = readLine()!!.toInt() - 1

        println("enter col:")
        row = readLine()!!.toInt() - 1
        if (col > -1 && col < 3 && row > -1 && row < 3 && matrix[row][col] == ' ')
            valuesEnteredCorrect = true
        else println("Values not entered correctly, please try again")
    }

    return Pair(row, col)
}

fun printTicTacToe() {
    for (i in 0..2) {
        for (j in 0..2) {
            print(matrix[i][j])
            if (j != 2) {
                print(" | ")
            }
        }
        if (i != 2) {
            println()
            println("----------")
        } else println()
    }
}