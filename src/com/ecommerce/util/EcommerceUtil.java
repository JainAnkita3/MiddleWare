package com.ecommerce.util;

import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ecommerce.EcommerceDAO;

public class EcommerceUtil {

	private static Session session;
	private static File cfgFile = new File(
			"/Users/rinkeshshah/Documents/Ankee/workspace/MiddleWare/src/com/ecommerce/hibernate.cfg.xml");
	private static SessionFactory sFactory = buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sFactory;
	}

	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure(cfgFile).buildSessionFactory();

	}

	public static Session createSession() {
		session = sFactory.openSession();
		return session;
	}

	public static void closeSession() {
		session.close();
	}

	public static void main(String[] args) {
		System.out.println("Main");
		EcommerceDAO e = new EcommerceDAO();

	}

}
