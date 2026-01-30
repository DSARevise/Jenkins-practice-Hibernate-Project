package com.hibernate.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DepartmentList")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;
	private String departmentName;
	private String departmentInCharge;

	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Employees> employees = new ArrayList<>();

	public void addEmployee(Employees emp) {
		employees.add(emp);
		emp.setDepartment(this);
	}

	public void removeEmployee(Employees emp) {
		employees.remove(emp);
		emp.setDepartment(null);
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentInCharge() {
		return departmentInCharge;
	}

	public void setDepartmentInCharge(String departmentInCharge) {
		this.departmentInCharge = departmentInCharge;
	}

	public List<Employees> getEmployee() {
		return employees;
	}

	public void setEmployee(List<Employees> employee) {
		this.employees = employee;
	}

	public Department(int departmentId, String departmentName, String departmentInCharge, List<Employees> employee) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentInCharge = departmentInCharge;
		this.employees = employee;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentInCharge=" + departmentInCharge + ", employee=" + employees + "]";
	}

}
