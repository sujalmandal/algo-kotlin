package algorithms.kotlin

val adjacencyMatrix : Array<Array<Int>> = arrayOf(
    arrayOf(0,0,0,0),
    arrayOf(0,0,0,0),
    arrayOf(0,0,0,0),
    arrayOf(0,0,0,0)
);

fun Array<Array<Int>>.print(){
    for(row: Array<Int> in adjacencyMatrix) {
        for(el: Int in row){
            print("${if(el==1) "o" else "x"} ");
        }
        println();
    }
}

/*
        1----3
        |
        2----4
 */
val connections:Array<String> = arrayOf("1->3","1->2","2->4")
/*
    we need to construct an adjacency matrix that looks like the below matrix
         1  2  3  4
        ____________
    1  | x  o  o  x
    2  | x  x  x  o
    3  | x  x  x  x
    4  | x  x  x  x
 */

private const val DELIM = "->"

fun main(){
    for(connection :String in connections){
        val nodes : List<String> = connection.split(DELIM);
        val fromNode: Int = Integer.parseInt(nodes[0]);
        val toNode: Int = Integer.parseInt(nodes[1]);
        adjacencyMatrix[fromNode-1][toNode-1] = 1;
    }
    adjacencyMatrix.print();
}

