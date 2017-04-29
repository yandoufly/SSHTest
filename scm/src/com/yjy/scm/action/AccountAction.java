package com.yjy.scm.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjy.scm.entity.Account;
import com.yjy.scm.entity.Supplier;
import com.yjy.scm.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountAction extends BaseAction {
	@Resource
	private AccountService accountService;
	
	//登录处理
	@RequestMapping(value="/login")
	public String login(Account account, HttpServletRequest request, HttpSession session){
		Account login = accountService.login(account);
		System.out.println("--login.account" + account);
		if(login != null){
			//存session
			session.setAttribute("account", login);
			return "forward:/WEB-INF/main/main.jsp";
		}else{
			request.setAttribute("msg", "用户名或密码错误！");
			return "forward:/login.jsp";
		}
	}
	
	//测试Ajax：@ResponseBody
	@RequestMapping("/doAjax")
	public @ResponseBody Object doAjax(Supplier supplier){
		System.out.println("---doAjax.supplier:"+supplier);
		supplier.setSupName("supName1");
		return supplier;
	}
}
