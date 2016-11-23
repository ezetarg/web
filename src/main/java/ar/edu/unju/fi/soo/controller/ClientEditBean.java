package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "clientEdit")
public class ClientEditBean implements Serializable {

	private static final long serialVersionUID = -6693455350411733327L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	@ManagedProperty("#{param['id']}")
	private Long id;

	private Client client;

	@PostConstruct
	public void init() {
		System.out.println("----------------------------------------------------");
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String paramId = params.get("id");
		System.out.println("paramId " + paramId);
		System.out.println("id " + id);
		System.out.println("----------------------------------------------------");
		if (id != null) {
			client = agencyService.getClientById(id);
		} else {
			client = new Client();
		}
	}

	public String save() {
		try {
			agencyService.saveClient(client);
			client = null;
			JsfUtil.addSuccessMessage("Product was successfully created.");
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
