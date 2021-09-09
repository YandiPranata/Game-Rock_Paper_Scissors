import elements.Paper
import elements.Rock
import elements.Scissors
import elements.parent.Suit
import helper.StringContainer

fun main(args: Array<String>) {
    startSuitWithCom()
}

private fun startSuitWithCom() {
    val paper = Paper("paper")
    val rock = Rock("rock")
    val scissors = Scissors("scissors")

    val resultList: List<Suit> = listOf(paper, rock, scissors)
    val compSuit = resultList.random()

    println("computer milih -> ${compSuit.name}")
    println("input suit (kertas, gunting, batu)")
    val input = readLine()

    // TODO: 07/09/21 "Tugas buat hari kemis, 9/9/21" -> solved this line (use do-while)
    /**
     * Temen2 ngerjakan loop ketika user input selain gunting, batu, kertas
     * User input selain gunting, batu, kertas -> fungsi redline s/d success -> di loop (diulangin)
     * User disuruh input lagi
     * */
    do {
        val mySuit = when (input) {
            "gunting" -> Scissors(StringContainer.scissors)
            "batu" -> Rock(StringContainer.rock)
            "paper" -> Paper(StringContainer.paper)
            else -> Paper(StringContainer.paper)
        }

        val result = mySuit.actionAgainst(compSuit)
        println("you is ${result.status} | you: ${mySuit.name} vs comp: ${compSuit.name}")

        println("main lagi? (ketik yes jika pengen)")
        val yes = readLine()
        if (yes == "yes") {
            startSuitWithCom()
        } else {
            break
        }
        println(input)

    } while (input != "gunting" && input != "batu" && input != "kertas")


}

private fun startSuit() {
    println(
        """terminal:~terminal$
        |==========================
        |GAME SUIT TERMINAL VERSION
        |==========================
    """.trimMargin()
    )
    println("1. Masukkan Pemain 1: ")
    val input1 = readLine()
    val suit1 = when (input1) {
        "gunting" -> Scissors(StringContainer.scissors)
        "batu" -> Rock(StringContainer.rock)
        "kertas" -> Paper(StringContainer.paper)
        else -> Suit("nothing else")
    }

    if (suit1.name != "nothing else") {
        println("2. Masukkan Pemain 2: ")
        val input2 = readLine()
        val suit2 = when (input2) {
            "gunting" -> Scissors(StringContainer.scissors)
            "batu" -> Rock(StringContainer.rock)
            "kertas" -> Paper(StringContainer.paper)
            else -> Suit("nothing else")
        }

        if (suit2.name != "nothing else") {

            val result = suit1.actionAgainst(suit2)
//            val resultSuit1 = suit1.actionAgainst(suit2)
//            val resultSuit2 = suit2.actionAgainst(suit1)

            println("""
                 
                Hasil
                ${result.status}""".trimIndent())
//            println("player2 = ${resultSuit2.status}")
        } else {
            println("silahkan input kembali")
            startSuit()
        }

    }
}