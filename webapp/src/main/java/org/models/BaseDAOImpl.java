package org.models;




import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class BaseDAOImpl implements BaseDAO {

	@Override
	public User findUserById(long id) {
		
		return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
	}

	@Override
	public User findUserByLogin(String login) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> c = criteria.from(User.class);
		criteria.select(c);
		criteria.where(builder.equal(c.get("login"), login));
		Query<User> query = session.createQuery(criteria);
		List<User> results = query.getResultList();
		//User result = query.getSingleResult();
		session.close();
		if(!results.isEmpty()) {
			return results.get(0);
		}
		else {
			return null;
		}

	}

	@Override
	public void save(User user) {
		
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
	}

	@Override
	public String findPasswordByLogin(String login) {
		
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();       
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> c = criteria.from(User.class);
		criteria.select(c);		
		criteria.where(builder.equal(c.get("login"), login));
		Query<User> query = session.createQuery(criteria);
		List<User> results = query.getResultList();
		//User result = query.getSingleResult();
        session.close();
        if(!results.isEmpty()) {
        	return results.get(0).getPassword();
        }
        else {
        	return null;
        }
		
	}

	@Override
	public void updatePassword(String login, String password) {
		
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();       
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> c = criteria.from(User.class);
		criteria.select(c);		
		criteria.where(builder.equal(c.get("login"), login));
		Query<User> query = session.createQuery(criteria);
		List<User> results = query.getResultList();
		if(!results.isEmpty()) {
			User user = results.get(0);
	        Transaction tx1 = session.beginTransaction();
	        session.update(user);
	        user.setPassword(password);
	        tx1.commit();
		}
		
        session.close();
	}

	@Override
	public boolean userExists(String login) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();       
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> c = criteria.from(User.class);
		criteria.select(c);		
		criteria.where(builder.equal(c.get("login"), login));
		Query<User> query = session.createQuery(criteria);
		List<User> results = query.getResultList();
		//User result = query.getSingleResult();
        session.close();
        if(results.isEmpty()) {
        	return false;
        }
        else {
        	return true;
        }
		
	}

}
