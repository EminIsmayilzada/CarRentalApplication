                                                                                     
public class Car {
	private double quality;
	private String ID;
	private int daysLeft;
	public Car(String ID,double quality, int daysLeft) {
		this.ID=ID;
		this.quality=quality;
		this.daysLeft=daysLeft;
}
	 
	
	public double getQuality() {
		return quality;
	}
	public void setQuality(double quality) {
		this.quality = quality;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getDaysLeft() {
		return daysLeft;
	}
	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}
}
