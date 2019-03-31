select A.class from (
Select distinct c1.student as student, c1.class as class from courses c1
) A
group by class 
having count(*) >= 5
