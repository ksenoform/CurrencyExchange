package com.luxoft.cantor.repository;

import java.math.BigDecimal;

public class Dibs {
    private String dibsCode;
    private String dibsName;
    private BigDecimal dibsRate;
    
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
