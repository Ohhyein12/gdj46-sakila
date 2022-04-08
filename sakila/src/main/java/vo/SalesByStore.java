package vo;

public class SalesByStore {
	private String store;
	private String manager;
	private Double totalSales;
	
	@Override
	public String toString() {
		return "SalesByStore [store=" + store + ", manager=" + manager + ", totalSales=" + totalSales + "]";
	}
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Double getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(Double totalSales) {
		this.totalSales = totalSales;
	}

	
}
