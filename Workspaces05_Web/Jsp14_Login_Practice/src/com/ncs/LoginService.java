package com.ncs;

import java.sql.Connection;

public class LoginService {
	
	private LoginDAO dao = new LoginDAO();
	
	public Member selectOneMember(Connection conn, Member m) {
		return dao.selectOneMember(conn, m);
	}
}
