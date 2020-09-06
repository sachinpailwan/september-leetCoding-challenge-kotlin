package com.pailsom.kotlin.leet.problem

fun main(arg:Array<String>) {
    val p = RepeatSubStringPattern()
    println(p.repeatedSubstringPattern("aba"))
}
class RepeatSubStringPattern {
    fun repeatedSubstringPattern(str: String): Boolean {
        for (i in str.indices){
            for(j in i+1..str.length) {
                var rp = str.substring(i,j)
                if(rp.equals(str)) return false
                val replaced = str.replace(rp,"");
                if(replaced.isEmpty()) return true
            }
        }
        return false
    }
}