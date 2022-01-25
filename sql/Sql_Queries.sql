-- >> 2nd largest value in a column in Table
SELECT MAX (column_name) FROM table_name
WHERE column_name NOT IN (SELECT Max (column_name) FROM table_name);

-- >> Nth largest value in a column :: Get the top N largest element and sort them in asc and get the first one will be the Nth largest value
SELECT MAX(COLUMN_NAME) FROM (SELECT MAX(COLUMN_NAME) FROM TABLE NAME ORDER BY COLUMN_NAME DESC LIMIT N)
ORDER BY COLUMN_NAME ASC LIMIT 1;

-- >> Find Max Salary from each department.
 SELECT DeptID, MAX(Salary) FROM Employee GROUP BY DeptID.

 -- >> Cities in STATION with the shortest and longest CITY names, as well as their respective lengths
 -- If there is more than one smallest or largest city, choose the one that comes first when ordered alphabetically.
 -- in oracle
 select city, length(city)
 from (select * from station order by length(city) asc, city asc)
 where rownum <= 1;

 select city, length(city)
 from (select * from station order by length(city) desc, city asc)
 where rownum <= 1;

 -- >> CITY names starting with vowels
 select distinct city from station where lower(substr(city,1,1)) in ('a', 'e', 'i', 'o','u');
 -- OR
 select distinct city from station where city like 'a%' or city like 'e%' or city like 'i%'
 or city like 'o%' or city like 'u%';

  -- >> CITY names ending with vowels
 SELECT DISTINCT CITY FROM STATION WHERE LOWER(SUBSTR(CITY,-1,1)) IN ('a','e','i','o','u');

--- >>> CITY and COUNTRY tables, query the names of all the continents (COUNTRY.Continent) and
--  their respective average city populations (CITY.Population) rounded down to the nearest integer

select co.continent, floor(avg(ct.population)) from country co, city ct where ct.countrycode = co.code
group by (co.continent);

---- >>>>
-- setting the name as null for grades less than 7 and joining the marks with the grade table that is having grade,
-- min_mark, max_mark

select
    case when g.grade > 7 then s.name else 'NULL' end  as nameOrNull, g.grade, s.marks
    from Students s, Grades g where s.marks between g.min_mark and g.max_mark order by g.grade desc, s.name asc;

----- >>>>
-- https://www.hackerrank.com/challenges/harry-potter-and-wands/problem

select w.id, wp.age, w.coins_needed, w.power from wands w, wands_property wp where w.code = wp.code and wp.is_evil = 0
and w.coins_needed in (select min(coins_needed) from wands wan where wan.code = wp.code group by wan.power)
order by w.power desc, wp.age desc;

----- >>>
-- Combining two tables having same column and finding the total count of same values

select id, count(*) from
 (
  select * from table1
  union all
  select * from table2
 )
group by id;
