package com.yjy.scm.service;

import com.yjy.scm.entity.Account;

public interface AccountService extends BaseService<Account> {
	//用户登录
	public Account login(Account account);
}
