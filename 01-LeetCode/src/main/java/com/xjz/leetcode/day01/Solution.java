package com.xjz.leetcode.day01;

import com.xjz.leetcode.pojo.Student;
import com.xjz.leetcode.pojo.User;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {
        int[] sum = sum(Arrays.asList(12, 15, 31, 37, 41, 78)
                .stream().mapToInt(Integer::intValue).toArray(), 49);
        System.out.println(Arrays.toString(sum));
    }

    public static int[] sum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


}
