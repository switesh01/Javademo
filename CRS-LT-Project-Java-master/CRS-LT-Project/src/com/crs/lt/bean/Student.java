/**
 * 
 */
package com.crs.lt.bean;

/**
 * @author user218
 *
 */
public class Student extends User{
	private String branchName;
	private int studentId;
	private int batch;
	private boolean isApproved;
	private GradeCard gradeCard;

	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	public GradeCard getGradeCard() {
		return gradeCard;
	}
	public void setGradeCard(GradeCard gradeCard) {
		this.gradeCard = gradeCard;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + batch;
		result = prime * result
				+ ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result
				+ ((gradeCard == null) ? 0 : gradeCard.hashCode());
		result = prime * result + (isApproved ? 1231 : 1237);
		result = prime * result + studentId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (batch != other.batch)
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (gradeCard == null) {
			if (other.gradeCard != null)
				return false;
		} else if (!gradeCard.equals(other.gradeCard))
			return false;
		if (isApproved != other.isApproved)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [branchName=" + branchName + ", studentId=" + studentId
				+ ", batch=" + batch + ", gradeCard=" + gradeCard + "]";
	}
}
