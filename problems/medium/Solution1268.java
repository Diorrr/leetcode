package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/search-suggestions-system/
 * Time Complexity:
 * Space Complexity：
 */
class Solution1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> prefixRes = new ArrayList<>();
            String prefixSearchWord = searchWord.substring(0, i + 1);
            for (int j = 0; j < products.length && prefixRes.size() < 3; j++) {
                if (products[j].length() > i && products[j].substring(0, i + 1).equals(prefixSearchWord)) {
                    prefixRes.add(products[j]);
                }
            }
            res.add(prefixRes);
        }

        return res;
    }
}
