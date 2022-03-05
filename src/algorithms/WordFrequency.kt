const val SPACE: String = " "

fun main(args: Array<String>) {

    val words = "I am living in an simulation, and today I got access to the code. " +
            "I now know, about this simulation, including how to control certain parts of it"
    var countMap = mutableMapOf<String, Int>()

    words.split(SPACE).forEach {
            word -> with(countMap){
                val previousCount = getOrDefault(word, 0)
                put(word, previousCount+1)
            }
    }

    countMap.forEach {
            entry-> println("word : ${entry.key}, count : ${entry.value}")
    }

}