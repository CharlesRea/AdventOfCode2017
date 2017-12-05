fun isValidPassphrasePartOne(passphrase: String): Boolean {
    val words = passphrase.split(' ')
    return words.size == words.distinct().size
}

fun isValidPassphrasePartTwo(passphrase: String): Boolean {
    val words = passphrase.split(' ').map( { it.toCharArray().sortedArray().joinToString("") } )
    return words.size == words.distinct().size
}

fun main(args: Array<String>) {
    println(passphrases.filter { isValidPassphrasePartOne(it) }.size)
    println(passphrases.filter { isValidPassphrasePartTwo(it) }.size)
}