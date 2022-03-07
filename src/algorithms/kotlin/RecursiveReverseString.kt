package algorithms.kotlin

fun main(){
    println("Hello".reverseIt())
}

inline fun String.reverseIt() : String {
    return rev(this)
}

fun rev(str: String) :String {
    println(str)
    if(str.length==1) return str;
    val firstChar = str[0];
    val restOfString = str.substring(1 until str.length)
    return rev(restOfString)+firstChar
}