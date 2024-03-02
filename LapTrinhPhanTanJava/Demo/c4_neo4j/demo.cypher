SHOW DATABASES


CREATE CONSTRAINT unique_course_id FOR (course:Course) REQUIRE course.courseID IS UNIQUE;

// Load dữ liệu từ các CSV files

LOAD CSV WITH HEADERS FROM "file:///course/courses.csv" AS row
MERGE (course:Course { courseID: row.course_id })
SET course.name = row.name, course.hours = toInteger(row.hours)
RETURN course

LOAD CSV WITH HEADERS FROM "file:///course/students.csv" AS row
MERGE (student:Student { studentID: row.student_id})
SET student.name = row.name, student.gpa = toFloat(row.gpa)

LOAD CSV WITH HEADERS FROM "file:///courses/department.csv" AS row
MERGE (dept:Department { deptID: row.dept_id})
SET dept.name = row.name, dept.dean = row.dean, dept.building = row.building, dept.room = row.room