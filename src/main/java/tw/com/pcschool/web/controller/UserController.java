package tw.com.pcschool.web.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import tw.com.pcschool.web.model.User;
import tw.com.pcschool.web.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("location","features/welcome.jsp");
		return "welcomepage";
	}
	
	@RequestMapping("/adduser")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("location","features/updateuser.jsp");
		
		model.addAttribute("action","saveuser");
		model.addAttribute("title","用戶註冊");
		model.addAttribute("submit","註冊用戶");
		return "welcomepage";
	}
	
	@RequestMapping("/listuser")
	public String welcome(Model model) {
		model.addAttribute("users", userService.query());
		model.addAttribute("location","features/listuser.jsp");
		return "welcomepage";
	}
	
//	@RequestMapping("/register")
//	public String register(Model model) {
//		model.addAttribute("user", new User());
//		model.addAttribute("location","features/listuser.jsp");
//		request.setAttribute("mode", "MODE_REGISTER");
//		return "welcomepage";
//	}
	
	@RequestMapping("/update")
	public String update(@RequestParam Long id,Model model) {
		model.addAttribute("user", userService.get(id));
		model.addAttribute("location","features/updateuser.jsp");
		
		model.addAttribute("action","saveuser");
		model.addAttribute("title","資料修改");
		model.addAttribute("submit","修改資料");
		return "welcomepage";
	}
	
	@PostMapping("/saveuser")
	public String registerUser(@Valid@ModelAttribute("user") User user,
			BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			if (user.getBirthday()!=null) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date= java.sql.Date.valueOf(sdf.format(user.getBirthday()));
				user.setBirthday(date);
			}
			model.addAttribute("user", user);
			model.addAttribute("location","features/updateuser.jsp");
			
			model.addAttribute("action","saveuser");
			model.addAttribute("title","用戶註冊");
			model.addAttribute("submit","註冊用戶");
			return "welcomepage";
		}
		userService.add(user);
		model.addAttribute("users", userService.query());
		model.addAttribute("location","features/listuser.jsp");
		return "welcomepage";
	}
	
	@PostMapping("/updateuser")
	public String updateUser(@Valid@ModelAttribute User user,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			if (user.getBirthday()!=null) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date= java.sql.Date.valueOf(sdf.format(user.getBirthday()));
				user.setBirthday(date);
			}
			model.addAttribute("user", user);
			model.addAttribute("location","features/updateuser.jsp");
			
			model.addAttribute("action","saveuser");
			model.addAttribute("title","資料修改");
			model.addAttribute("submit","修改資料");
			return "welcomepage";
		}
		userService.update(user);
		model.addAttribute("users", userService.query());
		model.addAttribute("location","features/listuser.jsp");
		return "welcomepage";
	}
	
	@PostMapping("/deleteuser")
	public String deleteUser(@RequestParam Long id,@ModelAttribute User user,BindingResult bindingResult,
			Model model)throws SQLIntegrityConstraintViolationException {
		try {
			userService.delete(id);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("deleteid", id);
			model.addAttribute("foreignerror", "該使用者有訂單尚未刪除");
			model.addAttribute("users", userService.query());
			model.addAttribute("mode", "MODE_HOME");
			return "welcomepage";
		}
		model.addAttribute("users", userService.query());
		model.addAttribute("location","features/listuser.jsp");
		return "welcomepage";
	}
	
}
