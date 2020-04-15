SELECT modulecode, duration FROM modules WHERE modules.duration < 6;

SELECT batchcode, batches.trainerid, coursecode, startdate, capacity, batchstrength FROM batches 
INNER JOIN trainers ON batches.trainerid = trainers.trainerid WHERE trainers.trainername = 'KRISHNAN';

SELECT modulename FROM modules INNER JOIN courseandmodules
ON modules.modulecode = courseandmodules.modulecode
INNER JOIN courses ON courseandmodules.coursecode = courses.coursecode
WHERE courses.coursecode = 100;

SELECT modules.modulename, courses.coursecode FROM modules INNER JOIN courseandmodules
ON modules.modulecode = courseandmodules.modulecode
INNER JOIN courses ON courseandmodules.coursecode = courses.coursecode
WHERE courses.coursecode = 100;

SELECT COUNT(modulename) NumberofModules FROM modules INNER JOIN courseandmodules
ON modules.modulecode = courseandmodules.modulecode
INNER JOIN courses ON courseandmodules.coursecode = courses.coursecode
WHERE courses.coursecode = 100;

SELECT courses.coursecode, COUNT(modulename) NumberofModules FROM modules INNER JOIN courseandmodules
ON modules.modulecode = courseandmodules.modulecode
INNER JOIN courses ON courseandmodules.coursecode = courses.coursecode
GROUP BY courses.coursecode;

SELECT title, fees FROM courses WHERE fees = (SELECT MAX(fees) FROM courses);

SELECT studentid, studentname, batches.batchcode, place, phone
FROM batches INNER JOIN students ON batches.batchcode = students.batchcode
WHERE batches.batchcode = 3001;

SELECT studentid, studentname, batchcode, place, phone
FROM students WHERE place = 'CHENNAI';

SELECT COUNT(modulecode) LESSTHANSIXDAYS
FROM modules WHERE duration < 6;

SELECT batchcode, title, startdate
FROM courses INNER JOIN batches ON courses.coursecode = batches.coursecode
WHERE date_part('month', startdate) = 5 AND date_part('year', startdate) = 2012;

SELECT courses.coursecode, title, fees
FROM courses INNER JOIN batches
ON courses.coursecode = batches.coursecode
WHERE date_part('month', startdate) != 1 AND date_part('year', startdate) != 2012;

SELECT modulename FROM modules INNER JOIN courseandmodules
ON modules.modulecode = courseandmodules.modulecode
INNER JOIN courses ON courseandmodules.coursecode = courses.coursecode
WHERE courses.title = 'Oracle DBA';

SELECT studentid, studentname, batches.batchcode, place, phone
FROM batches INNER JOIN students
ON batches.batchcode = students.batchcode
WHERE place = 'CHENNAI' AND date_part('year', startdate) = 2012;

SELECT studentid, studentname
FROM students INNER JOIN batches
ON students.batchcode = batches.batchcode
INNER JOIN courses
ON courses.coursecode = batches.coursecode
WHERE courses.coursecode = 200;