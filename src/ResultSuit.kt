
class ResultSuit(val status: String) {
    companion object {
        const val WIN: String = "Pemain 1 MENANG"
        const val LOSE: String = "Pemain 2 MENANG"
        const val DRAW: String = "DRAW"
        const val EMPTY: String = ""
    }
}