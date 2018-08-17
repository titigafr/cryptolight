package tg.ahuete.cryptolight.model;

public class Banque {
	private String nomSite;
	private String publicApi;
	private String secretApi;
	private String banqueType;
	    	    
	public Banque() {
	    	nomSite=null;
	    	publicApi = null;
	    	secretApi=null;
	    	banqueType=null; 
	}
	
	public Banque(String string, String string2, String string3, String string4) {
		this.setNomSite(string);
		this.setPublicApi(string2);
		this.setSecretApi(string3);
		this.setBanqueType(string4);
	}

	public String getNomSite() {
		return this.nomSite;
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
	
	public void setNomSite(String name) {
		this.nomSite = name;
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
