package problems.easy.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: <a href="https://leetcode.com/problems/move-zeroes">
 * move-zeroes</a>
 * Time Complexity: O(NlogN) / O(N)
 * Space Complexity： O(N) / O(1)
 */
class Solution283 {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        for (int i = insertPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        List<Integer> res = Arrays.stream(nums).boxed().sorted((a, b) -> {
            if (a == 0 && b != 0) {
                return 1;
            } else if (a != 0 && b == 0) {
                return -1;
            } else {
                return 0;
            }
        }).toList();
        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }
    }

    public void moveZeroes2(int[] nums) {
        System.arraycopy(
                Arrays.stream(nums)
                      .boxed()
                      .sorted((a, b) -> {
                          if (a == 0 && b != 0) {
                              return 1;
                          } else if (a != 0 && b == 0) {
                              return -1;
                          } else {
                              return 0;
                          }
                      })
                      .mapToInt(Integer::intValue)
                      .toArray(),
                0,
                nums,
                0,
                nums.length
        );
    }
}
