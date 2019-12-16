/**
*
*/

package tut1

/* fun main() { */
/* fun main() : Unit { */
/* fun main(vararg args: String) : Unit { */
fun main(args: Array<String>) : Unit {
    println("tut1: in main")
    println("${foo(1,2)}")
    println("${bar(1,2)}")
    val z1 = foo(x=1, y=2)
    /* val z2 = bar2(x=1) */
    val z3 = bar2(y=1)
    val z4 = bar2(1,y=2)
}

fun foo(x: Int, y: Int) : Int {
    // return within function body
    return x + y
}

fun bar(x: Int, y: Int) : Int = x+y
fun bar1(x: Int, y: Int) = x+y
fun bar2(x: Int=0, y: Int) = x+y
fun bar3(x: Int, y: Int=0) = x+y
fun bar4(x: Int=0, y: Int=0) = x+y

