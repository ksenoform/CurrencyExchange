package com.luxoft.cantor.repository;

import java.math.BigDecimal;

public class Dibs {
    private String dibsCode;
    private String dibsName;
    private BigDecimal dibsRate;
    
    public static class BuildDibs {
    	private String dibsCode;
        private String dibsName;
        private BigDecimal dibsRate;
        
        public BuildDibs addCode(String dibsCode) {
        	this.dibsCode = dibsCode;
        	return this;
        }
        
        public BuildDibs addName(String dibsName) {
        	this.dibsName = dibsName;
        	return this;
        }
        
        public BuildDibs addRate(String dibsRate) {
        	this.dibsRate = new BigDecimal(dibsRate);
        	return this;
        }
        
        public Dibs build() {
        	return new Dibs(this);
        }
    }
    
    public Dibs() {};
    
    public Dibs (BuildDibs buildDibs) {
    	this.dibsCode = buildDibs.dibsCode;
    	this.dibsName = buildDibs.dibsName;
    	this.dibsRate = buildDibs.dibsRate;
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
    public BigDecimal getDibsRate() {
        return dibsRate;
    }
    public void setDibsRate(BigDecimal dibsRate) {
        this.dibsRate = dibsRate;
    }
    @Override
    public String toString() {
        return "Dibs [dibsCode=" + dibsCode + ", dibsName=" + dibsName + ", dibsRate=" + dibsRate + "]";
    }
    
}
