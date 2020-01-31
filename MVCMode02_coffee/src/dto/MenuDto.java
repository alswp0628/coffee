package dto;

public class MenuDto {
	private int id;
	private String beverage;
	private int shortSize;
	private int tallSize;
	private int grandeSize;
	
	public MenuDto() {
		// TODO Auto-generated constructor stub
	}

	public MenuDto(int id,String beverage, int shortSize, int tallSize, int grandeSize) {
		super();
		this.id = id;
		this.beverage = beverage;
		this.shortSize = shortSize;
		this.tallSize = tallSize;
		this.grandeSize = grandeSize;
	}

	public String getBeverage() {
		return beverage;
	}

	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}

	public int getShortSize() {
		return shortSize;
	}

	public void setShortSize(int shortSize) {
		this.shortSize = shortSize;
	}

	public int getTallSize() {
		return tallSize;
	}

	public void setTallSize(int tallSize) {
		this.tallSize = tallSize;
	}

	public int getGrandeSize() {
		return grandeSize;
	}

	public void setGrandeSize(int grandeSize) {
		this.grandeSize = grandeSize;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "menuDto [beverage=" + beverage + ", shortSize=" + shortSize + ", tallSize=" + tallSize + ", grandeSize="
				+ grandeSize + "]";
	}
	
	
}
