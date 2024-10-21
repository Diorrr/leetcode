package problems.hard.recursion;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/parsing-a-boolean-expression">
 * parsing-a-boolean-expression</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1106 {
    public boolean parseBoolExpr(String expression) {
        if (expression.equals("f")) {
            return false;
        } else if (expression.equals("t")) {
            return true;
        } else {
            if (expression.startsWith("!")) {
                return !parseBoolExpr(expression.substring(2, expression.length() - 1));
            } else {
                List<Boolean> subExprList = new ArrayList<>();
                int balance = 0;
                StringBuilder sb = new StringBuilder();
                for (char c : expression.substring(2, expression.length() - 1).toCharArray()) {
                    if (c == ',' && balance == 0) {
                        subExprList.add(parseBoolExpr(sb.toString()));
                        sb = new StringBuilder();
                    } else {
                        if (c == '(') {
                            balance++;
                        } else if (c == ')') {
                            balance--;
                        }
                        sb.append(c);
                    }
                }
                boolean res = parseBoolExpr(sb.toString());

                if (expression.startsWith("&")) {
                    for (Boolean subExpr : subExprList) {
                        res = res && subExpr;
                    }
                } else {
                    for (Boolean subExpr : subExprList) {
                        res = res || subExpr;
                    }
                }
                return res;
            }
        }
    }

    public boolean parseBoolExpr2(String expression) {
        return helper(expression.toCharArray());
    }

    public boolean helper(char[] expression) {
        if (expression.length == 1) {
            return expression[0] == 't';
        } else {
            if (expression[0] == '!') {
                return !parseBoolExpr(String.valueOf(expression).substring(2, expression.length - 1));
            } else {
                Boolean res;
                List<Boolean> list = new ArrayList<>();
                int balance = 0;
                StringBuilder sb = new StringBuilder();
                for (int i = 2; i < expression.length - 1; i++) {
                    if (expression[i] == ',' && balance == 0) {
                        list.add(parseBoolExpr(sb.toString()));
                        sb = new StringBuilder();
                    } else {
                        if (expression[i] == '(') {
                            balance++;
                        } else if (expression[i] == ')') {
                            balance--;
                        }
                        sb.append(expression[i]);
                    }
                }
                res = parseBoolExpr(sb.toString());
                if (expression[0] == '&') {
                    for (Boolean aBoolean : list) {
                        res = res & aBoolean;
                    }
                } else {
                    for (Boolean aBoolean : list) {
                        res = res | aBoolean;
                    }
                }
                return res;
            }
        }
    }
}
