package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Vehicle;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "planEdit")
@ViewScoped
public class PlanEditBean implements Serializable {

	private static final long serialVersionUID = -6392690264935189017L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	private List<Vehicle> vehicles;
	private List<Client> clients;
	private Long clientId;
	private Long vehicleId;
	private Integer feesQuantity;
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

	public String save() {
		try {
			System.out.println("Se va a guardar un nuevo plan...");
			agencyService.createPlan(vehicleId, clientId, feesQuantity, planType);
			return "plan_index";
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo crear el plan."));
		}
		return null;
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

	public Integer getFeesQuantity() {
		return feesQuantity;
	}

	public void setFeesQuantity(Integer feesQuantity) {
		this.feesQuantity = feesQuantity;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

}
