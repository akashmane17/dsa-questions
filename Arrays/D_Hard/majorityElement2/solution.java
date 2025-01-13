package Arrays.D_Hard.majorityElement2;

/**
Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.

Examples:
Input: nums = [1, 2, 1, 1, 3, 2]
Output: [1]
Explanation: Here, n / 3 = 6 / 3 = 2.
Therefore the elements appearing 3 or more times is : [1]

Input: nums = [1, 2, 1, 1, 3, 2, 2]
Output: [1, 2]
Explanation: Here, n / 3 = 7 / 3 = 2.
Therefore the elements appearing 3 or more times is : [1, 2]
 */

import java.util.*;

public class solution {

    // Method 1: Brute-force approach to find elements appearing more than n/3 times
    public List<Integer> majorityElementTwo1(int[] nums) {
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            // Count occurrences of nums[i]
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > nums.length / 3) {
                res.add(nums[i]);
            }
        }

        return new ArrayList<>(res);
    }

    // Method 2: Better approach using HashMap
    public List<Integer> majorityElementTwo2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        // Count the occurrences of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check for elements that appear more than n / 3 times
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    // Method 3: Optimal approach using Boyer-Moore Voting Algorithm
    public List<Integer> majorityElementTwo(int[] nums) {
        int n = nums.length;

        // Candidates for majority elements
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0;

        // Step 1: Find potential candidates
        for (int num : nums) {
            if (cnt1 == 0 && num != el2) {
                el1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0 && num != el1) {
                el2 = num;
                cnt2 = 1;
            } else if (num == el1) {
                cnt1++;
            } else if (num == el2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Step 2: Validate the candidates
        cnt1 = 0;
        cnt2 = 0;

        for (int num : nums) {
            if (num == el1)
                cnt1++;
            if (num == el2)
                cnt2++;
        }

        // Step 3: Check if candidates appear more than n/3 times
        List<Integer> result = new ArrayList<>();
        int mini = n / 3;

        if (cnt1 > mini)
            result.add(el1);
        if (cnt2 > mini && el1 != el2)
            result.add(el2);

        return result;
    }
}
