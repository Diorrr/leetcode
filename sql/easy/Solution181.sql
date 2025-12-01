# Write your MySQL query statement below
# https://problems.leetcode.com/problems/employees-earning-more-than-their-managers
SELECT name as 'Employee'
FROM Employee e1
WHERE e1.salary > (SELECT salary FROM Employee WHERE salary < e1.salary AND id = e1.managerId)
