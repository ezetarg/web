package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "clientList")
@ViewScoped
public class ClientListBean implements Serializable {

	private static final long serialVersionUID = 7784570305701107835L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	private List<Client> list;

	@PostConstruct
	public void init() {
		list = agencyService.listClients();
	}
	
	public void edit(Long id) {
		System.out.println("id = " + id);
	}

	public void remove(Client client) {
		// call to delete method in the service
		agencyService.deleteClient(client);
		// and reload the list.
		list = agencyService.listClients();
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	public List<Client> getList() {
		return list;
	}

	public void setList(List<Client> list) {
		this.list = list;
	}

}
