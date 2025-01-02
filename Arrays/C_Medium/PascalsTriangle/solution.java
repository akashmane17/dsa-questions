package Arrays.C_Medium.PascalsTriangle;

/**
Pascal's Triangle

In Pascal's triangle:

    The first row has one element with a value of 1.
    Each row has one more element in it than its previous row.
    The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.

Example 1
Input: numRows = 4
Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]
Explanation: 1st Row has its value set to 1.
All other cells take their value as the sum of the values directly above them

Example 2
Input: numRows = 5
Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
Explanation: 1st Row has its value set to 1.
All other cells take their value as the sum of the values directly above them


Solution: 
The code iterates through the number of rows specified by the numRows parameter.
In each iteration:

    prevRow: The previous row in the triangle is extracted from the ans array.
    currRow: An empty array is created to store the elements of the current row.
    The code iterates through the elements of the prevRow:
        First Element: The first element of the currRow is always 1.
        Last Element: The last element of the currRow is always 1.
        Middle Elements: Each middle element of the currRow is calculated by summing the corresponding element and its preceding element in the prevRow.
    The currRow is added to the ans array.

 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        result.add(new ArrayList<>(List.of(1)));

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currRow = new ArrayList<>();

            for (int j = 0; j <= prevRow.size(); j++) {
                // if it is first or last add 1
                if (j == 0 || j == prevRow.size()) {
                    currRow.add(1);
                } else {
                    // add sum of two elements above it
                    currRow.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }

            result.add(currRow);
        }

        return result;
    }
}