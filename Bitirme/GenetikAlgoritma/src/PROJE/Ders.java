package PROJE;

public class Ders {
	//Bu deðerler deðiþtirilemeyeceði için final.
	private final int dersId;
	private final String dersKodu;
	private final String dersAdi;
	private final int hocaIdListesi[];
	public int dersKredi;
	public  int krediSayac=0;//Tablo düzenlemede yani dersleri 2+1 bölmek için kullandýk.


	public int getKrediSayac() {
		return krediSayac;
	}
	public void setKrediSayac()
	{
		this.krediSayac+=1;
	}

	public int getDersKredi() {
		return dersKredi;
	}


	public Ders(int dersId, String dersKodu, String dersAdi, int hocaIdListesi[],int dersKredi,int krediSayac) {
		this.dersId = dersId;
		this.dersKodu = dersKodu;
		this.dersAdi = dersAdi;
		this.hocaIdListesi = hocaIdListesi;
		this.dersKredi=dersKredi;
		this.krediSayac=krediSayac;
	}


	public int getDersId() {
		return this.dersId;
	}


	public String getDersKodu() {
		return this.dersKodu;
	}


	public String getDersAdi() {
		return this.dersAdi;
	}

	
	public int getRastgeleHocaId() {
		int hocaId = hocaIdListesi[(int) (hocaIdListesi.length * Math.random())];
		return hocaId;
	}
	
	
}
