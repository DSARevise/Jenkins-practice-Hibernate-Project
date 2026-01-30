package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HiernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;

	static {
		try {
			registry = new StandardServiceRegistryBuilder().configure("hbm.cfg.xml").build();

			Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

			sessionFactory = metadata.getSessionFactoryBuilder().build();

		} catch (Exception e) {
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
