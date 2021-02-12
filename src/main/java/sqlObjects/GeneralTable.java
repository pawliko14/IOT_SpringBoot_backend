package sqlObjects;

public class GeneralTable {

	private String id;
	private String id_karty;
	private String akcja;
	private String data;
	private String nazwisko_imie;
	private String hacosoftnumber;
	private String stanowisko;
	private String firma;

	public GeneralTable(String naz_imie, String id_karty, String firma, String stanowisko) {
		this.nazwisko_imie = naz_imie;
		this.id_karty =id_karty;
		this.firma = firma;
		this.stanowisko = stanowisko;
	}
	
	
	public GeneralTable(String id, String id_karty, String akcja, String data, String nazwisko_imie,
			String hacosoftnumber, String stanowisko, String firma) {
		super();
		this.id = id;
		this.id_karty = id_karty;
		this.akcja = akcja;
		this.data = data;
		this.nazwisko_imie = nazwisko_imie;
		this.hacosoftnumber = hacosoftnumber;
		this.stanowisko = stanowisko;
		this.firma = firma;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_karty() {
		return id_karty;
	}
	public void setId_karty(String id_karty) {
		this.id_karty = id_karty;
	}
	public String getAkcja() {
		return akcja;
	}
	public void setAkcja(String akcja) {
		this.akcja = akcja;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNazwisko_imie() {
		return nazwisko_imie;
	}
	public void setNazwisko_imie(String nazwisko_imie) {
		this.nazwisko_imie = nazwisko_imie;
	}
	public String getHacosoftnumber() {
		return hacosoftnumber;
	}
	public void setHacosoftnumber(String hacosoftnumber) {
		this.hacosoftnumber = hacosoftnumber;
	}
	public String getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}
	public String getFirma() {
		return firma;
	}
	public void setFirma(String firma) {
		this.firma = firma;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((akcja == null) ? 0 : akcja.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((firma == null) ? 0 : firma.hashCode());
		result = prime * result + ((hacosoftnumber == null) ? 0 : hacosoftnumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_karty == null) ? 0 : id_karty.hashCode());
		result = prime * result + ((nazwisko_imie == null) ? 0 : nazwisko_imie.hashCode());
		result = prime * result + ((stanowisko == null) ? 0 : stanowisko.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeneralTable other = (GeneralTable) obj;
		if (akcja == null) {
			if (other.akcja != null)
				return false;
		} else if (!akcja.equals(other.akcja))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (firma == null) {
			if (other.firma != null)
				return false;
		} else if (!firma.equals(other.firma))
			return false;
		if (hacosoftnumber == null) {
			if (other.hacosoftnumber != null)
				return false;
		} else if (!hacosoftnumber.equals(other.hacosoftnumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_karty == null) {
			if (other.id_karty != null)
				return false;
		} else if (!id_karty.equals(other.id_karty))
			return false;
		if (nazwisko_imie == null) {
			if (other.nazwisko_imie != null)
				return false;
		} else if (!nazwisko_imie.equals(other.nazwisko_imie))
			return false;
		if (stanowisko == null) {
			if (other.stanowisko != null)
				return false;
		} else if (!stanowisko.equals(other.stanowisko))
			return false;
		return true;
	}
	
	
	
	
	

	
	
}
