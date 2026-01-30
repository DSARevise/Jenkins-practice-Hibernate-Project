package com.hibernate.entities;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "StudentsList")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private double studentMarks;
	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	@ManyToMany
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Courses> courses = new HashSet<>();

	public void addCourse(Courses cors) {
		courses.add(cors);
		cors.getStudents().add(this);
	}

	public void removeCourse(Courses course) {
		courses.remove(course);
		course.getStudents().remove(this);
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(double studentMarks) {
		this.studentMarks = studentMarks;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(java.util.Date date) {
		this.joiningDate = date;
	}

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	public Student(int studentId, String studentName, double studentMarks, Date joiningDate, Set<Courses> courses) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
		this.joiningDate = joiningDate;
		this.courses = courses;
	}

	public Student(String studentName, double studentMarks, Date joiningDate, Set<Courses> courses) {
		super();
		this.studentName = studentName;
		this.studentMarks = studentMarks;
		this.joiningDate = joiningDate;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMarks=" + studentMarks
				+ ", joiningDate=" + joiningDate + ", courses=" + courses + "]";
	}

}
