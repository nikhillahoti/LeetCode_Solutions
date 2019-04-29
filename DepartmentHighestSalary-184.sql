# Write your MySQL query statement below
Select D.Name as Department, E.Name as Employee, E.Salary as Salary 
from Department D INNER JOIN EMPLOYEE E on E.DepartmentId = D.Id
Where E.Salary = (Select MAX(Salary) from Employee E1 where E1.DepartmentId = E.DepartmentId)
