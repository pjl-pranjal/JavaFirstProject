-- 1.Write a query which displays the module code and the duration for modules whose duration is less than 6.
SELECT modulecode, duration FROM modules WHERE modules.duration < 6;

-- 2.Write a query which will display the BATCHCODE, TRAINERID, COURSECODE, STARTDATE, CAPACITY 
-- and BATCHSTRENGTH of the batches handled by the trainer KRISHNAN.
SELECT batchcode, batches.trainerid, coursecode, startdate, capacity, batchstrength FROM batches 
INNER JOIN trainers ON batches.trainerid = trainers.trainerid WHERE trainers.trainername = 'KRISHNAN';

-- 3.Write a query which displays all the module names of the course code 100.
SELECT modulename FROM modules INNER JOIN courseandmodules
ON modules.modulecode = courseandmodules.modulecode
INNER JOIN courses ON courseandmodules.coursecode = courses.coursecode
WHERE courses.coursecode = 100;

-- 4.Write a query which displays the module names and course code for the course code 100.
SELECT modules.modulename, courses.coursecode FROM modules INNER JOIN courseandmodules
ON modules.modulecode = courseandmodules.modulecode
INNER JOIN courses ON courseandmodules.coursecode = courses.coursecode
WHERE courses.coursecode = 100;

-- 5."Write a query which will display the number of modules present in the course code 100. 
-- <br/>
-- Hint: display module name count with alias""NumberofModules"""
SELECT COUNT(modulename) NumberofModules FROM modules INNER JOIN courseandmodules
ON modules.modulecode = courseandmodules.modulecode
INNER JOIN courses ON courseandmodules.coursecode = courses.coursecode
WHERE courses.coursecode = 100;

-- 6."Write a query which will display all the course code and the number of modules present 
-- in that particular course.
-- Hint: display module name count with alias""NumberofModules"""
SELECT courses.coursecode, COUNT(modulename) NumberofModules FROM modules INNER JOIN courseandmodules
ON modules.modulecode = courseandmodules.modulecode
INNER JOIN courses ON courseandmodules.coursecode = courses.coursecode
GROUP BY courses.coursecode;

-- 7.Write a query which will display the course title and fees which has the maximum fees.
SELECT title, fees FROM courses WHERE fees = (SELECT MAX(fees) FROM courses);

-- 8.Write a query which will display the student id, student name, batch code, place and 
-- phone number of the students who belongs to Batch '3001'.
SELECT studentid, studentname, batches.batchcode, place, phone
FROM batches INNER JOIN students ON batches.batchcode = students.batchcode
WHERE batches.batchcode = 3001;

-- 9.Write a Query which will display the student ID, Student name, Batch code, place and phone number who are from CHENNAI.
SELECT studentid, studentname, batchcode, place, phone
FROM students WHERE place = 'CHENNAI';

-- 10.Write a query which displays the total number of modules which has less than 6 days duration. 
-- <BR>Hint: display total number of modules with'LESSTHANSIXDAYS' as alias.
SELECT COUNT(modulecode) LESSTHANSIXDAYS
FROM modules WHERE duration < 6;

-- 11.Write a query to display the batch code, course title, start date of the batches for the month of May and year 2012.
SELECT batchcode, title, startdate
FROM courses INNER JOIN batches ON courses.coursecode = batches.coursecode
WHERE date_part('month', startdate) = 5 AND date_part('year', startdate) = 2012;

-- 12.Write a query to display courses code, course title, course fees of the courses for which 
-- no batches/training has been planned in the month of January and year 2012.
SELECT courses.coursecode, title, fees
FROM courses INNER JOIN batches
ON courses.coursecode = batches.coursecode
WHERE date_part('month', startdate) != 1 AND date_part('year', startdate) != 2012;

-- 13.Write a query which displays the names of all the modules of the course titled 'Oracle DBA'
SELECT modulename FROM modules INNER JOIN courseandmodules
ON modules.modulecode = courseandmodules.modulecode
INNER JOIN courses ON courseandmodules.coursecode = courses.coursecode
WHERE courses.title = 'Oracle DBA';

-- 14.Write a Query which displays the student ID, Student name, Batch code, place and phone number 
-- of the student's who took training from CHENNAI in the year 2012.
SELECT studentid, studentname, batches.batchcode, place, phone
FROM batches INNER JOIN students
ON batches.batchcode = students.batchcode
WHERE place = 'CHENNAI' AND date_part('year', startdate) = 2012;

-- 15.Write a query which will display the student id, student names who are enrolled for the course code 200?
SELECT studentid, studentname
FROM students INNER JOIN batches
ON students.batchcode = batches.batchcode
INNER JOIN courses
ON courses.coursecode = batches.coursecode
WHERE courses.coursecode = 200;