package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import ar.edu.unju.fi.soo.model.Vehicle;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "vehicleList")
public class VehicleListBean implements Serializable {

	private static final long serialVersionUID = -6392690264935189017L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	private List<Vehicle> list;

	@PostConstruct
	public void init() {
		list = agencyService.listVehicles();
	}

	public void remove(Vehicle vehicle) {
		// call to delete method in the service
		agencyService.deleteVehicle(vehicle);
		// and reload the list.
		list = agencyService.listVehicles();
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	public List<Vehicle> getList() {
		return list;
	}

	public void setList(List<Vehicle> list) {
		this.list = list;
	}

}
