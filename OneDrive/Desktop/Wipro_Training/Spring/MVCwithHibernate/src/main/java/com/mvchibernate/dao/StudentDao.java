package com.mvchibernate.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mvchibernate.bean.Student;

@Repository
@Transactional
public class StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public int getStudentId() {

		int id = 0;
		Session session = sessionFactory.openSession();
		Query<Student> qry = session.createQuery("select max(studentid) from Student");
		List<Student> I = qry.list();
		System.out.println("L value " + I + ":");
		if (I != null && I.size() > 0) {
			Object b = I.get(0);
			if (b != null)
				id = (Integer) b;
		}
		session.close();
		return id + 10;
	}

	public boolean insertStudent(Student student) {
		hibernateTemplate.persist(student);
		return true;
	}
}