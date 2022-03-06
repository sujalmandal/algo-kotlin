package algorithms.kotlin

import algorithms.kotlin.util.IOUtils
import java.util.*

fun main() {
    val numbers : Array<Int> = arrayOf(6,4,90,78,43,14,54,112,75,23)
    val numberToSearch = IOUtils.readInteger("Enter number to search.");
    var search = BinarySearch(numbers);
    if(search.hasElement(numberToSearch)) println("element found at : ${search.indexOf(numberToSearch)} ")
    else println("$numberToSearch was not found!")
}

class BinarySearch(private val array: Array<Int>){
    private var foundIndex : Int? = null;
    private var searchExecuted : Boolean = false;
    init {
        Arrays.sort(array)
        println("sorting array of size ${array.size}")
    }

    fun hasElement(element : Int): Boolean = indexOf(numberToSearch = element) !=null;

    fun indexOf(numberToSearch: Int): Int? {
        if(searchExecuted) return foundIndex;
        searchExecuted = true;
        println("searching $numberToSearch..")
        var index: Int? = null;
        var left  = 0;
        var right = array.size-1;

        var mid = calculateMid(leftIndex = left, rightIndex = right);
        var iterations = 0;
        while(left<=right){
            iterations++;
            printSearchableArray(left,right);
            if (array[mid]==numberToSearch) {
                println("Found element at $mid");
                index = mid;
                break;
            }
            if (numberToSearch > array[mid]){
                println("$numberToSearch lies on the right side");
                left = mid + 1 ;
                mid = calculateMid(leftIndex = left, rightIndex = right);
            }
            if(numberToSearch < array[mid]){
                println("$numberToSearch lies on the left side");
                right = mid - 1;
                mid = calculateMid(leftIndex = left, rightIndex = right);
            }
        }
        println("performed total $iterations search iterations");
        foundIndex = index;
        return index;
    }

    private fun calculateMid(leftIndex: Int, rightIndex: Int) : Int = leftIndex + (rightIndex-leftIndex)/2;

    private fun printSearchableArray(leftIndex: Int, rightIndex: Int, mid: Int = calculateMid(leftIndex, rightIndex)) : Unit {
        println("left: $leftIndex , right: $rightIndex")
        for (index in leftIndex..rightIndex) {
            if(index==mid) print("[${array[index]}] ")
            else print("${array[index]} ")
        }
        println()
    }
}