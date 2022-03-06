package algorithms

fun main(){
    val name = "Sujal Mandal"
    println("$name has a space? : ${name.hasSpace()}")
}
/* moves the contents of the body inside of the caller function */
inline fun String.hasSpace() : Boolean {
    for(ch in this) if(ch == ' ') return true
    return false
}