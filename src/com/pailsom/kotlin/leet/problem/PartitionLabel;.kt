package com.pailsom.kotlin.leet.problem

fun main(arg:Array<String>) {
    val p = PartitionLabel()
    println(p.partitionLabels("ababcbacadefegdehijhklij"))
}
class PartitionLabel {
    fun partitionLabels(S: String): List<Int> {
        var last:IntArray = IntArray(28)
        S.toCharArray().forEachIndexed{index, c -> last[c-'a'] = index }
        var j = 0
        var anchor:Int = 0
        val list = mutableListOf<Int>()
        S.toCharArray().forEachIndexed { index, c ->
            j = j.coerceAtLeast(last[c - 'a'])
            if (index==j){
                list.add(index-anchor+1)
                anchor = index + 1
            }
        }
        return list
    }
}