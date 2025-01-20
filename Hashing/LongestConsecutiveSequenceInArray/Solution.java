package Hashing.LongestConsecutiveSequenceInArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Brute Force: O(n^2)
class Solution {
    public boolean linearSearch(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num)
                return true;
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        int longest = 1;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int cnt = 1;
            while (linearSearch(nums, x + 1)) {
                x += 1;
                cnt += 1;
            }
            longest = Math.max(longest, cnt);
        }

        return longest;
    }
}

// Better Approach: O(n log n) + O(n)
class Solution2 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Arrays.sort(nums); // Sort the array

        int longest = 0;
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;

        for (int num : nums) {
            if (num - 1 == lastSmaller) {
                cnt += 1;
                lastSmaller = num;
            } else if (num != lastSmaller) {
                cnt = 1;
                lastSmaller = num;
            }
            longest = Math.max(longest, cnt);
        }

        return longest;
    }
}

// Optimal Approach: O(n)
class Solution3 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) { // Start of a sequence
                int cnt = 1;
                int x = num;

                while (set.contains(x + 1)) {
                    cnt += 1;
                    x += 1;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }
}
