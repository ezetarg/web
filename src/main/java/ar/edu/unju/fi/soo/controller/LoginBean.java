package ar.edu.unju.fi.soo.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import ar.edu.unju.fi.soo.model.User;
import ar.edu.unju.fi.soo.services.SecurityService;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

	private static final long serialVersionUID = -6648061315190216877L;
	private String nombreUsuario;
	private String password;
	private final String FORWARD_DASHBOARD = "escritorio.xhtml?faces-redirect=true";
	@Inject
	private SecurityService securityService;

	/**
	 * Login del sistema
	 * 
	 * @return
	 * @throws Exception
	 */
	public String ingresar() throws Exception {
		System.out.println("nombreUsuario = " + nombreUsuario);
		System.out.println("password = " + password);

		if (nombreUsuario.isEmpty() || password.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe ingresar usuario y clave."));
			return null;
		}

		User user = securityService.login(nombreUsuario, password);

		if (user != null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El usuario y/o clave no son correctos."));

			return null;
		}
		return FORWARD_DASHBOARD;

	}

	/**
	 * Cerrar sesi�n
	 * 
	 * @return
	 */
	public void closeSession() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();

	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
