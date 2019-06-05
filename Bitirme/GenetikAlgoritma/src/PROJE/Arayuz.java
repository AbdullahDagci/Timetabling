package PROJE;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableColumn;

public class Arayuz extends JFrame implements inter {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
	JTable tablo = null;

	String[][] tabloVerileri = { { "8:00------9:00", "", "", "", "", "", "", "" },{ "9:00------10:00", "", "", "", "", "", "", "" },{ "10:00------11:00", "", "", "", "", "", "", "" } ,{ "11:00------12:00", "", "", "", "", "", "", "" },{ "Öðle Arasý", "", "", "", "", "", "", "" },
			{ "13:00------14:00", "", "", "", "", "", "", "" },{ "14:00-----15:00", "", "", "", "", "", "", "" }, { "15:00------16:00", "", "", "", "", "", "", "" },{ "16:00------17:00", "", "", "", "", "", "", "" }
			 };
	String[] sutunlar = { "SAAT", "PAZARTESÝ", "SALI", "ÇARÞAMBA", "PERÞEMBE", "CUMA" };
	
	

	public JPanel southPanel() {
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		return southPanel;
	}

	public Arayuz() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
		UIManager.setLookAndFeel(lookAndFeel);
		tablo = new JTable(tabloVerileri, sutunlar);
		tablo.setDragEnabled(true);
		tablo.setEnabled(true);
		//
		TableColumn ilkSutun = tablo.getColumnModel().getColumn(0);
		ilkSutun.setPreferredWidth(180);
		ilkSutun.setMaxWidth(180);
		ilkSutun.setMinWidth(180);

		for (int i = 1; i < sutunlar.length; i++) {
			TableColumn sutun = tablo.getColumnModel().getColumn(i);
			sutun.setPreferredWidth(150);
			sutun.setMaxWidth(150);
			sutun.setMinWidth(150);
			
			
		}
		tablo.setRowHeight(60);
		tablo.setPreferredScrollableViewportSize(new Dimension(1020, 250));
		JScrollPane scrollPane = new JScrollPane(tablo);
		
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.getContentPane().add(southPanel(), BorderLayout.SOUTH);
		this.setTitle("KARADENÝZ TEKNÝK ÜNÝVERSÝTESÝ BÝLGÝSAYAR MÜHENDÝSLÝÐÝ SINAV PROGRAMI HAZIRLAMA YAZILIMI");
		this.setVisible(true);
		this.setSize(960, 600);
		

		GUIUtil.toCenter(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


	}
	
	public int KrediSayac=0;
	public void tabloDoldur(Etkinlik etkinlik, Veri veri) {
		
		
		String saat = veri.getZaman(etkinlik.getZamanId()).getZamanAdi();
		//int sinif = veri.getSinif(etkinlik.getSinifId()).getSinifId();
		String ders = veri.getDers(etkinlik.getDersId()).getDersAdi();
		int dersId = veri.getDers(etkinlik.getDersId()).getDersId();
		//String hoca = veri.getHoca(etkinlik.getHocaId()).getHocaAdi();
		String derslik = veri.getDerslik(etkinlik.getDerslikId()).getDerslikAdi();
		
		int kredi = veri.getDers(etkinlik.getDersId()).getDersKredi();
		int krediSayac = veri.getDers(etkinlik.getDersId()).getKrediSayac();
	
		
		String bilgi = "<html>" + ders + "<br>Derslik:" +"("+ derslik+")"+"<br>Kredi:"+kredi+"" +"</html>";
		int row = getSatirNumarasi(saat);
		if (saat.startsWith("PAZARTESÝ")) {
			if(kredi!=1) {
				tablo.setValueAt(bilgi, row, 1);
				tablo.setValueAt(bilgi, row+1, 1);
				switch(kredi) {
				case 3:
					KrediSayac++;
					if(KrediSayac==2) {
						tablo.setValueAt("", row+1, 1);
						KrediSayac=0;
						break;
					}
						
				}
			}
			else
				tablo.setValueAt(bilgi, row, 1);
				
		} else if (saat.startsWith("SALI")) {
			if(kredi!=1) {
				tablo.setValueAt(bilgi, row, 2);
				tablo.setValueAt(bilgi, row+1, 2);
				switch(kredi) {
				case 3:
					KrediSayac++;
					if(KrediSayac==2) {
						tablo.setValueAt("", row+1, 2);
						KrediSayac=0;
						break;
					}
					
					
				}
			}
			else
				tablo.setValueAt(bilgi, row, 2);
		} else if (saat.startsWith("ÇARÞAMBA")) {
			if(kredi!=1) {
				tablo.setValueAt(bilgi, row, 3);
				tablo.setValueAt(bilgi, row+1, 3);
				switch(kredi) {
				case 3:
					KrediSayac++;
					if(KrediSayac==2) {
						tablo.setValueAt("", row+1, 3);
						KrediSayac=0;
						break;
					}
					
					
				}
			}
			else
				tablo.setValueAt(bilgi, row, 3);
		} else if (saat.startsWith("PERÞEMBE")) {
			if(kredi!=1) {
				tablo.setValueAt(bilgi, row, 4);
				tablo.setValueAt(bilgi, row+1, 4);
				switch(kredi) {
				case 3:
					KrediSayac++;
					if(KrediSayac==2) {
						tablo.setValueAt("", row+1, 4);
						KrediSayac=0;
						break;
					}
					
				}
			}
			else
				tablo.setValueAt(bilgi, row, 4);
				
			
		} else if (saat.startsWith("CUMA")) {
			if(kredi!=1) {
				tablo.setValueAt(bilgi, row, 5);
				tablo.setValueAt(bilgi, row+1, 5);
				switch(kredi) {
				case 3:
					KrediSayac++;
					if(KrediSayac==2) {
						tablo.setValueAt("", row+1, 5);
						KrediSayac=0;
						break;
					}
					
					
				}
				
			}
			else
				tablo.setValueAt(bilgi, row, 5);
				
			
		}
				
			
		
	}
	
	public void tabloDuzenle(Etkinlik etkinlik, Veri veri) {
		
		String saat = veri.getZaman(etkinlik.getZamanId()).getZamanAdi();
		//int sinif = veri.getSinif(etkinlik.getSinifId()).getSinifId();
		String ders = veri.getDers(etkinlik.getDersId()).getDersAdi();
		int kredi=veri.getDers(etkinlik.getDersId()).getDersKredi();
		int dersId = veri.getDers(etkinlik.getDersId()).getDersId();
		//String hoca = veri.getHoca(etkinlik.getHocaId()).getHocaAdi();
		String derslik = veri.getDerslik(etkinlik.getDerslikId()).getDerslikAdi();
		String bilgi = "<html>" + ders + "<br>Derslik:" +"("+ derslik+")"+"<br>Kredi:"+kredi+"" +"</html>";
		int row = getSatirNumarasi(saat);
		
		if (saat.startsWith("PAZARTESÝ")) {
			
		} 
		else if (saat.startsWith("SALI")) {
			
		} else if (saat.startsWith("ÇARÞAMBA")) {
			
		} else if (saat.startsWith("PERÞEMBE")) {
			
		} else if (saat.startsWith("CUMA")) {
			
		}
	}

	
	private int getSatirNumarasi(String zaman) {
		int row = -1;
		String saatSatiri = zaman.split(" ")[1];
		if (saatSatiri.startsWith("8:00")) {
			row = 0;
		}

		else if (saatSatiri.startsWith("10:00")) {
			row = 2;
		}
	
		else if (saatSatiri.startsWith("13:00")) {
			row = 5;
		}
		
		else if (saatSatiri.startsWith("15:00")) {
			row = 7;			
		}
		
		return row;
	}

	
}
