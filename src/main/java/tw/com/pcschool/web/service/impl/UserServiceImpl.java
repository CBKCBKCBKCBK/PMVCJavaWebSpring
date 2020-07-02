package tw.com.pcschool.web.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.pcschool.web.model.User;
import tw.com.pcschool.web.repository.UserRepository;
import tw.com.pcschool.web.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public void add(User entity) {
		Date date=new Timestamp(System.currentTimeMillis());
		entity.setTimeBuild(date);
		entity.setTimeModify(date);
		userRepository.save(entity);
	}
	
	public User get(Long id) {
		return userRepository.findById(id).get();
	}
	
	public boolean exists(Long id) {
		return userRepository.existsById(id);
	}
	
	public List<User> query() {
		List<User> list=new ArrayList<User>();
		userRepository.findAll().forEach(data->list.add(data));
		return list;
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public void update(User user) {
		user.setTimeBuild(userRepository.findById(user.getId()).get().getTimeBuild());
		user.setTimeModify(new Date(System.currentTimeMillis()));
		userRepository.save(user);
	}	
	
}
