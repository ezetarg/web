package ar.edu.unju.fi.soo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.dao.PlanDAO;

@ManagedBean(name = "planSearch")
@ViewScoped
public class PlanSearchBean implements Serializable {

	private static final long serialVersionUID = 3553102837229002620L;

	private List<Plan> plans;

	@ManagedProperty("#{planDAOImpl}")
	private PlanDAO planDAO;

	@PostConstruct
	public void init() {
		plans = planDAO.list();
	}

	public String buscar() {
		return null;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public PlanDAO getPlanDAO() {
		return planDAO;
	}

	public void setPlanDAO(PlanDAO planDAO) {
		this.planDAO = planDAO;
	}
}
