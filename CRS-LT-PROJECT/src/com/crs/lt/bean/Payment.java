package com.crs.lt.bean;

public class Payment {
private Student studentId;
private String refId;
private float amount;
private String modeOfPayment;

public String getModeOfPayment() {
	return modeOfPayment;
}
public void setModeOfPayment(String modeOfPayment) {
	this.modeOfPayment = modeOfPayment;
}
public Student getStudentId() {
	return studentId;
}
public void setStudentId(Student studentId) {
	this.studentId = studentId;
}


public String getRefId() {
	return refId;
}
public void setRefId(String refId) {
	this.refId = refId;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}

}
