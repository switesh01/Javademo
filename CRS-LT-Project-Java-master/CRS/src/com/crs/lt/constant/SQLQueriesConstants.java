/**
 * 
 */
package com.crs.lt.constant;

/**
 * @author user218
 *
 */
public class SQLQueriesConstants {
	public static final String INSERT_COURSE = "insert into course values(?,?,?,?,?,?)";
	public static final String DELETE_COURSE = "delete  from course where course_code = ?";
	public static final String UPDATE_COURSE = "update  course set course_name = ?, course_fee = ?  where course_code = ?";
	public static final String SELECT_COURSE = "select course_code, course_name, course_fee, catalog_id, course_fee,professor_id from course";
	public static final String VIEW_GRADE = "select course.courseCode,course.courseName,registeredcourse.grade from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where registeredcourse.studentId = ?";	
}
