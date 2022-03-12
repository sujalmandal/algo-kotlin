package algorithms.kotlin

data class GraphNode (
    val data:Int,
    var isVisited: Boolean = false,
    var children: MutableList<GraphNode> = mutableListOf()
);

class Graph(private val size:Int){

    /* static variables */
    companion object {
        private const val DELIMITER = "->";
    }

    private var adjacencyMatrix : MutableList<MutableList<Int>> = mutableListOf();

    init {
        for (i in 0 until size){
            var row: MutableList<Int> = mutableListOf();
            for(j in 0 until size){
                row.add(0);
            }
            adjacencyMatrix.add(row);
        }
    }

    fun fill(connections:Array<String>){
        for(connection :String in connections){
            val nodes : List<String> = connection.split(DELIMITER);
            val fromNode: Int = Integer.parseInt(nodes[0]);
            val toNode: Int = Integer.parseInt(nodes[1]);
            if(fromNode<size && toNode<size)
                adjacencyMatrix[fromNode-1][toNode-1] = 1;
        }
    }

    fun print(){
        print("    ");
        for(i in 0 until this.size) print("${i+1} ")
        println();
        var i = 1;
        for(row: List<Int> in this.adjacencyMatrix) {
            print("${i++} | ")
            for(el: Int in row){
                print("${if(el==1) "o" else "x"} ");
            }
            println();
        }
    }

}

fun main(){
    val myGraph : Graph = Graph(5);
    /*
        1----3
        |    |
        2----4
 */
    /* fill the edges */
    myGraph.fill(arrayOf("1->3","1->2","2->4","4->9"));
    myGraph.print();
/*
    we need to construct an adjacency matrix that looks like the below matrix
         1  2  3  4  5
        _______________
    1  | x  o  o  x  x
    2  | x  x  x  o  x
    3  | x  x  x  x  x
    4  | x  x  o  x  x
    5  | x  x  x  x  x
 */

}

