package proj.dz.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public abstract class AbstractDao<T,ID> implements Dao<T,ID> 
{
	protected Class<T> clazz;
	
	@PersistenceContext
	protected EntityManager em;
	
	protected EntityManager em2;
	
	public AbstractDao(Class<T> clazz) 
	{
		setClazz(clazz);
	}
	
	public T findById(ID id) 
	{
		return em.find(getClazz(), id);
	}

	public List<T> findAll() 
	{
		TypedQuery<T> query=em.createQuery("SELECT t FROM "+getClazz().getName()+" t", getClazz());
		return new ArrayList<T>(query.getResultList());
	}

	public Class<T> getClazz() 
	{
		return clazz;
	}

	public void setClazz(Class<T> clazz) 
	{
		this.clazz = clazz;
	}

	public void save(T t) 
	{
		em.persist(t);
		//em.merge(t);	
	}
}