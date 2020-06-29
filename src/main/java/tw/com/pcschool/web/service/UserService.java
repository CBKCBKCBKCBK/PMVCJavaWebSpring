package tw.com.pcschool.web.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.pcschool.web.model.User;
import tw.com.pcschool.web.repository.UserRepository;

@Service
@Transactional	//這行會讓JUnit Test無法更新操作
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
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
	public List<User> showAllUsers() {
		List<User> users=new ArrayList<User>();
		for(User user:userRepository.findAll()) {
			users.add(user);
		}
		return users;
	}
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	public void update(User user) {
		userRepository.save(user);
	}
	
	
	public void saveMyUser(User user) {
		user.setTimeBuild(userRepository.findById(user.getId()).get().getTimeBuild());
		user.setTimeModify(new Date(System.currentTimeMillis()));
		userRepository.save(user);
	}
	public User showUser(Long id) {
		User user=userRepository.findById(id).get();
		return user;
	}
	
	public void deleteMyUser(Long id){
		userRepository.deleteById(id);
	}
	
}
