# Write your MySQL query statement below
Select Distinct(l.Num) as ConsecutiveNums from Logs l, Logs l1, Logs l2
Where l1.Id = l.Id + 1
AND l1.Num = l.Num
AND l2.Id = l.Id + 2 
AND l2.Num = l.Num


