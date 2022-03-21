package com.lt.crs.constant;
/**
 * 
 * @author Group-4
 *
 */

public class SQLQueriesConstants {
	public static final String DELETE_COURSE_QUERY = "delete from course where course_code = ?";
	public static final String ADD_COURSE_QUERY = "insert into Course(course_code, course_name, catalog_id, seats) values (?, ?, ?, ?)";
	public static final String VIEW_PENDING_ADMISSION_QUERY = "select user_id, user_name, role, password, student_id, branch, batch, is_approved from student inner join user on student.student_id=user.user_id where is_approved = 0";
	public static final String APPROVE_STUDENT_QUERY = "update Student set is_approved = 1 where student_id = ?";
	public static final String ADD_USER_QUERY = "insert into User(user_id, user_name, password, role) values (?, ?, ?, ?)";
	public static final String ADD_PROFESSOR_QUERY = "insert into Professor(professor_id, department, designation) values (?, ?, ?)";
	public static final String ASSIGN_COURSE_QUERY = "update Course set professor_id = ? where course_code = ?";
	public static final String VIEW_COURSE_QUERY = "select course_code, course_name, professor_id from Course where catalog_id = ?";
	public static final String VIEW_PROFESSOR_QUERY = "select user_id, user_name, role, password, professor_id department, designation from Professor p inner join User u on p.professor_id=u.user_id";
	
	public static final String ADD_STUDENT="insert into student (student_id,branch,batch,is_approved) values (?,?,?,?)";
	public static final String VERIFY_CREDENTIALS="select password from user where user_id = ?";
	public static final String GET_ROLE="select role from user where user_id = ? ";
	public static final String IS_APPROVED="select is_approved from student where student_id = ? ";
	public static final String GET_STUDENT_ID="select student_id from student where student_id = ? ";
	public static final String UPDATE_PASSWORD="update user set password=? where user_id = ? ";
	public static final String GET_PROF_NAME = "select user_name from user where user_id = ?";

	public static final String VIEW_REGISTERED_COURSES=" select * from course inner join registered_course on course.course_code = registered_course.course_code where registered_course.student_id = ?";
	public static final String VIEW_AVAILABLE_COURSES=" select * from course where course_code not in  (select course_code  from registered_course where student_id = ?) and seats > 0";
	public static final String CHECK_COURSE_AVAILABILITY=" select course_code from registered_course where student_id = ? ";
	public static final String DECREMENT_COURSE_SEATS="update course set seats = seats-1 where course_code = ? ";
	public static final String ADD_COURSE="insert into registered_course (student_id,course_code,grade) values ( ? , ?, ? )";
	public static final String DROP_COURSE_QUERY = "delete from registered_course where course_code = ? AND student_id = ?;";
	public static final String INCREMENT_SEAT_QUERY  = "update course set seats = seats + 1 where  course_code = ?;";
	public static final String CALCULATE_FEES  = "select sum(course_fee) from course where course_code in (select course_code from registered_course where student_id = ?);";
	public static final String VIEW_GRADE = "select course.course_code,course.course_name,registered_course.grade from course inner join registered_course on course.course_code = registered_course.course_code where registered_course.student_id = ?;";	
	public static final String GET_SEATS = "select seats from course where course_code = ?;";
	public static final String INSERT_PAYMENT = "insert into payment(student_id,mode_of_payment,reference_id,amount) values(?,?,?,?);";
	public static final String INSERT_NOTIFICATION = "insert into notification(student_id,type,reference_id) values(?,?,?);";
	public static final String GET_NOTIFICATION = "select * from notification where reference_id = ?;";
	public static final String ADD_GRADE="update registered_course set grade=? where course_code=? and student_id=?";
	public static final String GET_COURSES="select * from course where professor_id=?";
	public static final String GET_REGISTRATION_STATUS=" select isRegistered from student where student_id = ? ";
	public static final String SET_REGISTRATION_STATUS="update student set isRegistered = true  where student_id=?";
	public static final String GET_ENROLLED_STUDENTS="select course.course_code,course.course_name,registered_course.student_id from course inner join registered_course on course.course_code = registered_course.course_code where course.professor_id = ? order by course.course_code";
	public static final String NUMBER_OF_REGISTERED_COURSES=" select student_id from registered_course where student_id = ? ";
	public static final String IS_REGISTERED=" select course_code from registered_course where course_code=? and student_id=? ";
}
