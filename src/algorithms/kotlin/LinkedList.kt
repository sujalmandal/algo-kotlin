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
    var revRoot : Node? = null;
    var revCurrent : Node? = null;
    fun rev(n : Node?){
        if(n?.next!=null) {
            rev(n.next);
            /* destroy the forward link in the unrevesed list */
            n.next = null;
            /* previous node in the unreversed list points to the current node now */
            revCurrent?.next=n;
            revCurrent=n;
        }
        else {
            /* new head of the reversed linked list */
            revRoot=n;
            revCurrent=n;
        }
    }
    rev(this.root);
    this.root = revRoot;
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
    ll.print();
}