package PROJE;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
  
class Login extends JFrame implements ActionListener
 {
	public JButton giris;// butonlara verdigimiz isimler
    public JPanel p;//bilesenleri üzerine atacagimiz panel
    public JTextField jt_ad; //text fieldlere (yazi alanlarina) verdigimiz isimler
    public JFrame f; //görsel penceremiz
    public JLabel jl_ad, jl_sifre, r1;
   
 
    public ImageIcon resim;//tasarimda kullancagimiz resim
    public JPasswordField jpwName; //sifre alani
   Login() throws IOException
   {
	      
	  
	    
	   f = new JFrame("Giris Ekrani");//tasarladigimiz ekranin yazisi
       f.setBounds(300, 800, 350, 325);//pencere boyutlari
       f.setLocation(520, 230);// program çalistiginda ekran konumu
       //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//kapatma tusuna bastigimizda programin kapanmasini istiyoruz
       
       p = new JPanel();//paneli tanimliyoruz.
       p.setLayout(null);//neseleri yerlestirmek için null olmali
       
       
       jl_ad = new JLabel("Kullanici Adi");//labelin yazisi
       jl_ad.setForeground(Color.black);//rengi
       jl_ad.setBounds(65, 80, 125, 25);//boyutlari

       jt_ad = new JTextField();//text alanini
       jt_ad.setBackground(Color.white);//renk
       jt_ad.setBounds(165, 80, 125, 25);//boyut

       jl_sifre = new JLabel("Sifre", HEIGHT);//sifre alani
       jl_sifre.setForeground(Color.black);
       jl_sifre.setBounds(65, 130, 125, 25);

       jpwName = new JPasswordField();//sifre text alani
       jpwName.setBackground(Color.white);
       jpwName.setBounds(165, 130, 125, 25);


       giris = new JButton("Giris");// giris butonu
       //giris.setBackground(Color.cyan);//renk
       giris.setBounds(65, 170, 90, 50);//boyut
        
        

       f.setContentPane(p);//panel frame degiskenine yüklenir
       f.setResizable(false);// yeniden boyutlandirma engellenir
       f.setVisible(true);//frame görünür yapilir
       
       //panele bütün bilesenler atilir
       f.add(jl_ad);
       f.add(jt_ad);
       f.add(jl_sifre);
       f.add(jpwName);
       f.add(giris);
       //f.add(imgLabel);
        //p.add(lbl_aciklama);
       //p.add(rsm);
       giris.addActionListener(this);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
   
  public void actionPerformed(ActionEvent ae)
   {
   String value1=jt_ad.getText();
   String value2=jpwName.getText();
   if (value1.equals("ktu") && value2.equals("123")) {
   
   Hesapla page=new Hesapla();
   page.setVisible(true);
   
   this.dispose();
   f.dispose();
 
   //JLabel label = new JLabel("Welcome:"+value1);
   //page.getContentPane().add(label);
   }
   else{
   System.out.println("Kullanýcý adý veya þifre yanlýþ.");
   JOptionPane.showMessageDialog(this,"Kullanýcý adý veya þifre yanlýþ.",
   "Error",JOptionPane.ERROR_MESSAGE);
   }
 }
 }
