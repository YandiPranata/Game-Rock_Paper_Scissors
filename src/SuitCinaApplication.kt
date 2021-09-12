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
    println("Input suit (rock | paper | scissors)")
//    val input = readLine()


    loop@ while(true){
        println("Input Pemain 1: ")
        val input = readLine()
        val mySuit = when (input) {
            "scissors" -> Scissors(StringContainer.scissors)
            "rock" -> Rock(StringContainer.rock)
            "paper" -> Paper(StringContainer.paper)
            else -> continue@loop
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
    }

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