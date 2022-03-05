package algorithms.util

import java.util.*

/* singleton object */
object IOUtils {
    private val sc: Scanner = Scanner(System.`in`);
    fun readInteger(msg: String):Int {
        println("> $msg")
        return sc.nextInt();
    }
}