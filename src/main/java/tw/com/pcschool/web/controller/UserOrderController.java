package tw.com.pcschool.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.pcschool.web.model.User;
import tw.com.pcschool.web.model.UserOrder;
import tw.com.pcschool.web.service.UserOrderService;

@Controller
@RequestMapping("/order")
public class UserOrderController {
	@Autowired
	private UserOrderService orderService;
	
	@PostMapping("/add")
	public String addOrder(@RequestParam Long id,HttpServletRequest request) {
		UserOrder order=new UserOrder();
		User user= new User();
		
		user.setId(id);
		order.setId_user(user);
		
		request.setAttribute("order", order);
		request.setAttribute("mode", "MODE_ADDORDER");
		return "welcomepage";
	}
	
	@RequestMapping("/index")
	@ResponseBody
	public String index(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_TEST");
		return "welcomepage";
	}
	
	@PostMapping("/saveorder")
	public String saveOrder(@Valid@ModelAttribute("order") UserOrder order
			,BindingResult bindingResult,HttpServletRequest request) {
		
		
		if (bindingResult.hasErrors()) {
			LogManager.getLogger().error(bindingResult.getAllErrors());
			if (order.getOrderDate()!=null) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date= java.sql.Date.valueOf(sdf.format(order.getOrderDate()));
				order.setOrderDate(date);
			}
			
			request.setAttribute("order", order);
			request.setAttribute("mode", "MODE_ADDORDER");
			return "welcomepage";
		}
		
		orderService.save(order);
		request.setAttribute("orders", orderService.list());
		request.setAttribute("mode", "MODE_LISTORDER");
		return "welcomepage";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam Long id,HttpServletRequest request) {
		request.setAttribute("order", orderService.get(id));
		request.setAttribute("mode", "MODE_UPDATEORDER");
		return "welcomepage";
	}
	
	@PostMapping("/updateorder")
	public String updateOrder(@Valid@ModelAttribute("order") UserOrder order
			,BindingResult bindingResult,HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			if (order.getOrderDate()!=null) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date= java.sql.Date.valueOf(sdf.format(order.getOrderDate()));
				order.setOrderDate(date);
			}
			request.setAttribute("order", order);
			request.setAttribute("mode", "MODE_UPDATEORDER");
			return "welcomepage";
		}
		orderService.update(order);
		request.setAttribute("orders", orderService.list());
		request.setAttribute("mode", "MODE_LISTORDER");
		return "welcomepage";
	}
	
	@PostMapping("/delete")
	public String deleteOrder(@RequestParam Long id,HttpServletRequest request) {
		orderService.delete(id);
		request.setAttribute("orders", orderService.list());
		request.setAttribute("mode", "MODE_LISTORDER");
		return "welcomepage";
	}
	
	@RequestMapping("/list")
	public String listOrder(HttpServletRequest request) {
		request.setAttribute("orders", orderService.list());
		request.setAttribute("mode", "MODE_LISTORDER");
		return "welcomepage";
	}
	
	
	@PostMapping("/queryorder")
	public String queryOrder(@RequestParam Long id,HttpServletRequest request) {
		request.setAttribute("orders", orderService.queryOrderByUserId(id));
		request.setAttribute("mode", "MODE_LISTORDER");
		return "welcomepage";
	}
}
