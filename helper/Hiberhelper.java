package helper;


import org.hibernate.cfg.*;

import dal.Student;

import org.hibernate.*;
import java.util.*;
public class Hiberhelper {

	static Configuration cfg;
	static SessionFactory sf;
	static Session s;
	public static void configure()
	{
		cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sf= cfg.buildSessionFactory();
		s = sf.openSession();
	}
	public static void insertUpdateRecord(Object c)
	{
		Transaction tx = s.beginTransaction();
		s.save(c);
		tx.commit();
		s.close();
		
	}
	public static void deleteRecord(Object c)
	{
		Transaction tx = s.beginTransaction();
		s.delete(c);
		tx.commit();
		s.close();
		
	}
	public static List selectRecord(String query)
	{
		Query q = s.createQuery(query);
		List lst = q.list(); // query object to list
		return lst;
		
	}
	
	public static Object findRecord(Class c,String id)
	{
		Object o = (Student)s.load(c, Integer.parseInt(id));
		return o;
	}
	public static Query checkLogin(String query)
	{
		Query q = s.createQuery(query);
		return q;
	}
	
}
