package problems.medium.string;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-sub-folders-from-the-filesystem">
 * remove-sub-folders-from-the-filesystem</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1233 {

    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Set<String> exist = new HashSet<>(List.of(folder));
        for (String fold : folder) {
            if (isSubfolder(fold, exist)) {
                res.add(fold);
            }
        }
        return res;
    }

    private boolean isSubfolder(String fold, Set<String> exist) {
        var split = fold.split("/");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < split.length - 1; i++) {
            sb.append("/").append(split[i]);
            if (exist.contains(sb.toString())) {
                return false;
            }
        }
        return true;
    }
}
