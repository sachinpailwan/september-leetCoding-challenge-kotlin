package com.pailsom.leetcode.problem

import java.util.HashMap

class Solution {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        if (k < 1 || t < 0) return false
        val map: MutableMap<Long, Long> = HashMap()
        for (i in nums.indices) {
            val remappedNum = nums[i].toLong() - Int.MIN_VALUE
            val bucket = remappedNum / (t.toLong() + 1)
            if (map.containsKey(bucket)
                || map.containsKey(bucket - 1) && remappedNum - map[bucket - 1]!! <= t
                || map.containsKey(bucket + 1) && map[bucket + 1]!! - remappedNum <= t
            ) return true
            if (map.entries.size >= k) {
                val lastBucket = (nums[i - k].toLong() - Int.MIN_VALUE) / (t.toLong() + 1)
                map.remove(lastBucket)
            }
            map[bucket] = remappedNum
        }
        return false
    }
}