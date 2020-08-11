package tw.com.pcschool.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@PostMapping("/queryorder")
	public String queryOrder(@RequestParam Long id,Model model) {
		model.addAttribute("orders", orderService.queryOrderByUserId(id));
		model.addAttribute("location", "features/listuserorder.jsp");
		return "welcomepage";
	}
	
	@RequestMapping("/list")
	public String listOrder(Model model) {
		model.addAttribute("orders", orderService.list());
		model.addAttribute("location", "features/listuserorder.jsp");
		return "welcomepage";
	}
	
	@PostMapping("/add")
	public String addOrder(@RequestParam Long id,Model model) {
		UserOrder order=new UserOrder();
		User user= new User();
		
		user.setId(id);
		order.setId_user(user);
		
		model.addAttribute("order", order);
		model.addAttribute("location", "features/adduserorder.jsp");
		return "welcomepage";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam Long id,Model model) {
		model.addAttribute("order", orderService.get(id));
		model.addAttribute("location", "features/updateuserorder.jsp");
		return "welcomepage";
	}
	
	@PostMapping("/saveorder")
	public String saveOrder(@Valid@ModelAttribute("order") UserOrder order
			,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			if (order.getOrderDate()!=null) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date= java.sql.Date.valueOf(sdf.format(order.getOrderDate()));
				order.setOrderDate(date);
			}
			model.addAttribute("order", order);
			model.addAttribute("location", "features/adduserorder.jsp");
			return "welcomepage";
		}
		orderService.save(order);
		model.addAttribute("orders", orderService.list());
		model.addAttribute("location", "features/listuserorder.jsp");
		return "welcomepage";
	}
	
	@PostMapping("/updateorder")
	public String updateOrder(@Valid@ModelAttribute("order") UserOrder order
			,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			if (order.getOrderDate()!=null) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date= java.sql.Date.valueOf(sdf.format(order.getOrderDate()));
				order.setOrderDate(date);
			}
			model.addAttribute("order", order);
			model.addAttribute("location", "features/updateuserorder.jsp");
			return "welcomepage";
		}
		orderService.update(order);
		model.addAttribute("orders", orderService.list());
		model.addAttribute("location", "features/listuserorder.jsp");
		return "welcomepage";
	}
	
	@PostMapping("/delete")
	public String deleteOrder(@RequestParam Long id,Model model) {
		orderService.delete(id);
		model.addAttribute("orders", orderService.list());
		model.addAttribute("location", "features/listuserorder.jsp");
		return "welcomepage";
	}
	
}
