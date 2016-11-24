package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.Plan7030;
import ar.edu.unju.fi.soo.model.PlanRegular;
import ar.edu.unju.fi.soo.services.AgencyService;

@ManagedBean(name = "planDetail")
public class PlanDetailBean implements Serializable {

	private static final long serialVersionUID = -6392690264935189017L;

	@ManagedProperty("#{agencyServiceImpl}")
	private AgencyService agencyService;

	@ManagedProperty("#{param['id']}")
	private Long id;

	private Plan plan;
	private int unpaidFees;
	private int paidFees;
	private String planType;

	@PostConstruct
	public void init() {
		System.out.println("----------------------------------------------------");
		System.out.println("id " + id);
		System.out.println("----------------------------------------------------");
		if (id != null) {
			plan = agencyService.getPlanById(id);
		}
	}

	public String payNextFee() {
		agencyService.payNextFee(id != null ? id : plan.getId());
		return "plan_detail";
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public int getUnpaidFees() {
		return unpaidFees;
	}

	public void setUnpaidFees(int unpaidFees) {
		this.unpaidFees = unpaidFees;
	}

	public int getPaidFees() {
		return paidFees;
	}

	public void setPaidFees(int paidFees) {
		this.paidFees = paidFees;
	}

	public String getPlanType() {
		planType = plan instanceof PlanRegular ? "Plan Regular" : plan instanceof Plan7030 ? "Plan 70/30" : "-";
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

}
