package algorithms

import algorithms.util.IOUtils

object Calculator {
    /* static abstract class Operation {
     *   private Function logic; //functional interface
     *   Operation(Function f) { this.logic = f );
     * }
     */
    sealed class Operation(val logic : (Int, Int)-> Int)
    /* define singleton types 'ADD', 'SUB', 'MUL', 'DIV' - equivalent to inner class definitions in Java */
    /* static class ADD extends Operation {
     *   ADD(){
     *      super((int x, int y)-> x+y);
     *   }
     * }
     */
    object ADD: Operation({ x: Int , y: Int -> x+y } )
    object SUB: Operation({ x: Int , y: Int -> x-y })
    object MUL: Operation({ x: Int , y: Int -> x*y })
    object DIV: Operation({ x: Int , y: Int -> x/y })

    private fun getOperationFromChar(ch : Char): Operation? {
        return when(ch){
            '+' -> ADD
            '-' -> SUB
            '*' -> MUL
            '/' -> DIV
            else -> null
        }
    }

    fun eval(ch: Char, x: Int, y: Int): Int? {
        val op : Operation? = getOperationFromChar(ch)
        return op?.logic?.invoke(x,y)
    }
}


fun main(){
    println("Result : ${Calculator.eval(
        IOUtils.readChar("Enter desired operation (+,-,*,/) "),
        IOUtils.readInteger("Enter first number"),
        IOUtils.readInteger("Enter second number"))}")
}