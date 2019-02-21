package co.com.facturacion.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.com.comfaboy.Ldap.LoginLDAP;
import co.com.ges.servicio.AutenticacionServicio;
import co.com.ges.servicio.MenuServicio;



@ManagedBean(name="log")
@SessionScoped
@SuppressWarnings(value = { "all" })
public class LoginControl implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@EJB 
	private MenuServicio servicio;
	
	@EJB
	private AutenticacionServicio autenticacionServicio;

	public static final String AUTH_KEY="app.user.name";
	public static final String USERS="app.user";
	public String cadena="cadena del login control";
	Properties prop;
	private String user;
	private String pass;
	private boolean show=false;
	
	public LoginControl(){
		prop=new Properties();
		try {
			//prop.load(LoginControl.class.getResourceAsStream("ldap2.properties"));
			prop.load(LoginControl.class.getResourceAsStream("mensajes.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String accessCheck(){
		String login=null;
		return login;
	}
	
	public String metodo(){
		System.out.println("llega hasta el metodo------->");
		return "/login/login.faces";
		//return "/pages/empresas.faces";
	}
	
	public void closeDlg(){
		show=false;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isShow() {
		return show;
	}
}
