# Write your MySQL query statement below
SELECT temp.Email
FROM (SELECT email as 'Email', COUNT(*) as count
      FROM Person
      GROUP BY email) as temp
WHERE temp.count > 1
