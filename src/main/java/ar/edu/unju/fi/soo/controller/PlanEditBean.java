package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Vehicle;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "planEdit")
public class PlanEditBean implements Serializable {

	private static final long serialVersionUID = -6392690264935189017L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	private List<Vehicle> vehicles;
	private List<Client> clients;
	private Vehicle vehicle;
	private Client client;	
	private int feesQuantity;
	private String planType;

	@PostConstruct
	public void init() {
		vehicles = agencyService.listVehicles();
		clients = agencyService.listClients();
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getFeesQuantity() {
		return feesQuantity;
	}

	public void setFeesQuantity(int feesQuantity) {
		this.feesQuantity = feesQuantity;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

}
