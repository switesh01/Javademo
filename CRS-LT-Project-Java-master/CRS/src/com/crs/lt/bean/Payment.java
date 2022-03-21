package com.crs.lt.bean;

public class Payment {
private Student studentId;
private int refId;
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

public int getRefId() {
	return refId;
}
public void setRefId(int refId) {
	this.refId = refId;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}

}
