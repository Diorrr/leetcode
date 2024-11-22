package problems.medium.binsearch;


/**
 * Problem: <a href="https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store">
 * minimized-maximum-of-products-distributed-to-any-store</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = 100000;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = count(quantities, mid);
            if (count == n && count(quantities, mid-1) != n) {
                return mid;
            }
            if (count > n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    private int count(int[] quantities, int mid) {
        if (mid == 0) {
            return 0;
        }
        int res = 0;
        for (int quantity : quantities) {
            res += (quantity + mid -1) / mid;
        }
        return res;
    }
}
