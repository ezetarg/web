package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import ar.edu.unju.fi.soo.model.Vehicle;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "vehicleEdit")
public class VehicleEditBean implements Serializable {

	private static final long serialVersionUID = 1914887930474267752L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	@ManagedProperty("#{param['id']}")
	private Long id;

	private Vehicle vehicle;

	@PostConstruct
	public void init() {
		if (vehicle == null) {
			vehicle = (id == null) ? new Vehicle() : agencyService.getVehicleById(id);
		}
	}

	public String save() {
		try {
			vehicle.setId(id);
			agencyService.saveVehicle(vehicle);
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
		System.out.println("setVehicle " + vehicle);
		this.vehicle = vehicle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		System.out.println("this.id " + this.id + " setid " + id);
		this.id = id;
	}

}
