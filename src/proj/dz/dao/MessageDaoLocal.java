package proj.dz.dao;

import java.util.List;
import javax.ejb.Local;

import proj.dz.model.Message;

@Local
public interface MessageDaoLocal extends Dao<Message,Integer> 
{
	public List<Message> findByText(int t);
}
