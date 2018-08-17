package tg.ahuete.cryptolight.model;

public class CurrentCurrency{
	private String nomSite;
	private String orderSellPrice;
	private String orderSellQuantity;
	private String orderBuyPrice;
	private String orderBuyQuantity;
	    	    
	public CurrentCurrency() {
	    	nomSite=null;
	    	orderSellPrice=null;
	    	orderSellQuantity=null;
	    	orderBuyPrice=null;
	    	orderBuyQuantity=null; 
	}
	
	public CurrentCurrency(String string, String string2, String string3, String string4, String string5) {
		this.setNomSite(string);
		this.setOrderSellPrice(string2);
		this.setOrderSellQuantity(string3);
		this.setOrderBuyPrice(string4);
		this.setOrderBuyQuantity(string5);
	}

	public String getNomSite() {
		return this.nomSite;
	}
	
	public String getOrderSellPrice() {
		return this.orderSellPrice;
	}
	
	public String getOrderSellQuantity() {
		return this.orderSellQuantity;
	}
	
	public String getOrderBuyPrice() {
		return this.orderBuyPrice;
	}
	public String getOrderBuyQuantity() {
		return this.orderBuyQuantity;
		
	}
	
	public void setNomSite(String name) {
		this.nomSite = name;
	}
	
	public void setOrderSellPrice(String orderSellPrice) {
		this.orderSellPrice = orderSellPrice;
	}
	
	public void setOrderSellQuantity(String orderSellQuantity) {
		this.orderSellQuantity = orderSellQuantity;
	}
	
	public void setOrderBuyPrice(String orderBuyPrice) {
		this.orderBuyPrice = orderBuyPrice;
	}
	
	public void setOrderBuyQuantity(String orderBuyQuantity) {
		this.orderBuyQuantity = orderBuyQuantity;
	}
	
	public void saveData() {
		//ici on va mettre la procedure qui va pemettre d'enregistrer la banque et son type
	}
	
}

