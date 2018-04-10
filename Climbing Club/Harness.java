public class Harness {
	String make;
	int modelNo;
	int timesUsed;
	String lastInstructorToCheckSafety;
	boolean isOnLoan;
	String memberWithHarness;
	final static int MAX_USES = 25;
	
	public Harness(String make, int modelNo, int timesUsed, String lastInstructorToCheckSafety, 
			boolean isOnLoan, String memberWithHarness) {
		this.make = make;
		this.modelNo = modelNo;
		this.timesUsed = timesUsed;
		this.lastInstructorToCheckSafety = lastInstructorToCheckSafety;
		this.isOnLoan = isOnLoan;
		this.memberWithHarness = memberWithHarness;
	}
	
	public Harness(String make, int modelNo, String lastInstructorToCheckSafety) {
		this.make = make;
		this.modelNo = modelNo;
		timesUsed = 0;
		this.lastInstructorToCheckSafety = lastInstructorToCheckSafety;
		isOnLoan = false;
		memberWithHarness = null;
	}
	
	public void checkHarness(String instructorToCheckSafety) {
		if (!isOnLoan) {
			timesUsed = 0;
			lastInstructorToCheckSafety = instructorToCheckSafety;
		}
	}
	
	public boolean isHarnessOnLoan() {
		return isOnLoan;
	}
	
	public boolean canHarnessBeLoaned() {
		if (isOnLoan || timesUsed >= MAX_USES) {
			return false;
		} else {
			return true;
		}
	}
	
	public void loanHarness(String member) {
		if (canHarnessBeLoaned()) {
			memberWithHarness = member;
			timesUsed++;
			isOnLoan = true;
		}
	}
	
	public void returnHarness() {
		if (isOnLoan) {
			memberWithHarness = null;
			isOnLoan = false;
		}
	}
	
	public String toString() {
		String harnessDescription = "Make: " + make + ", model no.: " + modelNo + ", times used: " + 
									timesUsed + ", last instructor to check safety: " + 
									lastInstructorToCheckSafety + ", loan status: " + isOnLoan + 
									", current member with harness: " + memberWithHarness + ".";
		return harnessDescription;
	}
}