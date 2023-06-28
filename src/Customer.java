
public class Customer {
	private double thersold;
	private String ID;
	public Customer (double thersold, String ID) {
		this.ID=ID;
		this.thersold=thersold;
	}
	public double getThersold() {
		return thersold;
	}
	public void setThersold(double thersold) {
		this.thersold = thersold;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

}
