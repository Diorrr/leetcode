package problems.leetcode.medium.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-genetic-mutation">
 * minimum-genetic-mutation</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> visited = new HashSet<>();
        Queue<String> queueGene = new LinkedList<>();
        Queue<Integer> queueStep = new LinkedList<>();
        visited.add(startGene);
        queueGene.offer(startGene);
        queueStep.offer(0);

        while (!queueGene.isEmpty()){
            String currGene = queueGene.poll();
            int currStep = queueStep.poll();
            if (currGene.equals(endGene)) {
                return currStep;
            }
            for (String gene : bank) {
                if (isOneMutation(currGene, gene) && !visited.contains(gene)) {
                    queueGene.offer(gene);
                    queueStep.offer(currStep + 1);
                    visited.add(gene);
                }
            }
        }
        return -1;
    }

    private boolean isOneMutation(String currGene, String gene) {
        int diffCount = 0;
        for (int i = 0; i < currGene.length(); i++) {
            if (currGene.charAt(i) != gene.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {

    }
}
