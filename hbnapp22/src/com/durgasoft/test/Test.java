package com.durgasoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.entity.EmployeeAccount;
import com.durgasoft.entity.StudentAccount;



public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/com/durgasoft/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = cfg.buildSessionFactory(registry);
			session = sessionFactory.openSession();
			StudentAccount sa = new StudentAccount();
			sa.setAccNo("a111");
			sa.setAccName("AAA");
			sa.setAccType("saving");
			sa.setSid("s-111");
			sa.setSbranch("cs");
			sa.setSmarks(88);
			
			EmployeeAccount ea = new EmployeeAccount();
			ea.setAccNo("a222");
			ea.setAccName("BBB");
			ea.setAccType("saving");
			ea.setEid("E-111");
			ea.setEsal(5000);
			ea.setEaddr("hyd");
			
			tx = session.beginTransaction();
			String pk_val1 = (String) session.save(sa);
			String pk_val2 = (String) session.save(ea);
			
			if(pk_val1.equals("a111") && pk_val2.equals("a222")) {
				tx.commit();
				System.out.println("employee inserted successfully");
			}else {
				tx.rollback();
				System.out.println("employyee not inseryted");
			}
			
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
			}

	}

}
