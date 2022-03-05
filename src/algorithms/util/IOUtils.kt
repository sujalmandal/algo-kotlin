package algorithms.util

import java.util.*

/* singleton object */
object IOUtils {
    private val sc: Scanner = Scanner(System.`in`);
    fun readInteger(msg: String):Int {
        println("> $msg");
        val input : Int = sc.nextInt();
        return input;
    }

    fun readChar(msg: String): Char {
        println("> $msg");
        val ch : Char = sc.nextLine()[0]
        return ch;
    }

}