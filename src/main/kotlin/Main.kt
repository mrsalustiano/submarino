package org.example

import java.io.File

fun main() {

    val filePath = "src\\main\\resources\\Puzzle_01.txt"
    val fileContents = readFileIntoArray(filePath)

    var contador = 0
    var alto = 0
    var baixo = 0
    val qtd = fileContents.size
    var atual = fileContents[0].toInt()
    var anterior = atual

    for (value in fileContents) {
        atual = value.toInt()

        if (contador == 0) {
            contador++
            baixo++
            anterior = atual
        } else {

            if (anterior < atual) {
                alto++
                anterior = atual
            } else {
                anterior = atual
                baixo++
            }
        }
    }

    println("Total values: $qtd") //2000
    println("Higher values: $alto") //1791
    println("Lower values: $baixo")  // 209

}


fun readFileIntoArray(filePath: String): Array<String> {
    val file = File(filePath)
    return file.readLines().toTypedArray()
}
