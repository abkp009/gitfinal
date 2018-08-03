package com.security.ldap.ldapsecuritydemo;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LoginController {
	public String login() {
		String username = "euler";
		String password = "password";
		String base = "dc=example,dc=com";
		String dn = "uid=" + username + "," + base;
		String ldapURL = "ldap://ldap.forumsys.com:389";
		// Setup environment for authenticating
		Hashtable<String, String> environment = new Hashtable<String, String>();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL, ldapURL);
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.SECURITY_PRINCIPAL, dn);
		environment.put(Context.SECURITY_CREDENTIALS, password);
		try {
			DirContext authContext = new InitialDirContext(environment);
			System.out.println(authContext);
		} catch (AuthenticationException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		} catch (NamingException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
		return "success";
	}
}
