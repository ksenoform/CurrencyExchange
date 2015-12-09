package com.luxoft.cantor.support;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Repository;

@Repository
public class GettingLonelyWalueFromPage {
	@Min(value=0,
		 message="{Warning.ToLess.Value}")
	@Pattern(regexp="^\\d+(\\.(\\d){0,2})?",
			 message="{Warning.Size.Code.Currency}")
    private String hermit;

    public String getHermit() {
        return hermit;
    }

    public void setHermit(String hermit) {
        this.hermit = hermit;
    }
    
}
