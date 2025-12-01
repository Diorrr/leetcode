# Write your MySQL query statement below
# https://problems.leetcode.com/problems/second-highest-salary/
SELECT salary as 'SecondHighestSalary'
FROM Employee
ORDER BY salary
    LIMIT 1, 1