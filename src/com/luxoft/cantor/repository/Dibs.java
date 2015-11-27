package com.luxoft.cantor.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Dibs {
	private String dibsCode;
	private String dibsName;
	private BigDecimal dibsRate;
	private List<DateAndRateOfDibs> dibsRateList;

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

	public Dibs() {
	};

	public Dibs(BuildDibs buildDibs) {
		this.dibsCode = buildDibs.dibsCode;
		this.dibsName = buildDibs.dibsName;
		this.dibsRateList = buildDibs.dibsRateList;
		this.dibsRate = buildDibs.dibsRateList
								 .get(buildDibs.dibsRateList
										 	   .size() - 1)
								 .getDibsRate();
	}

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
	
	public void deleteRateFromList(Date date) {
		DateAndRateOfDibs toRemove = null;
		
		for (DateAndRateOfDibs andRateOfDibs: dibsRateList) {
			if (date.equals(andRateOfDibs.getDibsDate())) {
				toRemove = new DateAndRateOfDibs(andRateOfDibs.getDibsRate());
				toRemove.setDibsDate(date);
			}
		}
		
		if (toRemove != null) {
			dibsRateList.remove(toRemove);
		}
	}

	@Override
	public String toString() {
		return "Dibs [dibsCode=" + dibsCode + ", dibsName=" + dibsName + ", dibsRate=" + getDibsRate() + "]";
	}

}
