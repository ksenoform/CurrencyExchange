package com.luxoft.cantor.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RegistedCurrencys")
public class Dibs {
	@Id
	@GeneratedValue
	private Integer id;
	private String dibsCode;
	private String dibsName;
	private BigDecimal dibsRate;
	@ElementCollection
	private List<DateAndRateOfDibs> dibsRateList;

	
	/**************************************************************************
	 *	Begin of builder section for Dibs class
	 **************************************************************************/
	public static class BuildDibs {
		private String dibsCode;
		private String dibsName;
		private List<DateAndRateOfDibs> dibsRateList;

		public BuildDibs addCode(String dibsCode) {
			this.dibsCode = dibsCode;
			return this;
		}

		public BuildDibs addName(String dibsName) {
			this.dibsName = dibsName;
			return this;
		}

		public BuildDibs addRate(String dibsRate) {
			this.dibsRateList = new ArrayList<DateAndRateOfDibs>();
			DateAndRateOfDibs dateAndRate = new DateAndRateOfDibs(dibsRate);
			this.dibsRateList.add(dateAndRate);
			return this;
		}

		public Dibs build() {
			return new Dibs(this);
		}
	}

	public Dibs(BuildDibs buildDibs) {
		this.dibsCode = buildDibs.dibsCode;
		this.dibsName = buildDibs.dibsName;
		this.dibsRateList = buildDibs.dibsRateList;
		this.dibsRate = buildDibs.dibsRateList
								 .get(buildDibs.dibsRateList
										 	   .size() - 1)
								 .getDibsRate();
	}

	/**************************************************************************
	 * 	End builder section
	 **************************************************************************/
	
	public Dibs() {};

	public BigDecimal getDibsRate() {
		return dibsRate;
	}

	public String getDibsCode() {
		return dibsCode;
	}

	public void setDibsCode(String dibsCode) {
		this.dibsCode = dibsCode;
	}

	public String getDibsName() {
		return dibsName;
	}

	public void setDibsName(String dibsName) {
		this.dibsName = dibsName;
	}

	public BigDecimal getOneDibsRateFromList() {
		return getRateAndDateOfLastDibs().getDibsRate();
	}

	public DateAndRateOfDibs getRateAndDateOfLastDibs() {
		return dibsRateList.get(dibsRateList.size() - 1);
	}
	
	public void setDibsRate(BigDecimal dibsRate) {
		if (this.dibsRateList == null) {
			this.dibsRateList = new ArrayList<DateAndRateOfDibs>();
		}

		DateAndRateOfDibs dateAndRate = new DateAndRateOfDibs(dibsRate);
		
		this.dibsRateList.add(dateAndRate);
		this.dibsRate = dibsRate;
	}
	
	public List<DateAndRateOfDibs> getDibsRateList() {
		return dibsRateList;
	}
	
	public void deleteRateFromList(String date) {
		for (int i = dibsRateList.size() - 1; i >= 0; i--) {
			if (date.contains(dibsRateList.get(i).getDibsDate())) {
			    dibsRateList.remove(i);
			}
		}
	}
	
	public void setActiveRate(String valueFromDate) {
	    for (DateAndRateOfDibs ofDibs: getDibsRateList()) {
	        if (valueFromDate.contains(ofDibs.getDibsDate())){
	          this.dibsRate = ofDibs.getDibsRate();  
	        }
	    }
	}

	@Override
	public String toString() {
		return "Dibs [dibsCode=" + dibsCode + ", dibsName=" + dibsName + ", dibsRate=" + getDibsRate() + "]";
	}

}
