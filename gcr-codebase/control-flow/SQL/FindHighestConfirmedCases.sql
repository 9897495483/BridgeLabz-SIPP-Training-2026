SELECT c.country_name,
       cc.confirmed_cases,
       cc.report_date
FROM covid_cases cc
INNER JOIN countries c
ON cc.country_id = c.country_id
WHERE cc.report_date = '2021-05-01'
ORDER BY cc.confirmed_cases DESC
LIMIT 1;