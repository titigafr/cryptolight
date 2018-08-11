package tg.ahuete.cryptolight.model;

public class Banque {
	private String banqueName;
	private String publicApi;
	private String secretApi;
	private String banqueType;
	    	    
	public Banque() {
	    	banqueName=null;
	    	publicApi = null;
	    	secretApi=null;
	    	banqueType=null; 
	}
	
	public Banque(String string, String string2, String string3, String string4) {
		this.setName(string);
		this.setPublicApi(string2);
		this.setSecretApi(string3);
		this.setBanqueType(string4);
	}

	public String getName() {
		return this.banqueName;
	}
	
	public String getPublicApi() {
		return this.publicApi;
	}
	
	public String getSecretApi() {
		return this.secretApi;
	}
	
	public String getBanqueType() {
		return this.banqueType;
	}
	
	public void setName(String name) {
		this.banqueName = name;
	}
	
	public void setPublicApi(String publicApi) {
		this.publicApi = publicApi;
	}
	
	public void setSecretApi(String secretApi) {
		this.secretApi = secretApi;
	}
	
	public void setBanqueType(String banqueType) {
		this.banqueType = banqueType;
	}
	
	public void saveData() {
		//ici on va mettre la procedure qui va pemettre d'enregistrer la banque et son type
	}
	
}
