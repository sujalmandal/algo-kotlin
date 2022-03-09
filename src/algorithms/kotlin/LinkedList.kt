package algorithms.kotlin

data class Node(val value:Int, var next : Node? = null)

class LinkedList(var root: Node? = null){
    var currentNode : Node? = null;
}

fun LinkedList.add(node : Node) {
    if(root==null) {
        this.root = node;
        this.currentNode = root;
    }
    else {
        this.currentNode?.next = node;
        this.currentNode = node;
    }
}

fun LinkedList.reverse(){
    fun rev(n : Node?){
        if(n==null) return;
        rev(n?.next);
        print("[${n?.value}] ");
    }
    rev(this.root);
}


fun LinkedList.print(){
    val printer = fun (node : Node?) {
        var temp = node;
        while(temp!=null){
            println(temp.value);
            temp = temp?.next;
        }
    }
    printer(this.root);
}

fun main() {
    val ll = LinkedList()
    with(ll){
        add(Node(1));
        add(Node(2));
        add(Node(3));
        add(Node(4));
    }
    ll.print();
    println("----");
    ll.reverse();
}