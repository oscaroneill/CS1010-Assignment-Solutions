import java.util.ArrayList;

public class HarnessRecords {
	private ArrayList<Harness> harnessCollection;
	
	public HarnessRecords() {
		harnessCollection = new ArrayList<Harness>();
	}
	
	public HarnessRecords(ArrayList<Harness> harnessCollection) {
		this.harnessCollection = harnessCollection;
	}
	
	public boolean isEmpty() {
		if (harnessCollection.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addHarness(Harness harness) {
		harnessCollection.add(harness);
	}
	
	public Harness findHarness(String make, int modelNo) {
		Harness harness = null;
		boolean harnessFound = false;
		int count = 0;
		while (!harnessFound && count < harnessCollection.size()) {
			if (harnessCollection.get(count).make.equals(make) && 
					harnessCollection.get(count).modelNo == modelNo) {
				harness = harnessCollection.get(count);
				harnessFound = true;
			}
			count++;
		}
		return harness;
	}
	
	public Harness checkHarness(String instructorName, String make, int modelNo) {
		Harness harness = findHarness(make, modelNo);
		if (harness != null && !harness.isOnLoan) {
			harness.lastInstructorToCheckSafety = instructorName;
			harness.timesUsed = 0;
			return harness;
		} else {
			return null;
		}
	}
	
	public Harness loanHarness(String memberName) {
		if (!isEmpty()) {
			boolean harnessFound = false;
			int count = 0;
			Harness harness = null;
			while (!harnessFound && count < harnessCollection.size()) {
				harness = harnessCollection.get(count);
				if (harness.canHarnessBeLoaned()) {
					harness.loanHarness(memberName);
					harnessFound = true;
				} else {
					harness = null;
				}
				count++;
			}
			return harness;
		} else {
			return null;
		}
	}
	
	public Harness returnHarness(String make, int modelNo) {
		Harness harness = findHarness(make, modelNo);
		if (harness != null) {
			harness.timesUsed++;
			harness.memberWithHarness = null;
			return harness;
		} else {
			return null;
		}
	}
	
	public Harness removeHarness(String make, int modelNo) {
		Harness harness = findHarness(make, modelNo);
		if (harness != null) {
			boolean harnessFound = false;
			int count = 0;
			while (!harnessFound && count < harnessCollection.size()) {
				Harness secondHarness = harnessCollection.get(count);
				if (harness.make.equals(secondHarness.make) && 
						harness.modelNo == secondHarness.modelNo) {
					harnessCollection.remove(count);
					harnessFound = true;
				} else {
					count++;
				}
			}
			return harness;
		} else {
			return null;
		}
	}
}