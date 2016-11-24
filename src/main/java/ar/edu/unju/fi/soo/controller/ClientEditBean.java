package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "clientEdit")
//@ViewScoped
public class ClientEditBean implements Serializable {

	private static final long serialVersionUID = -6693455350411733327L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	@ManagedProperty("#{param['id']}")
	private Long id;

	private Client client = new Client();

	@PostConstruct
	public void init() {
		System.out.println("----------------------------------------------------");
		System.out.println("id " + id);
		System.out.println("----------------------------------------------------");
		if (id != null) {
			client = agencyService.getClientById(id);
		}
	}

	public String save() {
		try {
			agencyService.saveClient(client);
			client = null;
			JsfUtil.addSuccessMessage("El cliente se ha creado exitosamente.");
		} catch (Exception e) {
			JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
			return null;
		}
		return "client_index";
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
