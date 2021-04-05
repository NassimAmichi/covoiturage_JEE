package proj.dz.dao;


import java.sql.Date;
import java.util.List;
import javax.ejb.Local;
import proj.dz.model.VAnnonce;

@Local
public interface VAnnonceDaoLocal extends Dao<VAnnonce, Integer> 
{
	public List<VAnnonce> findByWilayasDate(int w_d, int w_a, Date dat_d, Date dat_f);
	public List<VAnnonce> findAllByWilayas(int w_d, int w_a);
}
