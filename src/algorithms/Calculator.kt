package algorithms

import algorithms.util.IOUtils

object Calculator {

    /* static abstract class Operation {
     *   private Function logic; //functional interface
     *   Operation(Function f) { this.logic = f );
     * }
     */
     enum class Operation(val logic : (Int, Int)-> Int){
        ADD({ x: Int , y: Int -> x+y }),
        SUB({ x: Int , y: Int -> x+y }),
        DIV({ x: Int , y: Int -> x+y }),
        MUL({ x: Int , y: Int -> x+y }),
     }

    /* define singleton types 'ADD', 'SUB', 'MUL', 'DIV' - equivalent to inner class definitions in Java */
    /* static class ADD extends Operation {
     *   ADD(){
     *      super((int x, int y)-> x+y);
     *   }
     * }
     */

    private fun getOperationFromChar(ch : Char): Calculator.Operation? {
        return when(ch){
            '+' -> Calculator.Operation.ADD
            '-' -> Calculator.Operation.SUB
            '*' -> Calculator.Operation.MUL
            '/' -> Calculator.Operation.DIV
            else -> null
        }
    }

    fun eval(ch: Char, x: Int, y: Int): Int? {
        val op : Calculator.Operation? = getOperationFromChar(ch)
        return op?.logic?.invoke(x,y)
    }

}


fun main(){
    println("Result : ${Calculator.eval(
        IOUtils.readChar("Enter desired operation (+,-,*,/) "),
        IOUtils.readInteger("Enter first number"),
        IOUtils.readInteger("Enter second number"))}")
}