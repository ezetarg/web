package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ar.edu.unju.fi.soo.model.Vehicle;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "vehicleEdit")
//@ViewScoped
public class VehicleEditBean implements Serializable {

	private static final long serialVersionUID = 1914887930474267752L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	@ManagedProperty("#{param['id']}")
	private Long id;

	private Vehicle vehicle = new Vehicle();

	@PostConstruct
	public void init() {
		System.out.println("----------------------------------------------------");
		System.out.println("id " + id);
		System.out.println("----------------------------------------------------");
		if (id != null) {
			vehicle = agencyService.getVehicleById(id);
		}
	}

	public String save() {
		try {
			agencyService.saveVehicle(vehicle);
			vehicle = null;
			JsfUtil.addSuccessMessage("El vehiculo se ha creado exitosamente.");
		} catch (Exception e) {
			JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
			return null;
		}
		return "vehicle_index";
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
