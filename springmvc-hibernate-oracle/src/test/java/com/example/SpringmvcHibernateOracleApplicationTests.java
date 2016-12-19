package com.example;

import com.example.bean.Student;
import org.hibernate.*;
import org.hibernate.criterion.Expression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringmvcHibernateOracleApplicationTests {
	Logger logger = LoggerFactory.getLogger(SpringmvcHibernateOracleApplicationTests.class);
	@Test
	public void contextLoads() {
		//query();
		//update();
		insert();
	}

	private void insert() {
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=null;
		tx=session.beginTransaction();
		Student student=new Student();
		student.setName("罗小强");
		student.setStatus("离校");
		student.setAge(45);
		session.save(student);
		Query query=session.createQuery(" from Student order by id desc");
		List list=query.list();
		if(list.size()>0){
			 student=(Student)list.get(0);
			logger.debug("insert {}",student);
		}
		tx.commit();
		sessionFactory.close();
	}

	private void update() {
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=null;
		tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Student.class);
		criteria.add(Expression.eq("id",1));
		List list=criteria.list();
		if(list.size()>0){
			Student student=(Student)list.get(0);
			logger.debug("old {}",student);
			student.setAge(30);
			session.save(student);
			 student=(Student)criteria.list().get(0);
			logger.debug("new {}",student);
		}
		tx.commit();
		sessionFactory.close();
	}

	private void query() {
		Student student=null;
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=null;
		tx=session.beginTransaction();
		Query query=session.createQuery(" from Student ");
		List list=query.list();
		for(Iterator it = list.iterator(); it.hasNext();){
			student=(Student)it.next();
			logger.debug("{}",student);
		}
		tx.commit();
		sessionFactory.close();
	}

}
