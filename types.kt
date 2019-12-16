/**
* package: tut1 
* file: types.kt
  cmd: kotlinc types.kt && java -cp $JAVA_LIB tut1/TypesKt
*/

package tut1

typealias Int64 = Long

fun prod(n: Int) : Int64 {
    tailrec fun prod_rec(k: Int, result: Int64) : Int64 {
        if(k == 1) {
            return result
        } else {
            return prod_rec(k-1, k*result)
        }
    }
    return prod_rec(k = n, result = 1)
}

fun check_overflow() {
    var b1: Byte = 127
    var b2: Byte = 1
    var b3 = b1 + b2
    println("$b3")

    for(i in 1..10) {
        print("${b1++}, ")
    }
}

fun main(args: Array<String>) : Unit {
    println("tut1: types")
    for(arg in args) {
        println("$arg")
    }
    val (a,b) = s(1,2)
    val (_,_) = s(1,2)
    println("$a,$b")

    setPQ()

    println("prod(5) = ${prod(5)}")
    println("prod(5) = ${prod(15)}")

    check_overflow()

    test()

    // why _ not allowed here?
    // val _ = p(1)
    val c = p(1)
    System.exit(c)
}

val p: (Int) -> Int = { x -> x+1 }
val q: (Int,Int) -> Int = { x,y -> x+y }
// JVM does not allow to return more than one value
// return tuple not possible (rust and swift allows this)
//val s: (Int,Int) -> (Int,Int) = {x,y -> (y,x)}
val s: (Int,Int) -> Pair<Int,Int> = {x,y -> Pair(y,x)}

val t0: (Int,Int,Int) -> Array<Int> = {x,y,z -> arrayOf(x,y,z)}
val t1: (Int,Int,Int) -> Array<Int> = {x,_,_ -> arrayOf(x,x,x)}
val t2: (Int,Int,Int) -> Array<Int> = {_,y,_ -> arrayOf(y,y,y)}
val t3: (Int,Int,Int) -> Array<Int> = {_,_,z -> arrayOf(z,z,z)}
var pq: (Int,Int,Int) -> Array<Int> = t0 

fun Array<Int>.Dump(msg: String = "") {
    print("$msg = [")
    for(x in this) {
        print("$x, ")
    }
    println("]")
}

fun Array<Int>.DumpStr(msg: String = "") : String {
    var txt = msg + " = ["
    this.forEach { x ->
        txt = txt + "$x, "
    }
    return txt + "]"
}

fun <T> Array<T>.DumpT() {
    forEach { x ->
        print("$x, ")
    }
    println("")
}

fun setPQ() {
    pq(1,2,3).Dump("1")
    pq = t1
    pq(1,2,3).Dump("2")
    pq = t2
    println(pq(1,2,3).DumpStr("3"))
    pq = t3
    pq(1,2,3).DumpT()
}

fun test() {
    val l = listOf<Double>(1.0,2.0,3.0)
    val a = arrayOf<Double>(1.0,2.0,3.0)
    val d = mapOf<Int,String>(0 to "zero", 1 to "one", 2 to "two")
    val s = setOf(1,2,3,1)
    println("$l, $a, $d, $s")

    val ma = mutableListOf<Double>(1.0,2.0,3.0)
    val md = mutableMapOf<Int,String>(0 to "zero", 1 to "one", 2 to "two")
    val ms = mutableSetOf(1,2,3,1)
    println("$ma, $md, $ms")

    val x = mapOf<Int,String>(0 to "zero", 1 to "one", 2 to "two", 3 to "three").withDefault { "empty" }
    println("${x[0]}")
    println("${x[1]}")
    println("${x[2]}")
    println("${x[3]}")
    println("${x[4]}") // null
    println("${x.getValue(0)}")
    println("${x.getValue(1)}")
    println("${x.getValue(2)}")
    println("${x.getValue(3)}")
    println("${x.getValue(4)}") // empty
}

