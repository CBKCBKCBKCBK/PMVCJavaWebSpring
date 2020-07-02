package tw.com.pcschool.web.service;

import java.util.List;

import tw.com.pcschool.web.model.UserOrder;

public interface UserOrderService {
	
	public void save(UserOrder entity);
	
	public void update(UserOrder entity);
	
	public UserOrder get(Long id);
	
	public boolean exists(Long id);
	
	public List<UserOrder> queryOrderByUserId(Long id);
	
	public List<UserOrder> list();
	
	public void delete(Long id);
	
}
