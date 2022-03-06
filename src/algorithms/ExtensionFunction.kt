package algorithms

fun main(){
    val nums : ArrayList<Int>  = arrayListOf(1,2,3,4,5,6,7,8,9)
    nums.multiply(2)
    nums.removeConditionally { item : Int -> item%3 == 0 }
    println(nums)
}

/* extension with lambda function as param */
fun ArrayList<Int>.removeConditionally(predicate : (Int)-> Boolean){
    var iterator = this.iterator()
    while(iterator.hasNext()){
        if(predicate.invoke(iterator.next())){
            iterator.remove()
        }
    }
}

/* extension with regular param */
fun ArrayList<Int>.multiply(times: Int) {
    for(i in 0 until this.size) {
        println("$i - ${get(i)}")
        val temp = get(i)
        add(i, temp*times )
        remove(temp)
    }
}