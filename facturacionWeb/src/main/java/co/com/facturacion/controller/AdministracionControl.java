package co.com.facturacion.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;

public class AdministracionControl implements Serializable{

	private static final long serialVersionUID = 1L;
	
//	private List<Pai> listPais = new ArrayList<Pai>();
//	private Properties prop = new Properties();
//	private String user;
//	private boolean permisosCreate = false;
//	private Pai paisNew = new Pai();
//	private int num = 0;
//	private String nombre;
//	private int codC=0;
//	private String nomCiud;
//	private int codEsta=0;
//	private List<Estado> listEstado = new ArrayList<Estado>();
//	private Funcionario f = new Funcionario();
//	private List<Ciudad> ciud = new ArrayList<Ciudad>();
//	private DataTable dtActu;
//	private DataTable dtActuE;
//	private DataTable dtActuZ;
//	private DataTable dtActuAn;
//	private DataTable dtActuPr;
//	private DataTable dtActuPm;
//	private DataTable dtActuPf;
//	private DataTable dtActuEstC;
//	private DataTable dtActuTi;
//	private DataTable dtActuFe;
//	private DataTable dtActuEfc;
//	private List<Ciudad> contFilter;
//	private Estado estado = new Estado();
//	private int codEst=0;
//	private List<Estado> estFilter;
//	private Zip zip = new Zip();
//	private int zipCod = 0;
//	private List<Zip> lisZip = new ArrayList<Zip>();
//	private List<Zip> zipFilter;
//	private int codAnio = 0;
//	private Anio an = new Anio();
//	private List<Anio> lisAnio = new ArrayList<Anio>();
//	private List<Anio> anioFilter;
//	private int codPreg = 0;
//	private Pregunta pr = new Pregunta();
//	private List<Pregunta> lisPreg = new ArrayList<Pregunta>();
//	private List<Pregunta> preFilter;
//	private int codParam = 0;
//	private Parametro param = new Parametro();
//	private List<Parametro> lisParam = new ArrayList<Parametro>();
//	private List<Parametro> paramFilter;
//	private int codPerf = 0;
//	private Perfil perf = new Perfil();
//	private List<Perfil> lisPerf = new ArrayList<Perfil>();
//	private List<Perfil> perfFilter;
//	private int codEstCiv = 0;
//	private Estadocivil ec = new Estadocivil();
//	private List<Estadocivil> lisEstCi = new ArrayList<Estadocivil>();
//	private List<Estadocivil> estCiFilter;
//	private int codTi = 0;
//	private Tipoidentificacion ti = new Tipoidentificacion();
//	private List<Tipoidentificacion> lisTi = new ArrayList<Tipoidentificacion>();
//	private List<Tipoidentificacion> tiFilter;
//	private int codFe = 0;
//	private Formaenvio fe = new Formaenvio();
//	private List<Formaenvio> lisFe = new ArrayList<Formaenvio>();
//	private List<Formaenvio> feFilter;
//	private int codEfc = 0;
//	private Estadofactura efc = new Estadofactura();
//	private List<Estadofactura> lisefc = new ArrayList<Estadofactura>();
//	private List<Estadofactura> efcFilter;
//	
//	
//	@EJB
//	GesServicio servicio;
//	
//	public AdministracionControl() {
//		super();
//		this.cargarPropiedades();
//	}
//	
//	public void cargarPropiedades(){
//		prop = new Properties();
//		try{
//			prop.load(AdministracionControl.class.getResourceAsStream("mensajes.properties"));
//			user=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(LoginControl.AUTH_KEY);
//			f =(Funcionario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(LoginControl.USERS);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@PostConstruct
//	public void cargarPermisos(){
//		@SuppressWarnings("unchecked")
//		List<OpcionesMenuUsuario> opc = (List<OpcionesMenuUsuario>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("menu");
//		try{
//			dtActu = new DataTable();
//			dtActuE = new DataTable();
//			dtActuZ = new DataTable();
//			dtActuAn = new DataTable();
//			dtActuPr = new DataTable();
//			dtActuPm = new DataTable();
//			dtActuPf = new DataTable();
//			dtActuEstC = new DataTable();
//			dtActuTi = new DataTable();
//			dtActuFe = new DataTable();
//			dtActuEfc = new DataTable();
//			cargarDatos();
////			for(OpcionesMenuUsuario o: opc){
////				if((o.getIdMenu().compareTo(ComponentesMenu.CONTRATO.getIdComponente())==0) 
////						&& (o.getPermisoCodigo().compareTo(PermisosMenu.ADMCONTRATRO.getIdPermiso().intValue())==0)){
////					if((o.getIdMenu().compareTo(ComponentesMenu.CONTRATO.getIdComponente())==0) 
////						&& (o.getPermisoCodigo().compareTo(PermisosMenu.SUMINISTROS.getIdPermiso().intValue())==0)){
////						
////					}
////				}
////			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void cargarDatos(){
//		try{
//			dtActu = new DataTable();
//			dtActuE = new DataTable();
//			dtActuZ = new DataTable();
//			dtActuAn = new DataTable();
//			dtActuPr = new DataTable();
//			dtActuPm = new DataTable();
//			dtActuPf = new DataTable();
//			dtActuEstC = new DataTable();
//			dtActuTi = new DataTable();
//			dtActuFe = new DataTable();
//			dtActuEfc = new DataTable();
//			contFilter = new ArrayList<Ciudad>();
//			listPais = servicio.listarPais();
//			num = servicio.maxId();
//			listEstado = servicio.traerEstado();
//			codC = servicio.maxCodCiu();
//			ciud = servicio.listarCiudad();
//			dtActu.setValue(ciud);
//			dtActuE.setValue(listEstado);
//			contFilter = ciud;
//			codEst = servicio.maxCodEst();
//			estFilter = listEstado;
//			zipCod = servicio.maxCodZip();
//			lisZip = servicio.listarZip();
//			dtActuZ.setValue(lisZip);
//			codAnio = servicio.maxCodAnio();
//			lisAnio = servicio.listarAnio();
//			anioFilter = lisAnio;
//			dtActuAn.setValue(lisAnio);
//			codPreg = servicio.maxCodPreg();
//			lisPreg = servicio.listarPregunta();
//			preFilter  =lisPreg;
//			dtActuPr.setValue(lisPreg);
//			codParam = servicio.maxCodParam();
//			lisParam = servicio.listarParametros();
//			paramFilter = lisParam;
//			dtActuPm.setValue(lisParam);
//			codPerf = servicio.maxCodPerf();
//			lisPerf = servicio.listarPerfil();
//			perfFilter = lisPerf;
//			dtActuPf.setValue(lisPerf);
//			codEstCiv = servicio.maxCodEstadoCivil();
//			lisEstCi = servicio.listarEstadoCivil();
//			estCiFilter = lisEstCi;
//			dtActuEstC.setValue(lisEstCi);
//			codTi = servicio.maxCodTipoIdentifiacion();
//			lisTi = servicio.listarTipoIdentifiacion();
//			tiFilter = lisTi;
//			dtActuTi.setValue(lisTi);
//			codFe = servicio.maxCodFormaEnvio();
//			lisFe = servicio.listarFormaEnvio();
//			feFilter = lisFe;
//			dtActuFe.setValue(lisFe);
//			codEfc = servicio.maxCodEstadoFactura();
//			lisefc = servicio.listarEstadoFactura();
//			efcFilter = lisefc;
//			dtActuEfc.setValue(lisefc);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public void edit(Pai p) {
//		try{
//			if(p!=null){
//				servicio.editarPais(p);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditPais")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEditarPais")));
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEditarPais")));
//		}
//    }
//	
//	public void limpiarDatos(){
//		nombre = null;
//		nomCiud = null;
//		codEsta = 0;
//		estado = new Estado();
//		zip = new Zip();
//		an = new Anio();
//		param = new Parametro();
//		perf = new Perfil();
//		ec = new Estadocivil();
//		ti = new Tipoidentificacion();
//		fe = new Formaenvio();
//		efc = new Estadofactura();
//		cargarDatos();
//	}
//	
//	public void active(){
//		permisosCreate = true;
//	}
//	
//	public void cerrar(){
//		permisosCreate = false;
//	}
//	
//    public void create() {
//    	try{
//    		if(nombre!=null && !nombre.equals("")){
//    			paisNew.setId(num);
//    			paisNew.setNombre(nombre);
//    			servicio.crearPais(paisNew);
//    			limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditPais")));
//    		}else{
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",prop.getProperty("errorCamposObli")));
//    		}
//    	}catch(Exception e){
//    		e.printStackTrace();
//    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCreaPais")));
//    	}
//    }
//    
//    public void crearCiudad(){
//    	try{
//    		if((nomCiud!=null && !nomCiud.equals("")) && codEsta>0){
//    			Ciudad c  = new Ciudad();
//    			c.setId(codC);
//    			c.setFecha(new Date());
//    			c.setNombre(nomCiud);
//    			c.setIdestado(codEsta);
//    			c.setIdfuncionario(user);
//    			c.setIdtipofuncionario(f.getIdperfil());
//    			servicio.crearCiudad(c);
//    			limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoGuardadoCiu")));
//    		}
//    	}catch(Exception e){
//    		e.printStackTrace();
//    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCreaCiudad")));
//    	}
//    }
//    
//    public void editCiudad(Ciudad p) {
//		try{
//			if(p!=null){
//				p.setIdfuncionario(user);
//				p.setFecha(new Date());
//				p.setIdtipofuncionario(f.getIdperfil());
//				servicio.editarCiudad(p);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditCiudad")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEditarCiu")));
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEditarPais")));
//		}
//    }
//    
//    public void crearEstado(){
//    	try{
//    		if((estado.getNombre()!=null && !estado.getNombre().equals("")) && (estado.getIdpais()>0)){
//    			estado.setId(codEst);
//    			servicio.crearEstado(estado);
//    			limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditCiudad")));
//    		}else{
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//    		}
//    	}catch(Exception e){
//    		e.printStackTrace();
//    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEstado")));
//    	}
//    }
//    
//    public void editEstado(Estado es) {
//		try{
//			if(es!=null){
//				servicio.editarEstado(es);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditEst")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEditarEst")));
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEditarEst")));
//		}
//    }
//    
//    public void crearZip(){
//    	try{
//    		if(zip.getZipcode()!=null && !zip.getZipcode().equals("")){
//    			zip.setId(zipCod);
//    			zip.setIdfuncionario(user);
//    			zip.setFecha(new Date());
//    			zip.setIdtipofuncionario(f.getIdperfil());
//    			servicio.crearZip(zip);
//    			limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoGuarZip")));
//    		}else{
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//    		}
//    	}catch(Exception e){
//    		e.printStackTrace();
//    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("erroCreaZip")));
//    	}
//    }
//    
//    public void editarZip(Zip z){
//    	try{
//    		if(z!=null){
//    			z.setFecha(new Date());
//    			z.setIdfuncionario(user);
//    			z.setIdtipofuncionario(f.getIdperfil());
//    			servicio.editZip(z);
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditZip")));
//    		}else{
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//    		}
//    	}catch(Exception e){
//    		e.printStackTrace();
//    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorEdiZip")));
//    	}
//    }
//    
//    public void crearAnio(){
//		try{
//			if(an.getNombre()>0){
//				an.setId(codAnio);
//				servicio.crearAnio(an);
//				limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoGuaAn")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCreAn")));
//		}
//	}
//	
//	public void editarAnio(Anio a){
//		try{
//			if(a.getNombre()>0){
//				servicio.editarAnio(a);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditAn")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("erroEdiAn")));
//		}
//	}
//	
//	 public void crearPregunta(){
//			try{
//				if(pr.getPregunta()!=null && !pr.getPregunta().equals("")){
//					pr.setId(codPreg);
//					servicio.crearPregunta(pr);
//					limpiarDatos();
//	    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoGuaPR")));
//				}else{
//					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",prop.getProperty("errorCamposObli")));
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCrePR")));
//			}
//		}
//		
//		public void editarPregunta(Pregunta p){
//			try{
//				if(p.getPregunta()!=null && !p.getPregunta().equals("")){
//					servicio.editarPregunta(p);
//					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditPR")));
//				}else{
//					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("erroEdiPR")));
//			}
//		}
//		
//	public void crearParam(){
//		try{
//			if(param.getEstado()>0 && (param.getDireccion()!=null && !param.getDireccion().equals(""))
//					&& param.getIdciudadpobox()>0 && param.getIdzippobox()>0){
//				param.setId(codParam);
//				servicio.crearParamero(param);
//				limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoGuaPar")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCrePar")));
//		}
//	}
//	
//	public void editarParam(Parametro p){
//		try{
//			if(p.getEstado()>0 || (p.getDireccion()!=null && !p.getDireccion().equals(""))
//					|| p.getIdciudadpobox()>0 || p.getIdzippobox()>0){
//				servicio.editarParametro(p);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditPar")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("erroEdiPar")));
//		}
//	}
//
//	public void crearPerfil(){
//		try{
//			if((perf.getDescripcion()!=null && !perf.getDescripcion().equals("")) 
//					&& (perf.getNombre()!=null && !perf.getNombre().equals(""))){
//				perf.setId(codPerf);
//				servicio.crearPerfil(perf);
//				limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoGuaPf")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCrePF")));
//		}
//	}
//	
//	public void editarPerfil(Perfil p){
//		try{
//			if((p.getDescripcion()!=null && !p.getDescripcion().equals("")) 
//					|| (p.getNombre()!=null && !p.getNombre().equals(""))){
//				servicio.editarPerfil(p);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoGuaEstCiv")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCreEstCiv")));
//		}
//	}
//	
//	public void crearEstadoCivil(){
//		try{
//			if(ec.getNombre()!=null && !ec.getNombre().equals("")){
//				ec.setId(codEstCiv);
//				servicio.crearEstadoCivil(ec);
//				limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditEstCiv")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCreEstCiv")));
//		}
//	}
//	
//	public void editarEstadoCivil(Estadocivil esc){
//		try{
//			if((esc.getNombre()!=null && !esc.getNombre().equals(""))){
//				servicio.editarEstadoCivil(esc);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("errorCreEstCiv")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("erroEdiEstCiv")));
//		}
//	}
//	
//	public void crearTipoIden(){
//		try{
//			if(ti.getNombre()!=null && !ti.getNombre().equals("")){
//				ti.setId(codTi);
//				servicio.crearTipoIdentifiacion(ti);
//				limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoGuaTI")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCreTi")));
//		}
//	}
//	
//	public void editarTipoIden(Tipoidentificacion tid){
//		try{
//			if((tid.getNombre()!=null && !tid.getNombre().equals(""))){
//				servicio.editarTipoIdentifiacion(tid);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditTI")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("erroEdiTi")));
//		}
//	}
//	
//	public void crearFormaEnvio(){
//		try{
//			if(fe.getNombre()!=null && !fe.getNombre().equals("")){
//				fe.setId(codFe);
//				servicio.crearFormaEnvio(fe);
//				limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoGuaFe")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCrefe")));
//		}
//	}
//	
//	public void editarFormaEnvio(Formaenvio foen){
//		try{
//			if((foen.getNombre()!=null && !foen.getNombre().equals(""))){
//				servicio.editarFormaEnvio(foen);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEditFe")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("erroEdife")));
//		}
//	}
//	
//	public void crearEstadoFacrura(){
//		try{
//			if(efc.getNombre()!=null && !efc.getNombre().equals("")){
//				efc.setId(codEfc);
//				servicio.crearEstadoFactura(efc);
//				limpiarDatos();
//    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoGuaEf")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCreEf")));
//		}
//	}
//	
//	public void editarEstadoFacrura(Estadofactura esf){
//		try{
//			if((esf.getNombre()!=null && !esf.getNombre().equals(""))){
//				servicio.editarEstadoFactura(esf);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",prop.getProperty("exitoEdiEFe")));
//			}else{
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("errorCamposObli")));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("erroEdiEf")));
//		}
//	}
//	
//	public void setListPais(List<Pai> listPais) {
//		this.listPais = listPais;
//	}
//
//	public boolean isPermisosCreate() {
//		return permisosCreate;
//	}
//
//	public void setPermisosCreate(boolean permisosCreate) {
//		this.permisosCreate = permisosCreate;
//	}
//
//	public Pai getPaisNew() {
//		return paisNew;
//	}
//
//	public void setPaisNew(Pai paisNew) {
//		this.paisNew = paisNew;
//	}
//
//	public int getNum() {
//		return num;
//	}
//
//	public void setNum(int num) {
//		this.num = num;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public int getCodC() {
//		return codC;
//	}
//
//	public void setCodC(int codC) {
//		this.codC = codC;
//	}
//
//	public String getNomCiud() {
//		return nomCiud;
//	}
//
//	public void setNomCiud(String nomCiud) {
//		this.nomCiud = nomCiud;
//	}
//
//	public List<Estado> getListEstado() {
//		return listEstado;
//	}
//
//	public void setListEstado(List<Estado> listEstado) {
//		this.listEstado = listEstado;
//	}
//
//	public int getCodEsta() {
//		return codEsta;
//	}
//
//	public void setCodEsta(int codEsta) {
//		this.codEsta = codEsta;
//	}
//
//	public List<Ciudad> getCiud() {
//		return ciud;
//	}
//
//	public void setCiud(List<Ciudad> ciud) {
//		this.ciud = ciud;
//	}
//	
//	public DataTable getDtActu() {
//		return dtActu;
//	}
//
//	public void setDtActu(DataTable dtActu) {
//		this.dtActu = dtActu;
//	}
//	
//	public List<Ciudad> getContFilter() {
//		return contFilter;
//	}
//
//	public void setContFilter(List<Ciudad> contFilter) {
//		this.contFilter = contFilter;
//	}
//
//	public Estado getEstado() {
//		return estado;
//	}
//
//	public void setEstado(Estado estado) {
//		this.estado = estado;
//	}
//
//	public int getCodEst() {
//		return codEst;
//	}
//
//	public void setCodEst(int codEst) {
//		this.codEst = codEst;
//	}
//
//	public List<Estado> getEstFilter() {
//		return estFilter;
//	}
//
//	public void setEstFilter(List<Estado> estFilter) {
//		this.estFilter = estFilter;
//	}
//
//	public DataTable getDtActuE() {
//		return dtActuE;
//	}
//
//	public void setDtActuE(DataTable dtActuE) {
//		this.dtActuE = dtActuE;
//	}
//
//	public DataTable getDtActuZ() {
//		return dtActuZ;
//	}
//
//	public void setDtActuZ(DataTable dtActuZ) {
//		this.dtActuZ = dtActuZ;
//	}
//
//	public Zip getZip() {
//		return zip;
//	}
//
//	public void setZip(Zip zip) {
//		this.zip = zip;
//	}
//
//	public int getZipCod() {
//		return zipCod;
//	}
//
//	public void setZipCod(int zipCod) {
//		this.zipCod = zipCod;
//	}
//
//	public List<Zip> getLisZip() {
//		return lisZip;
//	}
//
//	public void setLisZip(List<Zip> lisZip) {
//		this.lisZip = lisZip;
//	}
//
//	public List<Zip> getZipFilter() {
//		return zipFilter;
//	}
//
//	public void setZipFilter(List<Zip> zipFilter) {
//		this.zipFilter = zipFilter;
//	}
//
//	public DataTable getDtActuAn() {
//		return dtActuAn;
//	}
//
//	public void setDtActuAn(DataTable dtActuAn) {
//		this.dtActuAn = dtActuAn;
//	}
//
//	public int getCodAnio() {
//		return codAnio;
//	}
//
//	public void setCodAnio(int codAnio) {
//		this.codAnio = codAnio;
//	}
//
//	public Anio getAn() {
//		return an;
//	}
//
//	public void setAn(Anio an) {
//		this.an = an;
//	}
//
//	public List<Anio> getLisAnio() {
//		return lisAnio;
//	}
//
//	public void setLisAnio(List<Anio> lisAnio) {
//		this.lisAnio = lisAnio;
//	}
//
//	public List<Anio> getAnioFilter() {
//		return anioFilter;
//	}
//
//	public void setAnioFilter(List<Anio> anioFilter) {
//		this.anioFilter = anioFilter;
//	}
//
//	public DataTable getDtActuPr() {
//		return dtActuPr;
//	}
//
//	public void setDtActuPr(DataTable dtActuPr) {
//		this.dtActuPr = dtActuPr;
//	}
//
//	public int getCodPreg() {
//		return codPreg;
//	}
//
//	public void setCodPreg(int codPreg) {
//		this.codPreg = codPreg;
//	}
//
//	public Pregunta getPr() {
//		return pr;
//	}
//
//	public void setPr(Pregunta pr) {
//		this.pr = pr;
//	}
//
//	public List<Pregunta> getLisPreg() {
//		return lisPreg;
//	}
//
//	public void setLisPreg(List<Pregunta> lisPreg) {
//		this.lisPreg = lisPreg;
//	}
//
//	public List<Pregunta> getPreFilter() {
//		return preFilter;
//	}
//
//	public void setPreFilter(List<Pregunta> preFilter) {
//		this.preFilter = preFilter;
//	}
//
//	public DataTable getDtActuPm() {
//		return dtActuPm;
//	}
//
//	public void setDtActuPm(DataTable dtActuPm) {
//		this.dtActuPm = dtActuPm;
//	}
//
//	public int getCodParam() {
//		return codParam;
//	}
//
//	public void setCodParam(int codParam) {
//		this.codParam = codParam;
//	}
//
//	public Parametro getParam() {
//		return param;
//	}
//
//	public void setParam(Parametro param) {
//		this.param = param;
//	}
//
//	public List<Parametro> getLisParam() {
//		return lisParam;
//	}
//
//	public void setLisParam(List<Parametro> lisParam) {
//		this.lisParam = lisParam;
//	}
//
//	public List<Parametro> getParamFilter() {
//		return paramFilter;
//	}
//
//	public void setParamFilter(List<Parametro> paramFilter) {
//		this.paramFilter = paramFilter;
//	}
//
//	public DataTable getDtActuPf() {
//		return dtActuPf;
//	}
//
//	public void setDtActuPf(DataTable dtActuPf) {
//		this.dtActuPf = dtActuPf;
//	}
//
//	public Perfil getPerf() {
//		return perf;
//	}
//
//	public void setPerf(Perfil perf) {
//		this.perf = perf;
//	}
//
//	public List<Perfil> getLisPerf() {
//		return lisPerf;
//	}
//
//	public void setLisPerf(List<Perfil> lisPerf) {
//		this.lisPerf = lisPerf;
//	}
//
//	public List<Perfil> getPerfFilter() {
//		return perfFilter;
//	}
//
//	public void setPerfFilter(List<Perfil> perfFilter) {
//		this.perfFilter = perfFilter;
//	}
//
//	public int getCodPerf() {
//		return codPerf;
//	}
//
//	public void setCodPerf(int codPerf) {
//		this.codPerf = codPerf;
//	}
//
//	public DataTable getDtActuEstC() {
//		return dtActuEstC;
//	}
//
//	public void setDtActuEstC(DataTable dtActuEstC) {
//		this.dtActuEstC = dtActuEstC;
//	}
//
//	public int getCodEstCiv() {
//		return codEstCiv;
//	}
//
//	public void setCodEstCiv(int codEstCiv) {
//		this.codEstCiv = codEstCiv;
//	}
//
//	public Estadocivil getEc() {
//		return ec;
//	}
//
//	public void setEc(Estadocivil ec) {
//		this.ec = ec;
//	}
//
//	public List<Estadocivil> getLisEstCi() {
//		return lisEstCi;
//	}
//
//	public void setLisEstCi(List<Estadocivil> lisEstCi) {
//		this.lisEstCi = lisEstCi;
//	}
//
//	public List<Estadocivil> getEstCiFilter() {
//		return estCiFilter;
//	}
//
//	public void setEstCiFilter(List<Estadocivil> estCiFilter) {
//		this.estCiFilter = estCiFilter;
//	}
//
//	public DataTable getDtActuTi() {
//		return dtActuTi;
//	}
//
//	public void setDtActuTi(DataTable dtActuTi) {
//		this.dtActuTi = dtActuTi;
//	}
//
//	public int getCodTi() {
//		return codTi;
//	}
//
//	public void setCodTi(int codTi) {
//		this.codTi = codTi;
//	}
//
//	public Tipoidentificacion getTi() {
//		return ti;
//	}
//
//	public void setTi(Tipoidentificacion ti) {
//		this.ti = ti;
//	}
//
//	public List<Tipoidentificacion> getLisTi() {
//		return lisTi;
//	}
//
//	public void setLisTi(List<Tipoidentificacion> lisTi) {
//		this.lisTi = lisTi;
//	}
//
//	public List<Tipoidentificacion> getTiFilter() {
//		return tiFilter;
//	}
//
//	public void setTiFilter(List<Tipoidentificacion> tiFilter) {
//		this.tiFilter = tiFilter;
//	}
//
//	public List<Pai> getListPais() {
//		return listPais;
//	}
//
//	public DataTable getDtActuFe() {
//		return dtActuFe;
//	}
//
//	public void setDtActuFe(DataTable dtActuFe) {
//		this.dtActuFe = dtActuFe;
//	}
//
//	public int getCodFe() {
//		return codFe;
//	}
//
//	public void setCodFe(int codFe) {
//		this.codFe = codFe;
//	}
//
//	public Formaenvio getFe() {
//		return fe;
//	}
//
//	public void setFe(Formaenvio fe) {
//		this.fe = fe;
//	}
//
//	public List<Formaenvio> getLisFe() {
//		return lisFe;
//	}
//
//	public void setLisFe(List<Formaenvio> lisFe) {
//		this.lisFe = lisFe;
//	}
//
//	public List<Formaenvio> getFeFilter() {
//		return feFilter;
//	}
//
//	public void setFeFilter(List<Formaenvio> feFilter) {
//		this.feFilter = feFilter;
//	}
//
//	public DataTable getDtActuEfc() {
//		return dtActuEfc;
//	}
//
//	public void setDtActuEfc(DataTable dtActuEfc) {
//		this.dtActuEfc = dtActuEfc;
//	}
//
//	public int getCodEfc() {
//		return codEfc;
//	}
//
//	public void setCodEfc(int codEfc) {
//		this.codEfc = codEfc;
//	}
//
//	public Estadofactura getEfc() {
//		return efc;
//	}
//
//	public void setEfc(Estadofactura efc) {
//		this.efc = efc;
//	}
//
//	public List<Estadofactura> getLisefc() {
//		return lisefc;
//	}
//
//	public void setLisefc(List<Estadofactura> lisefc) {
//		this.lisefc = lisefc;
//	}
//
//	public List<Estadofactura> getEfcFilter() {
//		return efcFilter;
//	}
//
//	public void setEfcFilter(List<Estadofactura> efcFilter) {
//		this.efcFilter = efcFilter;
//	}

}
