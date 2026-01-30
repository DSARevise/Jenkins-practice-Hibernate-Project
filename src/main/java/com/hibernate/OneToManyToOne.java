
package com.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entities.Department;
import com.hibernate.entities.Employees;

public class OneToManyToOne {

	public static void main(String[] args) {
		SessionFactory factory=HiernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		Department dep=new Department();
		
		
		dep.setDepartmentName("IT Department");
		dep.setDepartmentInCharge("Mr.Darvhekar");
		
		Employees emp=new Employees();
		emp.setEmpName("Rajat Darvhekar");
		emp.setEmpSalary(250000.00);
		
		Employees emp1=new Employees();
		emp1.setEmpName("Kanchan Pandey");
		emp1.setEmpSalary(600000.00);
		
		dep.addEmployee(emp);
		dep.addEmployee(emp1);
		
		session.save(dep);
		System.out.println("Employees Added Successfully");
		tr.commit();
		session.close();

	}

}
