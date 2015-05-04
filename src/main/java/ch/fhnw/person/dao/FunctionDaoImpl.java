package ch.fhnw.person.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import ch.fhnw.person.model.Function;

public class FunctionDaoImpl implements FunctionDao {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Function function) {
		sessionFactory.getCurrentSession().saveOrUpdate(function);
	}

	public Function getFunction(Long id) {
		return (Function) sessionFactory.getCurrentSession().load(
				Function.class, id);
	}

	public List<Function> getFunctions() {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Function");
		return q.list();
	}

	public void delFunction(Function function) {
		sessionFactory.getCurrentSession().delete(function);
	}

	public Function searchFunctionByName(String name) {
		return (Function) sessionFactory.getCurrentSession().createQuery(
				"from Function where name like '%+" + name + "'%'");
	}

}
