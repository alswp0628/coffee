package dto;

public class OrderDto {
	
	private int seq_order;
	private String orderId;
	private String beverage;
	private int syrup;
	private int shortS;
	private int tallS;
	private int grandeS;
	private int shot;
	private int cream;
	private int cup;
	private int price;
	private String wdate;
	
	public OrderDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	public OrderDto(String beverage, int syrup, int shortS, int tallS, int grandeS, int shot, int cream, int cup,
			int price) {
		super();
		this.beverage = beverage;
		this.syrup = syrup;
		this.shortS = shortS;
		this.tallS = tallS;
		this.grandeS = grandeS;
		this.shot = shot;
		this.cream = cream;
		this.cup = cup;
		this.price = price;
	}






	public OrderDto(int seq_order, String orderId, String beverage, int syrup, int shortS, int tallS, int grandeS,
			int shot, int cream, int cup, int price, String wdate) {
		super();
		this.seq_order = seq_order;
		this.orderId = orderId;
		this.beverage = beverage;
		this.syrup = syrup;
		this.shortS = shortS;
		this.tallS = tallS;
		this.grandeS = grandeS;
		this.shot = shot;
		this.cream = cream;
		this.cup = cup;
		this.price = price;
		this.wdate = wdate;
	}






	public int getSeq_order() {
		return seq_order;
	}

	public void setSeq_order(int seq_order) {
		this.seq_order = seq_order;
	}



	public String getOrderId() {
		return orderId;
	}






	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}






	public String getBeverage() {
		return beverage;
	}

	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}

	public int getSyrup() {
		return syrup;
	}

	public void setSyrup(int syrup) {
		this.syrup = syrup;
	}

	public int getShortS() {
		return shortS;
	}

	public void setShortS(int shortS) {
		this.shortS = shortS;
	}

	public int getTallS() {
		return tallS;
	}

	public void setTallS(int tallS) {
		this.tallS = tallS;
	}

	public int getGrandeS() {
		return grandeS;
	}

	public void setGrandeS(int grandeS) {
		this.grandeS = grandeS;
	}

	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}

	public int getCream() {
		return cream;
	}

	public void setCream(int cream) {
		this.cream = cream;
	}

	public int getCup() {
		return cup;
	}

	public void setCup(int cup) {
		this.cup = cup;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}






	@Override
	public String toString() {
		return "OrderDto [seq_order=" + seq_order + ", orderId=" + orderId + ", beverage=" + beverage + ", syrup="
				+ syrup + ", shortS=" + shortS + ", tallS=" + tallS + ", grandeS=" + grandeS + ", shot=" + shot
				+ ", cream=" + cream + ", cup=" + cup + ", price=" + price + ", wdate=" + wdate + "]";
	}

	
	

	
	
	
}
