package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "clientEdit")
public class ClientEditBean implements Serializable {

	private static final long serialVersionUID = -6693455350411733327L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	private Client client = new Client();

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

}
