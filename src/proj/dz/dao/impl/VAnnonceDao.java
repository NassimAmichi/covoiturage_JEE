package proj.dz.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import proj.dz.dao.AbstractDao;
import proj.dz.dao.VAnnonceDaoLocal;
import proj.dz.model.VAnnonce;

@Stateless
public class VAnnonceDao extends AbstractDao<VAnnonce, Integer> implements VAnnonceDaoLocal
{

	public VAnnonceDao() 
	{
		super(VAnnonce.class);
	}

	@Override
	public List<VAnnonce> findByWilayasDate(int w_d, int w_a, Date date_d, Date date_f) 
	{
		TypedQuery<VAnnonce>q=em.createNamedQuery("VAnnonce.findByWilayasDate", getClazz());
		q.setParameter("w_d",w_d);
		q.setParameter("w_a",w_a);
		q.setParameter("date_d",date_d);	
		q.setParameter("date_f",date_f);	
		q.setFirstResult(0);
		q.setMaxResults(50);
		return new ArrayList<>(q.getResultList());
	}
	
	@Override
	public List<VAnnonce> findAllByWilayas(int w_d, int w_a) 
	{
		TypedQuery<VAnnonce>q=em.createNamedQuery("VAnnonce.findAllByWilayas", getClazz());
		q.setParameter("w_d",w_d);
		q.setParameter("w_a",w_a);		
		q.setFirstResult(0);
		q.setMaxResults(50);
		return new ArrayList<>(q.getResultList());
	}
}
