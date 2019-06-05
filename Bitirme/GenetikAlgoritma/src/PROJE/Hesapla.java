package PROJE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
  
class Hesapla extends JFrame implements ActionListener
 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton SUBMIT;
	  //JPanel panel;
	  //JLabel label1,label2,label3,label4,label5,label6;
	  //final JTextField  text1,text2,text3,text4,text5,text6;
	  
	  
	  public JButton giris;// butonlara verdigimiz isimler
	    public JPanel panel;//bilesenleri üzerine atacagimiz panel
	    public JTextField text1,text2,text3,text4,text5,text6; //text fieldlere (yazi alanlarina) verdigimiz isimler
	    public JFrame f; //görsel penceremiz
	    public JLabel label1,label2,label3,label4,label5,label6;
	    
   Hesapla()
	  {
	  
	   f = new JFrame("Program girdileri");//tasarladigimiz ekranin yazisi
       f.setBounds(300, 800, 400, 450);//pencere boyutlari
       f.setLocation(520, 230);// program çalistiginda ekran konumu
       
       panel = new JPanel();//paneli tanimliyoruz.
       panel.setLayout(null);//neseleri yerlestirmek için null olmali
       
       
       label1 = new JLabel("Populasyon Büyüklüðü:");//labelin yazisi
       label1.setForeground(Color.black);//rengi
       label1.setBounds(20, 80, 150, 25);//boyutlari
       

       text1 = new JTextField();//text alanini
       text1.setBackground(Color.white);//renk
       text1.setBounds(200, 80, 150, 25);//boyut
       text1.setText("100");

       label2 = new JLabel("Mutasyon Oraný(0-1):", HEIGHT);//sifre alani
       label2.setForeground(Color.black);
       label2.setBounds(20, 130, 150, 25);

       text2 = new JTextField();//sifre text alani
       text2.setBackground(Color.white);
       text2.setBounds(200, 130, 150, 25);
       text2.setText("0.01");
       
       label3 = new JLabel("Çaprazlama Oraný(0-1):");//labelin yazisi
       label3.setForeground(Color.black);//rengi
       label3.setBounds(20, 180, 150, 25);//boyutlari

       text3 = new JTextField();//text alanini
       text3.setBackground(Color.white);//renk
       text3.setBounds(200, 180, 150, 25);//boyut
       text3.setText("0.09");

       label4 = new JLabel("Seçkin Kromozom Sayýsý:", HEIGHT);//sifre alani
       label4.setForeground(Color.black);
       label4.setBounds(20, 230, 150, 25);
       

       text4 = new JTextField();//sifre text alani
       text4.setBackground(Color.white);
       text4.setBounds(200, 230, 150, 25);
       text4.setText("2");
       
       
       label5 = new JLabel("Turnuva Seçim Boyutu", HEIGHT);//sifre alani
       label5.setForeground(Color.black);
       label5.setBounds(20, 280, 150, 25);

       text5 = new JTextField();//sifre text alani
       text5.setBackground(Color.white);
       text5.setBounds(200, 280, 150, 25);
       text5.setText("5");
       

       giris = new JButton("Programý Oluþtur");// giris butonu
       //giris.setBackground(Color.cyan);//renk
       giris.setBounds(20, 320, 150, 50);//boyut
        

       f.setContentPane(panel);//panel frame degiskenine yüklenir
       f.setResizable(true);// yeniden boyutlandirma engellenir
       f.setVisible(true);//frame görünür yapilir
       
       //panele bütün bilesenler atilir
       panel.add(label1);
       panel.add(text1);
       panel.add(label2);
       panel.add(text2);
       
       panel.add(label3);
       panel.add(text3);
       panel.add(label4);
       panel.add(text4);
       
       panel.add(label5);
       panel.add(text5);
      
       panel.add(giris);
      
        //p.add(lbl_aciklama);
       //p.add(rsm);
       giris.addActionListener(this);
	   }
   public void actionPerformed(ActionEvent ae)
   {
   
   int popBuyuklugu = Integer.parseInt(this.text1.getText());
   Veri veri = null;
   
   double mutasyonOrani=Double.parseDouble(this.text2.getText());
   double caprazlamaOrani=Double.parseDouble(this.text3.getText());
   
   int seckinKromozomSayisi = Integer.parseInt(this.text4.getText());
   int turnuvaSecimBoyutu = Integer.parseInt(this.text5.getText());
   
   
   
	try {
		veri = tabloOlustur();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
   //Baþla
	
	GenetikAlgoritma ga = new GenetikAlgoritma(popBuyuklugu, mutasyonOrani, caprazlamaOrani, seckinKromozomSayisi, turnuvaSecimBoyutu);
	Populasyon populasyon = ga.baslangicPopulasyonuOlustur(veri);
	
	
	//baþlangýç populasyonunun uygunluk deðeri hesaplanýyor
	ga.populasyonUygunlukHesapla(populasyon, veri);
	int nesil = 1;

	//Genetik algoritma sonlanma koþulu..Burasý çok önemli
	while (ga.sonlanmaKosulu(nesil, 1000) == false && ga.sonlanmaKosulu(populasyon) == false) {
		Kromozom[] genListesi = populasyon.getKromozomListesi();
		System.out.println("***************Nesil" + nesil + "***************");
		int i = 1;
		for (Kromozom kromozom : genListesi) {
			System.out.println("Kromozom no." + i + ": " + kromozom.getKromozomUygunluk());
			System.out.println(kromozom.kromozomuYazdir() + "\n");
			i++;
		}
		veri.setEtkinlik(populasyon.getPopulasyonUygunluk(0));
		System.out.println("G" + nesil + " En iyi uygunluk: " + populasyon.getPopulasyonUygunluk(0).getKromozomUygunluk());
		System.out.println("Çakýþma: " + veri.karsilastirDerslikOgrS());
		ga.populasyonUygunlukHesapla(populasyon, veri);
		populasyon = ga.populasyonCaprazlama(populasyon);
		populasyon = ga.populasyonMutasyonu(populasyon, veri);
		
		nesil++;
	}
	System.out.println("******************************Nesil" + nesil + "******************************");
	int i = 1;
	Kromozom[] genListesi = populasyon.getKromozomListesi();
	for (Kromozom kromozom : genListesi) {
		System.out.println("Kromozom no." + i + ": " + kromozom.getKromozomUygunluk());
		System.out.println(kromozom.kromozomuYazdir() + "\n");
		i++;
	}

	veri.setEtkinlik(populasyon.getPopulasyonUygunluk(0));
	System.out.println();
	System.out.println("Toplam " + nesil + " nesil oluþturuldu.");
	//this.text6.setText(Integer.toString(nesil));
	System.out.println("En iyi neslin uygunluk deðeri: " + populasyon.getPopulasyonUygunluk(0).getKromozomUygunluk());
	System.out.println("Çakýþma sayýsý: " + veri.karsilastirDerslikOgrS());
	System.out.println();
	Etkinlik etkinlikler[] = veri.getEtkinlik();
	int classIndex = 1;

	Sinif[] siniflar = veri.getSiniflarinDersListesi();
	
	HashMap<Integer, Arayuz> arayuzVeri = new HashMap<Integer, Arayuz>();
	for (Sinif sinif : siniflar) {
		Arayuz arayuz = null;
		try {
			arayuz = new Arayuz();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arayuz.setTitle(arayuz.getTitle() + " SINIF " + sinif.getSinifId());
		arayuzVeri.put(sinif.getSinifId(), arayuz);
	}
	
	//oluþturulan etkinlikler tablodoldur fonksiyonu ile tabloya yazýlýyor.
	for (Etkinlik etkinlik : etkinlikler) {
		System.out.println("Etkinlik " + classIndex + ":");
		System.out.println("Ders: " + veri.getDers(etkinlik.getDersId()).getDersAdi());
		int sinifId = veri.getSinif(etkinlik.getSinifId()).getSinifId();
		System.out.println("Sinif: " + sinifId);
		System.out.println("Derslik: " + veri.getDerslik(etkinlik.getDerslikId()).getDerslikAdi());
		//System.out.println("Hoca: " + veri.getHoca(etkinlik.getHocaId()).getHocaAdi());
		System.out.println("Saat: " + veri.getZaman(etkinlik.getZamanId()).getZamanAdi());
		
		//veri.set
		arayuzVeri.get(sinifId).tabloDoldur(etkinlik, veri);
		//arayuzVeri.get(sinifId).tabloDuzenle(etkinlik, veri);

		System.out.println("-----");
		classIndex++;
	}
   
   }
   
   private static Veri tabloOlustur() throws IOException
   {
	   Veri veri = new Veri();

		veri.derslikEkle(1, "D1", 115);
		veri.derslikEkle(2, "D2", 130);
		veri.derslikEkle(4, "D3", 120);
		veri.derslikEkle(5, "D4", 125);
		veri.derslikEkle(6, "D8", 55);
		veri.derslikEkle(7, "D9", 55);
		
		String[] gunler = { "PAZARTESÝ", "SALI", "ÇARÞAMBA", "PERÞEMBE", "CUMA" };
		for (int i = 0; i < gunler.length; i++) {
			veri.zamanEkle(1 + i * 6, gunler[i] + " 8:00 - 10:00");
			veri.zamanEkle(2 + i * 6, gunler[i] + " 10:00 - 12:00");
			veri.zamanEkle(3 + i * 6, gunler[i] + " 13:00 - 15:00");
			veri.zamanEkle(4 + i * 6, gunler[i] + " 15:00 - 17:00");

			/*veri.zamanEkle(5 + i * 6, gunler[i] + " 13:00 - 14:00");
			veri.zamanEkle(6 + i * 6, gunler[i] + " 14:00 - 15:00");
			veri.zamanEkle(7 + i * 6, gunler[i] + " 15:00 - 16:00");
			veri.zamanEkle(8 + i * 6, gunler[i] + " 16:00 - 17:00");
			*/
			
		}
		
		
		File file = new File("C:\\Users\\ABDULLAH\\Desktop\\txtHoca.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  int indis=0;
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {
			  indis++;
				  veri.hocaEkle(indis, st);
				  System.out.println(st);
  
		  }
			 
		  br.close();
		  
		
		  
		//DERSLER //1. sýnýf bahar
		veri.dersEkle(1, "BIL1000", "ELEKTRONÝK DEVRELER", new int[] { 3 },4,0);
		veri.dersEkle(2, "BIL1002", "BÝLÝÞÝM ETÝÐÝ", new int[] { 8 },2,0);
		veri.dersEkle(3, "BIL1004", "OLASILIK VE ÝSTATÝSTÝK", new int[] { 2 },3,0);
		veri.dersEkle(4, "COM1000", "PROGRAMLAMAYA GÝRÝÞ", new int[] {14 },3,0);
		veri.dersEkle(5, "MAT1008", "MATEMATÝK II", new int[] { 16 },4,0);
		veri.dersEkle(6, "TDB1000", "TÜRK DÝLÝ II", new int[] { 17 },2,0);
		veri.dersEkle(7, "YDI1002", "ÝNGÝLÝZCE II", new int[] { 18  },3,0);
		/////////////////////////////////////////////////////////////////////
		
		//2. SINIF BAHAR
		veri.dersEkle(8, "BIL1003", "OTOMATA TEORÝSÝ", new int[] { 13 },3,0);
		veri.dersEkle(9, "BIL1005", "PROGRAMLAMA DÝLLERÝ", new int[] { 12 },3,0);
		veri.dersEkle(10, "BIL1007", "MÝKROÝÞLEMCÝLER", new int[] { 9 },4,0);
		veri.dersEkle(11, "FIZ1009", "ALGORÝTMALAR", new int[] {7 },3,0);
		veri.dersEkle(12, "MAT1011", "MÜHENDÝSLÝK MATEMATÝÐÝ", new int[] { 1 },3,0);
		veri.dersEkle(13, "TDB1001", "SAYISAL TASARIM LAB", new int[] { 1 },1,0);
		
		//3. SINIF BAHAR
		////////////////////////////////////////////////////////////////////
		veri.dersEkle(14, "BIL1003", "SÝNYALLER VE SÝSTEMLER", new int[] { 10 },3,0);
		veri.dersEkle(15, "BIL1005", "SÝSTEM PROGRAMLAMA", new int[] { 12 },3,0);
		veri.dersEkle(16, "BIL1007", "BÝLGÝSAYAR AÐLARI", new int[] { 8 },4,0);
		veri.dersEkle(17, "FIZ1009", "BÝLGÝSAYAR GRAFÝKLERÝ", new int[] {13 },3,0);
		veri.dersEkle(18, "MAT1011", "GÖRÜNTÜ ÝÞLEME", new int[] { 1 },3,0);
		veri.dersEkle(19, "TDB1001", "WEB PROGRAMLAMA", new int[] { 10 },3,0);
		veri.dersEkle(20, "TDB1001", "OPTÝMÝZASYON", new int[] { 7 },3,0);
		
		//4. SINIF BAHAR   
		///////////////////////////////////////////////////////////
		veri.dersEkle(21, "BIL1003", "MESLEKÝ DENEYÝM II", new int[] { 10 },1,0);
		veri.dersEkle(22, "BIL1005", "BÝTÝRME PROJESÝ", new int[] { 12 },2,0);
		veri.dersEkle(23, "BIL1007", "ÝNKILAP II", new int[] { 17 },2,0);
		veri.dersEkle(24, "FIZ1009", "AÐ VE VERÝ GÜVENLÝÐÝ", new int[] {11 },3,0);
		veri.dersEkle(25, "MAT1011", "PARALEL BÝLGÝSAYARLAR", new int[] { 5 },3,0);
		veri.dersEkle(26, "TDB1001", "VERÝ MADENCÝLÝÐÝ", new int[] { 11 },3,0);
		veri.dersEkle(27, "TDB1001", "TIBBÝ GÖRÜNTÜLEME", new int[] { 10 },3,0);
		veri.dersEkle(28, "TDB1001", "BULANIK MANTIK", new int[] { 18 },3,0);
		
		
		
		//sINIFLAR
		veri.sinifEkle(1, 80, new int[] { 1,1,  2, 3,3, 4,4, 5,5, 6, 7,7});
		
		veri.sinifEkle(2, 80, new int[] { 8,8,  9,9, 10,10, 11,11, 12,12, 13});
		
		veri.sinifEkle(3, 120, new int[] { 14,14,  15,15, 16,16, 17,17, 18,18, 19,19, 20,20});
		
		veri.sinifEkle(4, 110, new int[] { 21,  22, 23,23, 24,24, 25,25, 26,26, 27,27, 28,28});
		
		
		
		return veri;
   }
  }