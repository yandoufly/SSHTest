package com.yjy.scm.dao;

import com.yjy.scm.entity.Account;

public interface AccountMapper extends BaseMapper<Account> {
	public Account login(Account account);
}