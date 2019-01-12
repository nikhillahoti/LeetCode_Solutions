# Write your MySQL query statement below

// Problem No. 182
Select Email from (
Select Email, count(Email) as Cou from Person
group by Email
having Cou >  1
) A

