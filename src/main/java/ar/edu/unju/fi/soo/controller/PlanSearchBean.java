package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "planSearch")
@ViewScoped
public class PlanSearchBean implements Serializable {

	private static final long serialVersionUID = 3553102837229002620L;

	private List<Plan> plans;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	private String planType;
	private String clientField;

	@PostConstruct
	public void init() {
		plans = agencyService.findPlanByClientName(clientField);
	}
	
	public List<Plan> buscar() {
		plans = agencyService.findPlanByClientDNI(planType, clientField);
		System.out.println(plans);
		return plans;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getClientField() {
		return clientField;
	}

	public void setClientField(String clientField) {
		this.clientField = clientField;
	}

}
