package PROJE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.UnsupportedLookAndFeelException;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Main implements inter {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException,IOException {

		try
		   {
		   Login frame=new Login();
		   }
		   catch(Exception e)
		   {JOptionPane.showMessageDialog(null, e.getMessage());
		   
		   }
		
 }
	

	private static Veri tabloOlustur() throws IOException {
		
		Veri veri = new Veri();

		veri.derslikEkle(1, "D1", 115);
		veri.derslikEkle(2, "D2", 130);
		veri.derslikEkle(4, "D3", 120);
		veri.derslikEkle(5, "D4", 125);
		veri.derslikEkle(6, "D8", 55);
		veri.derslikEkle(7, "D9", 55);
		
		String[] gunler = { "PAZARTES�", "SALI", "�AR�AMBA", "PER�EMBE", "CUMA" };
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
			  if(indis!=21)
			  {
				  indis++;
				  veri.hocaEkle(indis, st);
				  System.out.println(st);
			  }
			  
			  
		  }
			 
		  br.close();
		  //indis=0;
	
		
		 
		
		
		//HOCALAR
		/*veri.hocaEkle(1, "Prof. Dr. Murat Ekinci");
		veri.hocaEkle(2, "Dr. ��r. �yesi Murat Aykut");
		veri.hocaEkle(3, "Do�. Dr. Tu�rul �avdar");
		veri.hocaEkle(4, "Dr. ��r. �yesi Sel�uk Cevher");
		veri.hocaEkle(5, "Dr. ��r. �yesi �brahim Savran");
		veri.hocaEkle(6, "Dr. ��r. �yesi Sedat G�rm��");
		veri.hocaEkle(7, "Prof. Dr. Vas�f Nab�yev");
		veri.hocaEkle(8, "Prof. Dr. Cemal K�se");
		veri.hocaEkle(9, "Prof. Dr. Mustafa Uluta�");
		veri.hocaEkle(10, "Do�. Dr. Bekir Dizdaro�lu");
		veri.hocaEkle(11, "Do�. Dr. G�zin Uluta�");
		veri.hocaEkle(12, "Dr. ��r. �yesi H�seyin Pehlivan");
		veri.hocaEkle(13, "��r. G�r. �mer �ak�r");
		veri.hocaEkle(14, "��r. G�r. Zafer Yavuz");
		veri.hocaEkle(15, "��r. G�r. Hasan Kele�");//mat 1
		veri.hocaEkle(16, "Dr. ��r. �yesi �mit Ertu�rul");//mat 2
		veri.hocaEkle(17, " ��r. G�r. Osman Demirayak");//t�rkdili 1,2
		veri.hocaEkle(18, " ��r. G�r. Deniz �kcesiz");//ing 2
		veri.hocaEkle(19, " ��r. G�r. Nurten Ba�a�a");//ing 1
		veri.hocaEkle(20, " Do�. Dr. Co�kun Ayd�n");//fizik 1
		*/
		
		
		


		//DERSLERb //1. s�n�f bahar
		veri.dersEkle(1, "BIL1000", "ELEKTRON�K DEVRELER", new int[] { 3 },4,0);
		veri.dersEkle(2, "BIL1002", "B�L���M ET���", new int[] { 8 },2,0);
		veri.dersEkle(3, "BIL1004", "OLASILIK VE �STAT�ST�K", new int[] { 2 },3,0);
		veri.dersEkle(4, "COM1000", "PROGRAMLAMAYA G�R��", new int[] {14 },3,0);
		veri.dersEkle(5, "MAT1008", "MATEMAT�K II", new int[] { 16 },4,0);
		veri.dersEkle(6, "TDB1000", "T�RK D�L� II", new int[] { 17 },2,0);
		veri.dersEkle(7, "YDI1002", "�NG�L�ZCE II", new int[] { 18,  },3,0);
		/////////////////////////////////////////////////////////////////////
		
		//1. SINIF G�Z
		veri.dersEkle(8, "BIL1003", "B�LG. M�H. G�R��", new int[] { 2 },2,0);
		veri.dersEkle(9, "BIL1005", "ELEKTR�K DEVRELER�", new int[] { 10 },3,0);
		veri.dersEkle(10, "BIL1007", "B�LG�SAYAR TEMELLER�", new int[] { 9 },3,0);
		veri.dersEkle(11, "FIZ1009", "TEMEL F�Z�K", new int[] {20 },3,0);
		veri.dersEkle(12, "MAT1011", "MATEMAT�K I", new int[] { 15 },4,0);
		veri.dersEkle(13, "TDB1001", "T�RK D�L� I", new int[] { 17 },2,0);
		veri.dersEkle(14, "YDI1001", "�NG�L�ZCE I", new int[] { 19  },3,0);
		
		////////////////////////////////////////////////////////////////////
		
		
		//sINIFLAR
		veri.sinifEkle(1, 80, new int[] { 1,1,  2, 3,3, 4,4, 5,5, 6, 7,7});//1. s�n�f bahar.
		//veri.sinifEkle(1, 80, new int[] { 8,  9,9, 10,10, 11,11, 12,12, 13, 14,14});
		veri.sinifEkle(2, 80, new int[] { 8,  9,9, 10,10, 11,11, 12,12, 13, 14,14});
		
		
		
		
		//veri.sinifEkle(2, 55, new int[] { 1, 1,  2,2, 3,3, 4,4, 5, 6,6, 7,7,});
		//veri.sinifEkle(3, 50, new int[] { 1, 1,  2,2, 3,3, 4,4, 5, 6,6, 7,7,});
		//veri.sinifEkle(4, 110, new int[] { 1, 1,  2,2, 3,3, 4,4, 5, 6,6, 7,7,});
		//veri.sinifEkle(2, 80, new int[] { 1, 1, 1, 1, 2,2,2,2, 3,3,3,3, 4,4,4, 5,5, 6,6,6, 7,7,7,7 });
		//veri.sinifEkle(2, 115, new int[] { 8,8,8,8, 9,9,9, 10,10,10, 11,11,11,11, 12,12,12, 13,13, 14,14,14,14  });
		
		return veri;
	}
	
}
