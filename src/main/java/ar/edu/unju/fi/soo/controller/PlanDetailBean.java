package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Fee;
import ar.edu.unju.fi.soo.model.Vehicle;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "planDetail")
public class PlanDetailBean implements Serializable {

	private static final long serialVersionUID = -6392690264935189017L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	private Vehicle vehicle;
	private Client client;
	private List<Fee> fees;
	private int feesQuantity;

	@PostConstruct
	public void init() {
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
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

	public List<Fee> getFees() {
		return fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public int getFeesQuantity() {
		return feesQuantity;
	}

	public void setFeesQuantity(int feesQuantity) {
		this.feesQuantity = feesQuantity;
	}

}
