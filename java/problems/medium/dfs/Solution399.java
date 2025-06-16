package problems.medium.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/evaluate-division">
 * evaluate-division</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, List<Double>> weights = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            graph.putIfAbsent(equation.get(0), new ArrayList<>());
            graph.get(equation.get(0)).add(equation.get(1));
            weights.putIfAbsent(equation.get(0), new ArrayList<>());
            weights.get(equation.get(0)).add(values[i]);

            graph.putIfAbsent(equation.get(1), new ArrayList<>());
            graph.get(equation.get(1)).add(equation.get(0));
            weights.putIfAbsent(equation.get(1), new ArrayList<>());
            weights.get(equation.get(1)).add(1.0 / values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            result[i] = !graph.containsKey(queries.get(i).get(0)) ? -1
                    : dfs(graph, weights, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), 1.0);
        }

        return result;
    }

    private double dfs(Map<String, List<String>> graph, Map<String, List<Double>> weights, String curr,
                       String end, HashSet<String> used, double curValue) {
        used.add(curr);
        if (curr.equals(end)) {
            return curValue;
        }
        double res = -1.0;
        List<String> neighbors = graph.getOrDefault(curr, List.of());
        for (int i = 0; i < neighbors.size(); i++) {
            String to = neighbors.get(i);
            if (!used.contains(to)) {
                double weight = weights.get(curr).get(i);
                double temp = dfs(graph, weights, to, end, used, curValue * weight);
                if (temp != -1.0) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}
