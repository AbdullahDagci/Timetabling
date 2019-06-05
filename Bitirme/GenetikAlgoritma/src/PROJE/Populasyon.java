package PROJE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Populasyon {
	private Kromozom kromozom[];
	private double populasyonUygunlukDegeri = -1;

	public Populasyon(int populasyonBuyuklugu) {
		//Ba�lang�� pop�lasyonu
		this.kromozom = new Kromozom[populasyonBuyuklugu];
	}

	public Populasyon(int populasyonBuyuklugu, Veri veri) {
		this.kromozom = new Kromozom[populasyonBuyuklugu];

		for (int i = 0; i < populasyonBuyuklugu; i++) {
			Kromozom kromozom = new Kromozom(veri);
			this.kromozom[i] = kromozom;
		}
	}

	public Populasyon(int populasyonBuyuklugu, int kromozomUzunlugu) {
		this.kromozom = new Kromozom[populasyonBuyuklugu];
		for (int i = 0; i < populasyonBuyuklugu; i++) {
			Kromozom kromozom = new Kromozom(kromozomUzunlugu);
			this.kromozom[i] = kromozom;
		}
	}

	public Kromozom[] getKromozomListesi() {
		return this.kromozom;
	}

	//pop�lasyondaki en uygun kromozom d�nd�r�l�yor.
	public Kromozom getPopulasyonUygunluk(int indis) {
		Arrays.sort(this.kromozom, new Comparator<Kromozom>() {
			@Override
			public int compare(Kromozom o1, Kromozom o2) {
				if (o1.getKromozomUygunluk() > o2.getKromozomUygunluk()) {
					return -1;
				} else if (o1.getKromozomUygunluk() < o2.getKromozomUygunluk()) {
					return 1;
				}
				return 0;
			}
		});

		return this.kromozom[indis];
	}

	public void setPopulasyonUygunlukDegeri(double uygunluk) {
		this.populasyonUygunlukDegeri = uygunluk;
	}

	public double getPopulasyonUygunlukDegeri() {
		return this.populasyonUygunlukDegeri;
	}

	
	public int getPopulasyonbuyuklugu() {
		return this.kromozom.length;
	}

	
	public Kromozom setKromozom(int indis, Kromozom kromozom) {
		return this.kromozom[indis] = kromozom;
	}

	
	public Kromozom getKromozom(int indis) {
		return kromozom[indis];
	}

	public void populasyonSirala() {
		Random rnd = new Random();
		for (int i = kromozom.length - 1; i > 0; i--) {
			int indis = rnd.nextInt(i + 1);
			Kromozom temp = kromozom[indis];
			kromozom[indis] = kromozom[i];
			kromozom[i] = temp;
		}
	}
}