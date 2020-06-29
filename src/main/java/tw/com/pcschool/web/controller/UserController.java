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
	public String index(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_INDEX");
		return "welcomepage";
	}
	
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		
		request.setAttribute("user", new User());
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam Long id,HttpServletRequest request) {
		request.setAttribute("user", userService.showUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	
	@PostMapping("/saveuser")
	public String registerUser(@Valid@ModelAttribute("user") User user,
			BindingResult bindingResult,
			HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			if (user.getBirthday()!=null) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date= java.sql.Date.valueOf(sdf.format(user.getBirthday()));
				user.setBirthday(date);
			}
			request.setAttribute("user", user);
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		}
		userService.add(user);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@PostMapping("/updateuser")
	public String updateUser(@Valid@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			if (user.getBirthday()!=null) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date= java.sql.Date.valueOf(sdf.format(user.getBirthday()));
				user.setBirthday(date);
			}
			request.setAttribute("user", user);
			request.setAttribute("mode", "MODE_UPDATE");
			return "welcomepage";
		}
		userService.saveMyUser(user);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@PostMapping("/deleteuser")
	public String deleteUser(@RequestParam Long id,@ModelAttribute User user,BindingResult bindingResult,
			HttpServletRequest request)throws SQLIntegrityConstraintViolationException {
		try {
			userService.delete(id);
		} catch (DataIntegrityViolationException e) {
			request.setAttribute("deleteid", id);
			request.setAttribute("foreignerror", "該使用者有訂單尚未刪除");
			request.setAttribute("users", userService.showAllUsers());
			request.setAttribute("mode", "MODE_HOME");
			return "welcomepage";
		}
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
}
