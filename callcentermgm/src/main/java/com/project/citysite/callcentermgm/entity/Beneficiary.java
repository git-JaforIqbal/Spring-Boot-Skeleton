package com.project.citysite.callcentermgm.entity;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Beneficiary {

    @NotEmpty(message = "Please provide remitter code")
    @Size(min = 12, max = 12, message = "Invalid remitter Id")
    public String remitterCode;

    @NotEmpty(message = "Please provide beneficiary name")
    public String beneficiaryName;

	public String getRemitterCode() {
		return remitterCode;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setRemitterCode(String remitterCode) {
		this.remitterCode = remitterCode;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	@Override
	public String toString() {
		return "Beneficiary [remitterCode=" + remitterCode + ", beneficiaryName=" + beneficiaryName
				+ ", getRemitterCode()=" + getRemitterCode() + ", getBeneficiaryName()=" + getBeneficiaryName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public Beneficiary(
			@NotEmpty(message = "Please provide remitter code") @Size(min = 12, max = 12, message = "Invalid remitter Id") String remitterCode,
			@NotEmpty(message = "Please beneficiary name") String beneficiaryName) {
		super();
		this.remitterCode = remitterCode;
		this.beneficiaryName = beneficiaryName;
	}


}

