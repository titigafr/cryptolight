package tg.ahuete.cryptolight.model;

	import java.util.List;

	import javax.xml.bind.annotation.XmlElement;
	import javax.xml.bind.annotation.XmlRootElement;

	/**
	 * Helper class to wrap a list of persons. This is used for saving the
	 * list of persons to XML.
	 * 
	 * @author Marco Jakob
	 */
	@XmlRootElement(name = "Banques")
	public class BanqueListWrapper {

	    private List<Banque> banques;

	    @XmlElement(name = "Banque")
	    public List<Banque> getBanques() {
	    	return banques;
	    }

	    public void setBanques(List<Banque> banques) {
	        this.banques = banques;
	    }
	}

