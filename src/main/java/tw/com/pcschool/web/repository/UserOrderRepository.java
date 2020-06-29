package tw.com.pcschool.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tw.com.pcschool.web.model.UserOrder;

@Repository
public interface UserOrderRepository extends CrudRepository<UserOrder,Long>{

}
