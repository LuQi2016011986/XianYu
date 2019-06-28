package service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/** 
 *  配置用户名和密码
 */   
public class SmtpAuthenticator extends Authenticator {
	private String username;
	private String password;

	public SmtpAuthenticator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
