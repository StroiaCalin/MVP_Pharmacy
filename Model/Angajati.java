package Model;

public class Angajati {
	    private int id;
	    private String name;
	    private String farmacie;

	    public Angajati() {
	        // Default constructor
	    }
	    public Angajati(String name, String farmacie) {
	        this(-1,name,farmacie);
	    }
	    
	    public Angajati(int id, String name,String farmacie) {
	        this.id = id;
	        this.name = name;
	        this.farmacie = farmacie;
	    }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFarmacie() {
			return farmacie;
		}
		public void setFarmacie(String farmacie) {
			this.farmacie = farmacie;
		}
		@Override
		public String toString() {
			return "Angajati [id=" + id + ", name=" + name + ", farmacie=" + farmacie + "]";
		}
	    
}