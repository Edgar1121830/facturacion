package co.com.ges.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import co.com.ges.dto.OpcionesMenuUsuario;
import co.com.ges.enums.ComponentesMenu;
import co.com.ges.enums.PermisosMenu;
import co.com.ges.modelo.Pai;
import co.com.ges.servicio.GesServicio;

@ManagedBean(name="admin")
@SessionScoped
public class AdministracionControl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Pai> listPais = new ArrayList<Pai>();
	private Properties prop = new Properties();
	private String user;
	private boolean permisosCreate = false;
	private Pai paisNew = new Pai();
	private int num = 0;
	private String nombre;
	
	@EJB
	GesServicio servicio;
	
	public AdministracionControl() {
		super();
		this.cargarPropiedades();
	}
	
	public void cargarPropiedades(){
		prop = new Properties();
		try{
			prop.load(AdministracionControl.class.getResourceAsStream("mensajes.properties"));
			user=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(LoginControl.AUTH_KEY);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void cargarPermisos(){
		@SuppressWarnings("unchecked")
		List<OpcionesMenuUsuario> opc = (List<OpcionesMenuUsuario>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("menu");
		try{
			listPais = servicio.listarPais();
			num = servicio.maxId();
//			for(OpcionesMenuUsuario o: opc){
//				if((o.getIdMenu().compareTo(ComponentesMenu.CONTRATO.getIdComponente())==0) 
//						&& (o.getPermisoCodigo().compareTo(PermisosMenu.ADMCONTRATRO.getIdPermiso().intValue())==0)){
//					if((o.getIdMenu().compareTo(ComponentesMenu.CONTRATO.getIdComponente())==0) 
//						&& (o.getPermisoCodigo().compareTo(PermisosMenu.SUMINISTROS.getIdPermiso().intValue())==0)){
//						
//					}
//				}
//			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edit(Pai p) {
		try{
			if(p!=null){
				servicio.editarPais(p);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditPais")));
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEditarPais")));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEditarPais")));
		}
    }
	
	public void active(){
		permisosCreate = true;
	}
	
	public void cerrar(){
		permisosCreate = false;
	}
	
    public void create() {
    	try{
    		if(nombre!=null && !nombre.equals("")){
    			paisNew.setId(num);
    			paisNew.setNombre(nombre);
    			servicio.crearPais(paisNew);
    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditPais")));
    		}else{
    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("errorCamposObli")));
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEditarPais")));
    	}
    }
	
	public List<Pai> getListPais() {
		return listPais;
	}

	public void setListPais(List<Pai> listPais) {
		this.listPais = listPais;
	}

	public boolean isPermisosCreate() {
		return permisosCreate;
	}

	public void setPermisosCreate(boolean permisosCreate) {
		this.permisosCreate = permisosCreate;
	}

	public Pai getPaisNew() {
		return paisNew;
	}

	public void setPaisNew(Pai paisNew) {
		this.paisNew = paisNew;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
