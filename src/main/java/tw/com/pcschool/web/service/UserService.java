package tw.com.pcschool.web.service;

import java.util.List;

import tw.com.pcschool.web.model.User;


public interface UserService {
	
	public void add(User entity);
	
	public User get(Long id);
	
	public boolean exists(Long id);
	
	public List<User> query();
	
	public void delete(Long id);
	
	public void update(User user);
}
