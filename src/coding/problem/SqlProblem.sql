--1. Delete Duplicate Emails from the table person which havs id as the primary key and email as other columns

delete p1 from Person p1, person p2 where p1.email = p2.email and p1.id > p2.id;

--p1.Email = p2.Email: This condition matches rows where the Email values in p1 and p2 are identical.
--p1.id > p2.Id: This condition further filters to select rows where p1.id is greater than p2.id. This essentially means you're deleting the rows with higher IDs for each duplicate email address.

----------------------------------------------------------------------

select w1.id from weather w1, weather w2 where
    w1.temperature > w2.temperature and DATEDIFF(w1.recordDate, w2.recordDate) = 1 ;

SELECT w1.id
FROM Weather w1
         INNER JOIN Weather w2
                    ON w1.recordDate = DATE_ADD(w2.recordDate,INTERVAL 1 DAY)
WHERE w1.temperature > w2.temperature;

----------------------------------------------------------------------