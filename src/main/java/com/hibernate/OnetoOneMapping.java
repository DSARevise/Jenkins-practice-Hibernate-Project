package com.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entities.Profile;
import com.hibernate.entities.User;

public class OnetoOneMapping {
	public static void main(String[] args)
	{
		SessionFactory sessionFactory=HiernateUtil.getSessionFactory();
		
		Session session=sessionFactory.openSession();
		
		Transaction tr=session.beginTransaction();
		
//		Profile profile=new Profile();
//		profile.setProfileName("Rajat512");
//		profile.setProfileContact(969693625);
//		
//		User user=new User();
//		user.setUserName("Rajat");
//		user.setPassword("*****");
//		user.setProfile(profile);
//		
//		Serializable serializable=session.save(user);
//		System.out.println("Data Inserted");
		
		
		
		
		Query<User> query=session.createQuery("select u from User u");
		List<User> list=query.getResultList();
		for(User u:list)
		{
			System.out.println(u);
		}
		
		tr.commit();
		session.close();
	}

}
