package Arrays.C_Medium.ThreeSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array nums.Return all triplets such that:
 * i != j, i != k, and j != k
 * nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets. One element
 * can be a part of multiple triplets. The output and the triplets can be
 * returned in any order.
 * 
 * Example 1
 * Input: nums = [2, -2, 0, 3, -3, 5]
 * Output: [[-2, 0, 2], [-3, -2, 5], [-3, 0, 3]]
 * Explanation: nums[1] + nums[2] + nums[0] = 0
 * nums[4] + nums[1] + nums[5] = 0
 * nums[4] + nums[2] + nums[3] = 0
 * 
 * Example 2
 * Input: nums = [2, -1, -1, 3, -1]
 * Output: [[-1, -1, 2]]
 * Explanation: nums[1] + nums[2] + nums[0] = 0
 *
 * Note that we have used two -1s as they are separate elements with different
 * indexes
 * But we have not used the -1 at index 4 as that would create a duplicate
 * triplet
 * 
 * Brute Force :
 * The most naive idea is to check all possible triplets using 3 loops and among
 * them, consider the ones whose sum is equal to the given target 0.
 * 
 * Before taking them as the answer, sort the triplets in ascending order so as
 * to consider only the unique triplets.
 * 
 * Approach
 * Declare a set data structure for storing the unique triplets.
 * Used nested loops to traverse the array, and take triplets into
 * account.
 * 
 * First loop will run from 0th index till the length of array, lets call it i.
 * Inside it, there will be the another loop(say j) that will run from i+1 to
 * n-1. Then a third loop(say k) that runs from j+1 to n-1.
 * 
 * Now, inside these 3 nested loops, check the sum of arr[i] and arr[j] and
 * arr[k], and if it is equal to the target i.e. 0 sort this triplet and insert
 * it in the set data structure. Finally, return the list of triplets stored in
 * the set data structure.
 * 
 * 
 * Better Solution
 * Intuition:
 * The better approach uses simple mathematics where some calculative parameter
 * is taken in RHS(right hand side) to compute the result.
 * 
 * For example if a + b + c = 0, then a + b = -c. Similar idea is used here.
 * 
 * Approach
 * Declare a set data structure to store unique triplets. Then iterate in the
 * array lets call the variable i from index 0 to n -1. Inside it, there will be
 * the second loop(say j) that will run from i+1 to n-1.
 * 
 * Declare another HashSet to store the array elements as we intend to search
 * for the third element using this HashSet.
 * 
 * Inside the nested loop, calculate the value of the third element i.e.
 * -(arr[i]+arr[j]).
 * 
 * If the third element exists in the HashSet, sort these 3 values i.e. arr[i],
 * arr[j], and the third element, and insert it in the set data structure
 * declared in step 1.
 * 
 * After that, insert the j-th element i.e. arr[j] in the HashSet as we only
 * want to insert those array elements that are in between indices i and j.
 * 
 * Finally, return a list of triplets stored in the set data structure.
 * 
 */

class Solution {
    // Function to find triplets having sum equals to target
    public List<List<Integer>> threeSum1(int[] nums) {
        // Set to store unique triplets
        Set<List<Integer>> tripletSet = new HashSet<>();

        int n = nums.length;

        // Check all possible triplets
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Found a triplet that sums up to target
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        /*
                         * Sort the triplet to ensure
                         * uniqueness when storing in set
                         */
                        Collections.sort(temp);
                        tripletSet.add(temp);
                    }
                }
            }
        }

        // Convert set to list of lists (unique triplets)
        List<List<Integer>> ans = new ArrayList<>(tripletSet);

        // Return the ans
        return ans;
    }

    // Optimal appraoch
    public List<List<Integer>> threeSum2(int[] nums) {
        // Set to store unique triplets
        Set<List<Integer>> tripletSet = new HashSet<>();

        int n = nums.length;

        // Check all possible triplets
        for (int i = 0; i < n; i++) {
            // Set to store elements seen so far in the loop
            Set<Integer> hashset = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                // Calculate the 3rd element needed to reach 0
                int third = -(nums[i] + nums[j]);

                /*
                 * Find if third element exists in
                 * hashset (complements seen so far)
                 */
                if (hashset.contains(third)) {
                    // Found a triplet that sums up to target
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);

                    /*
                     * Sort the triplet to ensure
                     * uniqueness when storing in set
                     */
                    Collections.sort(temp);
                    tripletSet.add(temp);
                }

                /*
                 * Insert the current element
                 * into hashset for future checks
                 */
                hashset.add(nums[j]);
            }
        }

        // Convert set to list of lists (unique triplets)
        List<List<Integer>> ans = new ArrayList<>(tripletSet);

        // Return the ans
        return ans;
    }
}