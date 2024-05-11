package Model;

import java.sql.Date;

public class MedicamenteInfo {
    private Integer disoponibilitate;
    private Date valabilitate;
    private int pret;
    private String producator;
    private String farmacie;
    
	public MedicamenteInfo(int disoponibilitate, Date valabilitate, int pret, String producator,String farmacie) {
		this.disoponibilitate = disoponibilitate;
		this.valabilitate = valabilitate;
		this.pret = pret;
		this.producator = producator;
		this.farmacie=farmacie;
	}
	public String getFarmacie() {
		return farmacie;
	}
	public void setFarmacie(String farmacie) {
		this.farmacie = farmacie;
	}
	public Integer getDisoponibilitate() {
		return disoponibilitate;
	}
	public void setDisoponibilitate(Integer disoponibilitate) {
		this.disoponibilitate = disoponibilitate;
	}
	public Date getValabilitate() {
		return valabilitate;
	}
	public void setValabilitate(Date valabilitate) {
		this.valabilitate = valabilitate;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public String getProducator() {
		return producator;
	}
	public void setProducator(String producator) {
		this.producator = producator;
	}
	@Override
	public String toString() {
		return "MedicamenteInfo [disoponibilitate=" + disoponibilitate + ", valabilitate=" + valabilitate + ", pret="
				+ pret + ", producator=" + producator + "farmacie"+ farmacie +"]";
	}
    
    
}
