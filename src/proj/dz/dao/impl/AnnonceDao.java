package proj.dz.dao.impl;

import javax.ejb.Stateless;

import proj.dz.dao.AbstractDao;
import proj.dz.dao.AnnonceDaoLocal;
import proj.dz.model.Annonce;

@Stateless
public class AnnonceDao extends AbstractDao<Annonce, Integer> implements AnnonceDaoLocal
{
	public AnnonceDao() 
	{
		super(Annonce.class);
	}
}
