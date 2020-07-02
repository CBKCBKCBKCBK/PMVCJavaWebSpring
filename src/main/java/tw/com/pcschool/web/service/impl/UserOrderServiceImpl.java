package tw.com.pcschool.web.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.pcschool.web.model.User;
import tw.com.pcschool.web.model.UserOrder;
import tw.com.pcschool.web.repository.UserOrderRepository;
import tw.com.pcschool.web.repository.UserRepository;
import tw.com.pcschool.web.service.UserOrderService;

@Service
@Transactional
public class UserOrderServiceImpl implements UserOrderService{
	@Autowired
	private UserOrderRepository orderRepository;
	
	public UserOrderServiceImpl(UserOrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	public void save(UserOrder entity) {
		Date date=new Timestamp(System.currentTimeMillis());
		entity.setTimeBuild(date);
		entity.setTimeModify(date);
		orderRepository.save(entity);
	}
	public void update(UserOrder entity) {
		Date date=new Timestamp(System.currentTimeMillis());
		entity.setTimeBuild(orderRepository.findById(entity.getOrder_id()).get().getTimeBuild());
		entity.setTimeModify(date);
		orderRepository.save(entity);
	}
	public UserOrder get(Long id) {
		return orderRepository.findById(id).get();
	}
	public boolean exists(Long id) {
		return orderRepository.existsById(id);
	}
	public List<UserOrder> queryOrderByUserId(Long id) {
		List<UserOrder> list=new ArrayList<UserOrder>();
		List<UserOrder> query=list();
		for (UserOrder userOrder : query) {
			list.add(userOrder);
		}
		list=list.stream().filter(e->e.getId_user().getId().equals(id))
				.collect(Collectors.toList());
		return list;
	}
	
	public List<UserOrder> list() {
		List<UserOrder> list=new ArrayList<UserOrder>();
		orderRepository.findAll().forEach(data->list.add(data));
		return list;
	}
	public void delete(Long id) {
		orderRepository.deleteById(id);
	}
}
