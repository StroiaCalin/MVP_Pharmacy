package Model;

public class Medicamente {
    private int idMedicamente;
    private String nume;
    private MedicamenteInfo medicamenteInfo;

    public Medicamente() {
        // Default constructor
    }
    public Medicamente(String nume, MedicamenteInfo medicamenteInfo) {
        this(-1, nume, medicamenteInfo);
    }
    
    public Medicamente(int idMedicamente,String nume, MedicamenteInfo medicamenteInfo)
    {
    	this.idMedicamente=idMedicamente;
        this.nume = nume;
        this.medicamenteInfo=medicamenteInfo;
    }
	public int getIdMedicamente() {
		return idMedicamente;
	}
	public void setIdMedicamente(int idMedicamente) {
		this.idMedicamente = idMedicamente;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public MedicamenteInfo getMedicamenteInfo() {
		return medicamenteInfo;
	}
	public void setMedicamenteInfo(MedicamenteInfo medicamenteInfo) {
		this.medicamenteInfo = medicamenteInfo;
	}
	@Override
	public String toString() {
		return "Medicamente [idMedicamente=" + idMedicamente + ", nume=" + nume + ", medicamenteInfo=" + medicamenteInfo.toString()
				+ "]";
	}
	
}