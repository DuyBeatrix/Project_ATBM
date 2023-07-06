package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.HeadlessException;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import controller.ElgamalListener;
import model.ElgamalModel;

import javax.swing.JTextField;

public class ElgamalView extends JFrame 
{
	public ElgamalModel elgamalModel;
	public JPanel contentPane;
	public JTextField jtextfield_ChonSoP;
	public JTextField jtextfield_ChonSoAlpha;
	public JTextField jtextfield_ChonSoA;
	public JTextField jtextfield_SoGamma;
	public JTextField jtextfield_ChonSoK;
	public JTextField jtextfield_SoP;
	public JTextField jtextfield_SoAlpha;
	public JTextField jtextfield_SoBeta;
	public JTextField jtextfield_SoA;
	public JTextArea jtextarea_VanBanKy;
	public JTextArea jtextarea_ChuKy;
	public JTextArea jtextarea_VanBanKy_Check;
	public JTextArea jtextarea_ChuKy_Check;
	public JTextArea jtextarea_ThongBao;

	public ElgamalView() throws HeadlessException
	{
		this.elgamalModel = new ElgamalModel();
		this.init();
	}

	private void init() 
	{
		this.setTitle("ELGAMAL SIGNATURE");
		
		// ContentPane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 950, 500); // x, y, heights, wide 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Font
		Font font = new Font("ARIAL", Font.BOLD, 16);
		
		// ActionListener
		ActionListener ac = new ElgamalListener(this);
		
		// Create Tab
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 936, 463);
		contentPane.add(tabbedPane);
		
		// Tab Create Key
		JPanel jpanel_TaoKhoa = new JPanel();
		tabbedPane.addTab("Tạo Khóa\r\n", null, jpanel_TaoKhoa, null);
		jpanel_TaoKhoa.setLayout(null);
		
		JLabel jlabel_ChonSoP = new JLabel("Chọn số nguyên tố P (Đủ lớn)", SwingConstants.CENTER);
		jlabel_ChonSoP.setFont(font);
		jlabel_ChonSoP.setBounds(10, 31, 237, 33);
		jpanel_TaoKhoa.add(jlabel_ChonSoP);
		
		jtextfield_ChonSoP = new JTextField();
		jtextfield_ChonSoP.setFont(font);
		jtextfield_ChonSoP.setBounds(284, 35, 162, 26);
		jpanel_TaoKhoa.add(jtextfield_ChonSoP);
		jtextfield_ChonSoP.setColumns(10);
		
		JLabel jlabel_ChonSoAlpha = new JLabel("Chọn số (Alpha) a", SwingConstants.CENTER);
		jlabel_ChonSoAlpha.setFont(font);
		jlabel_ChonSoAlpha.setBounds(10, 92, 148, 33);
		jpanel_TaoKhoa.add(jlabel_ChonSoAlpha);
		
		jtextfield_ChonSoAlpha = new JTextField();
		jtextfield_ChonSoAlpha.setFont(font);
		jtextfield_ChonSoAlpha.setBounds(284, 96, 162, 26);
		jpanel_TaoKhoa.add(jtextfield_ChonSoAlpha);
		jtextfield_ChonSoAlpha.setColumns(10);
		
		JLabel jlabel_ChonSoA = new JLabel("Chọn số A (1<A<P-1)", SwingConstants.CENTER);
		jlabel_ChonSoA.setFont(font);
		jlabel_ChonSoA.setBounds(10, 153, 168, 33);
		jpanel_TaoKhoa.add(jlabel_ChonSoA);
		
		jtextfield_ChonSoA = new JTextField();
		jtextfield_ChonSoA.setFont(font);
		jtextfield_ChonSoA.setBounds(284, 157, 162, 26);
		jpanel_TaoKhoa.add(jtextfield_ChonSoA);
		jtextfield_ChonSoA.setColumns(10);
		
		JLabel jlabel_SoGamma = new JLabel("Số (Gamma) = a^K mod P", SwingConstants.CENTER);
		jlabel_SoGamma.setFont(font);
		jlabel_SoGamma.setBounds(10, 213, 201, 39);
		jpanel_TaoKhoa.add(jlabel_SoGamma);
		
		jtextfield_SoGamma = new JTextField();
		jtextfield_SoGamma.setFont(font);
		jtextfield_SoGamma.setBounds(284, 220, 162, 26);
		jpanel_TaoKhoa.add(jtextfield_SoGamma);
		jtextfield_SoGamma.setColumns(10);
		
		JLabel jlabel_ChonSoK = new JLabel("Chọn số K (1=<K<=P-2)", SwingConstants.CENTER);
		jlabel_ChonSoK.setFont(font);
		jlabel_ChonSoK.setBounds(10, 276, 191, 39);
		jpanel_TaoKhoa.add(jlabel_ChonSoK);
		
		jtextfield_ChonSoK = new JTextField();
		jtextfield_ChonSoK.setFont(font);
		jtextfield_ChonSoK.setBounds(284, 283, 162, 26);
		jpanel_TaoKhoa.add(jtextfield_ChonSoK);
		jtextfield_ChonSoK.setColumns(10);
		
		// K PUB, K PRI
		
		JPanel jpanel_KhoaCongKhai = new JPanel();
		jpanel_KhoaCongKhai.setBounds(481, 10, 440, 176);
		jpanel_TaoKhoa.add(jpanel_KhoaCongKhai);
		jpanel_KhoaCongKhai.setLayout(null);
		jpanel_KhoaCongKhai.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel jlabel_KhoaCongKhai = new JLabel("Khóa công khai", SwingConstants.CENTER);
		jlabel_KhoaCongKhai.setFont(new Font("ARIAL", Font.BOLD, 19));
		jlabel_KhoaCongKhai.setBounds(158, 10, 157, 34);
		jpanel_KhoaCongKhai.add(jlabel_KhoaCongKhai);
		
		JLabel jlabel_SoP = new JLabel("Số P", SwingConstants.CENTER);
		jlabel_SoP.setFont(font);
		jlabel_SoP.setBounds(47, 84, 45, 19);
		jpanel_KhoaCongKhai.add(jlabel_SoP);
		
		JLabel jlabel_SoAlpha = new JLabel("Số Alpha", SwingConstants.CENTER);
		jlabel_SoAlpha.setFont(font);
		jlabel_SoAlpha.setBounds(175, 84, 89, 19);
		jpanel_KhoaCongKhai.add(jlabel_SoAlpha);
		
		JLabel jlabel_SoBeta = new JLabel("Số Beta", SwingConstants.CENTER);
		jlabel_SoBeta.setFont(font);
		jlabel_SoBeta.setBounds(326, 84, 79, 19);
		jpanel_KhoaCongKhai.add(jlabel_SoBeta);
		
		jtextfield_SoP = new JTextField();
		jtextfield_SoP.setFont(font);
		jtextfield_SoP.setBounds(10, 113, 126, 38);
		jpanel_KhoaCongKhai.add(jtextfield_SoP);
		jtextfield_SoP.setColumns(10);
		
		jtextfield_SoAlpha = new JTextField();
		jtextfield_SoAlpha.setFont(font);
		jtextfield_SoAlpha.setColumns(10);
		jtextfield_SoAlpha.setBounds(158, 113, 126, 38);
		jpanel_KhoaCongKhai.add(jtextfield_SoAlpha);
		
		jtextfield_SoBeta = new JTextField();
		jtextfield_SoBeta.setFont(font);
		jtextfield_SoBeta.setColumns(10);
		jtextfield_SoBeta.setBounds(304, 113, 126, 38);
		jpanel_KhoaCongKhai.add(jtextfield_SoBeta);
		
		JPanel jpanel_KhoaBiMat = new JPanel();
		jpanel_KhoaBiMat.setBounds(481, 250, 440, 176);
		jpanel_TaoKhoa.add(jpanel_KhoaBiMat);
		jpanel_KhoaBiMat.setLayout(null);
		
		JLabel jlabel_KhoaBiMat = new JLabel("Khóa bí mật", SwingConstants.CENTER);
		jlabel_KhoaBiMat.setFont(new Font("ARIAL", Font.BOLD, 19));
		jlabel_KhoaBiMat.setBounds(151, 10, 138, 30);
		jpanel_KhoaBiMat.add(jlabel_KhoaBiMat);
		jpanel_KhoaBiMat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel jlabel_SoA = new JLabel("Số A", SwingConstants.CENTER);
		jlabel_SoA.setFont(font);
		jlabel_SoA.setBounds(189, 79, 53, 25);
		jpanel_KhoaBiMat.add(jlabel_SoA);
		
		jtextfield_SoA = new JTextField();
		jtextfield_SoA.setFont(font);
		jtextfield_SoA.setBounds(151, 114, 138, 38);
		jpanel_KhoaBiMat.add(jtextfield_SoA);
		jtextfield_SoA.setColumns(10);
		
		JButton jbutton_TaoKhoa = new JButton("Tạo khóa");
		jbutton_TaoKhoa.setForeground(Color.BLACK);
		jbutton_TaoKhoa.setBackground(Color.GRAY.brighter());
		jbutton_TaoKhoa.setOpaque(true);
		jbutton_TaoKhoa.setBorderPainted(false);
		jbutton_TaoKhoa.setFont(font);
		jbutton_TaoKhoa.setBounds(35, 366, 123, 33);
		jpanel_TaoKhoa.add(jbutton_TaoKhoa);
		jbutton_TaoKhoa.addActionListener(ac);
		
		JButton jbutton_TaoKhoaNgauNhien = new JButton("Tạo khóa ngẫu nhiên");
		jbutton_TaoKhoaNgauNhien.setForeground(Color.BLACK);
		jbutton_TaoKhoaNgauNhien.setBackground(Color.GRAY.brighter());
		jbutton_TaoKhoaNgauNhien.setOpaque(true);
		jbutton_TaoKhoaNgauNhien.setBorderPainted(false);
		jbutton_TaoKhoaNgauNhien.setFont(font);
		jbutton_TaoKhoaNgauNhien.setBounds(245, 366, 201, 33);
		jpanel_TaoKhoa.add(jbutton_TaoKhoaNgauNhien);
		jbutton_TaoKhoaNgauNhien.addActionListener(ac);
		
		// Tab Signature
		
		JPanel jpanel_ChuKy = new JPanel();
		tabbedPane.addTab("Chữ Ký\r\n", jpanel_ChuKy);
		jpanel_ChuKy.setLayout(null);
		
		JPanel jpanel_PhatSinhChuKy = new JPanel();
		jpanel_PhatSinhChuKy.setBounds(10, 10, 420, 416);
		jpanel_PhatSinhChuKy.setLayout(null);
		jpanel_PhatSinhChuKy.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpanel_ChuKy.add(jpanel_PhatSinhChuKy);
		
		JLabel jlabel_PhatSinhChuKy = new JLabel("Phát sinh chữ ký", SwingConstants.CENTER);
		jlabel_PhatSinhChuKy.setFont(new Font("ARIAL", Font.BOLD, 19));
		jlabel_PhatSinhChuKy.setBounds(106, 10, 177, 27);
		jpanel_PhatSinhChuKy.add(jlabel_PhatSinhChuKy);
		
		JLabel jlabel_VanBanKy = new JLabel("Văn bản ký", SwingConstants.CENTER);
		jlabel_VanBanKy.setFont(font);
		jlabel_VanBanKy.setBounds(10, 75, 87, 27);
		jpanel_PhatSinhChuKy.add(jlabel_VanBanKy);
		
		JLabel jlabel_ChuKy = new JLabel("Chữ ký", SwingConstants.CENTER);
		jlabel_ChuKy.setFont(font);
		jlabel_ChuKy.setBounds(10, 254, 65, 37);
		jpanel_PhatSinhChuKy.add(jlabel_ChuKy);
		
		jtextarea_VanBanKy = new JTextArea();
        jtextarea_VanBanKy.setFont(font);
        JScrollPane scrollPaneVanBanKy = new JScrollPane(jtextarea_VanBanKy);
        scrollPaneVanBanKy.setBounds(109, 63, 206, 73);
        jpanel_PhatSinhChuKy.add(scrollPaneVanBanKy);
		
        jtextarea_ChuKy = new JTextArea();
        jtextarea_ChuKy.setFont(font);
        JScrollPane scrollPaneChuKy = new JScrollPane(jtextarea_ChuKy);
        scrollPaneChuKy.setBounds(109, 230, 206, 73);
        jpanel_PhatSinhChuKy.add(scrollPaneChuKy);
		
		JButton jbutton_File = new JButton("File");
		jbutton_File.setForeground(Color.BLACK);
		jbutton_File.setBackground(Color.BLUE.brighter());
		jbutton_File.setOpaque(true);
		jbutton_File.setBorderPainted(false);
		jbutton_File.setFont(font);
		jbutton_File.setBounds(335, 69, 75, 39);
		jpanel_PhatSinhChuKy.add(jbutton_File);
		jbutton_File.addActionListener(ac);
		
		JButton jbutton_Ky = new JButton("Ký");
		
		jbutton_Ky.setForeground(Color.BLACK);
		jbutton_Ky.setBackground(Color.BLUE.brighter());
		jbutton_Ky.setOpaque(true);
		jbutton_Ky.setBorderPainted(false);
		jbutton_Ky.setFont(font);
		jbutton_Ky.setBounds(180, 159, 65, 37);
		jpanel_PhatSinhChuKy.add(jbutton_Ky);
		jbutton_Ky.addActionListener(ac);
		
		JButton jbutton_Chuyen = new JButton("Chuyển");
		jbutton_Chuyen.setForeground(Color.BLACK);
		jbutton_Chuyen.setBackground(Color.BLUE.brighter());
		jbutton_Chuyen.setOpaque(true);
		jbutton_Chuyen.setBorderPainted(false);
		jbutton_Chuyen.setFont(font);
		jbutton_Chuyen.setBounds(164, 330, 102, 37);
		jpanel_PhatSinhChuKy.add(jbutton_Chuyen);
		jbutton_Chuyen.addActionListener(ac);
		
		JButton jbutton_Luu = new JButton("Lưu");
		jbutton_Luu.setForeground(Color.BLACK);
		jbutton_Luu.setBackground(Color.BLUE.brighter());
		jbutton_Luu.setOpaque(true);
		jbutton_Luu.setBorderPainted(false);
		jbutton_Luu.setFont(font);
		jbutton_Luu.setBounds(335, 252, 75, 40);
		jpanel_PhatSinhChuKy.add(jbutton_Luu);
		jbutton_Luu.addActionListener(ac);
		
		// Check Signature panel
		
		JPanel jpanel_KiemTraChuKy = new JPanel();
		jpanel_KiemTraChuKy.setBounds(440, 10, 481, 416);
		jpanel_KiemTraChuKy.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpanel_KiemTraChuKy.setLayout(null);
		jpanel_ChuKy.add(jpanel_KiemTraChuKy);
		
		JLabel jlabel_KiemTraChuKy = new JLabel("Kiểm tra chữ ký", SwingConstants.CENTER);
		jlabel_KiemTraChuKy.setFont(new Font("ARIAL", Font.BOLD, 19));
		jlabel_KiemTraChuKy.setBounds(141, 10, 157, 28);
		jpanel_KiemTraChuKy.add(jlabel_KiemTraChuKy);
		
		JLabel jlabel_VanBanKy_Check = new JLabel("Văn bản ký", SwingConstants.CENTER);
		jlabel_VanBanKy_Check.setFont(font);
		jlabel_VanBanKy_Check.setBounds(0, 94, 103, 46);
		jpanel_KiemTraChuKy.add(jlabel_VanBanKy_Check);
		
		
		JLabel jlabel_ChuKy_Check = new JLabel("Chữ ký", SwingConstants.CENTER);
		jlabel_ChuKy_Check.setFont(font);
		jlabel_ChuKy_Check.setBounds(0, 206, 65, 37);
		jpanel_KiemTraChuKy.add(jlabel_ChuKy_Check);
		
		jtextarea_VanBanKy_Check = new JTextArea();
		jtextarea_VanBanKy_Check.setFont(font);
		JScrollPane scrollPane_VanBanKy_Check = new JScrollPane(jtextarea_VanBanKy_Check);
		scrollPane_VanBanKy_Check.setBounds(113, 84, 203, 67);
		jpanel_KiemTraChuKy.add(scrollPane_VanBanKy_Check);
		
		jtextarea_ChuKy_Check = new JTextArea();
		jtextarea_ChuKy_Check.setFont(font);
		JScrollPane scrollPane_ChuKy_Check = new JScrollPane(jtextarea_ChuKy_Check);
		scrollPane_ChuKy_Check.setBounds(113, 194, 203, 67);
		jpanel_KiemTraChuKy.add(scrollPane_ChuKy_Check);
		
		JButton jbutton_FileChuKy = new JButton("File chữ ký");
		jbutton_FileChuKy.setForeground(Color.BLACK);
		jbutton_FileChuKy.setBackground(Color.BLUE.brighter());
		jbutton_FileChuKy.setOpaque(true);
		jbutton_FileChuKy.setBorderPainted(false);
		jbutton_FileChuKy.setFont(font);
		jbutton_FileChuKy.setBounds(338, 206, 133, 37);
		jpanel_KiemTraChuKy.add(jbutton_FileChuKy);
		jbutton_FileChuKy.addActionListener(ac);
		
		JLabel jlabel_ThongBao = new JLabel("Thông báo", SwingConstants.CENTER);
		jlabel_ThongBao.setFont(font);
		jlabel_ThongBao.setBounds(0, 348, 85, 46);
		jpanel_KiemTraChuKy.add(jlabel_ThongBao);
		
		jtextarea_ThongBao = new JTextArea();
		jtextarea_ThongBao.setFont(font);
		jtextarea_ThongBao.setBounds(113, 348, 185, 46);
		jpanel_KiemTraChuKy.add(jtextarea_ThongBao);
		
		JButton jbutton_KiemTraChuKy = new JButton("Kiểm tra chữ ký");
		jbutton_KiemTraChuKy.setForeground(Color.BLACK);
		jbutton_KiemTraChuKy.setBackground(Color.BLUE.brighter());
		jbutton_KiemTraChuKy.setOpaque(true);
		jbutton_KiemTraChuKy.setBorderPainted(false);
		jbutton_KiemTraChuKy.setFont(font);
		jbutton_KiemTraChuKy.setBounds(113, 298, 157, 37);
		jpanel_KiemTraChuKy.add(jbutton_KiemTraChuKy);
		jbutton_KiemTraChuKy.addActionListener(ac);
		
		JButton jbutton_FileVanBan = new JButton("File văn bản");
		jbutton_FileVanBan.setBounds(338, 98, 133, 39);
		jpanel_KiemTraChuKy.add(jbutton_FileVanBan);
		jbutton_FileVanBan.setForeground(Color.BLACK);
		jbutton_FileVanBan.setBackground(Color.BLUE.brighter());
		jbutton_FileVanBan.setOpaque(true);
		jbutton_FileVanBan.setBorderPainted(false);
		jbutton_FileVanBan.setFont(font);
		jbutton_FileVanBan.addActionListener(ac);
		
		this.setVisible(true);
	}
	
	public void TaoKhoa()
	{
		int SoP, SoAlpha, SoA, SoK;
		SoP = Integer.parseInt(jtextfield_ChonSoP.getText());
		SoAlpha = Integer.parseInt(jtextfield_ChonSoAlpha.getText());
		SoA = Integer.parseInt(jtextfield_ChonSoA.getText());
		SoK = Integer.parseInt(jtextfield_ChonSoK.getText());
		
		if(SNT(SoP)==0)
			JOptionPane.showMessageDialog(contentPane,"Để ý điều kiện của P!","Error",JOptionPane.ERROR_MESSAGE);
		
		if(SoA<2 || SoA>SoP-2)
			JOptionPane.showMessageDialog(contentPane,"Để ý điều kiện của A!","Error",JOptionPane.ERROR_MESSAGE);
		
		if(SoK<1 || SoK>SoP-2)
			JOptionPane.showMessageDialog(contentPane,"Để ý điều kiện của K!","Error",JOptionPane.ERROR_MESSAGE);
		
		if(ElgamalView.UCLN(SoK, SoP-1)!=1)
			JOptionPane.showMessageDialog(contentPane,"UCLN(K,P-1) phải bằng 1!","Error",JOptionPane.ERROR_MESSAGE);
		
		
		this.elgamalModel.setSoP(SoP);
		this.elgamalModel.setSoAlpha(SoAlpha);
		this.elgamalModel.setSoA(SoA);
		this.elgamalModel.setSoK(SoK);
		this.elgamalModel.setSoBeta(SoAlpha, SoA, SoP);
		this.elgamalModel.setSoGamma(SoAlpha, SoK, SoP);
		
		
		this.jtextfield_SoP.setText(this.elgamalModel.getSoP()+"");
		this.jtextfield_SoAlpha.setText(this.elgamalModel.getSoAlpha()+"");
		this.jtextfield_SoA.setText(this.elgamalModel.getSoA()+"");
		this.jtextfield_ChonSoK.setText(this.elgamalModel.getSoK()+"");
		this.jtextfield_SoBeta.setText(this.elgamalModel.getSoBeta()+"");
		this.jtextfield_SoGamma.setText(this.elgamalModel.getSoGamma()+"");
	}
	
	public String convertByteToHex(byte[] data) 
	{
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) 
        {
        	sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
	}
	
	public String SHA_256Hash(String input) 
	{
		try 
		{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] messageDigest = md.digest(input.getBytes());
	        return convertByteToHex(messageDigest);
	    } 
		catch (NoSuchAlgorithmException e) 
		{
			throw new RuntimeException(e);
		}
	}
	
//    public String SHA_1Hash(String input){
//        try
//        {
//        	MessageDigest md = MessageDigest.getInstance("SHA-1");
//            byte[] hashBytes = md.digest(input.getBytes());
//            StringBuilder sb = new StringBuilder();
//            for (byte b : hashBytes) {
//                sb.append(String.format("%02x", b));
//            }
//            return sb.toString();
//        }
//        catch (NoSuchAlgorithmException e)
//        {
//        	throw new RuntimeException(e);
//        }
//    }
    
	public void Ky()
	{
		String banRo = jtextarea_VanBanKy.getText();
		int SoP, SoA, SoK, SoGamma;
		SoP = Integer.parseInt(jtextfield_SoP.getText());
		SoA = Integer.parseInt(jtextfield_SoA.getText());
		SoK = Integer.parseInt(jtextfield_ChonSoK.getText());
		SoGamma = Integer.parseInt(jtextfield_SoGamma.getText());
		int SoPTru1 = SoP - 1;
		BigInteger SoPTru1BigInt = new BigInteger(""+SoPTru1);
		long KMuTru1ModP = EuclidMoRong(SoK, SoPTru1);
		BigInteger KMuTru1ModPBigInt = new BigInteger(""+KMuTru1ModP);
		long ANhanGamma = SoA*SoGamma;
		BigInteger ANhanGammaBigInt = new BigInteger(""+ANhanGamma);
		
		String bam = SHA_256Hash(banRo);
		BigInteger value_1 = new BigInteger(bam, 16);
		BigInteger value_2 = value_1.subtract(ANhanGammaBigInt); 
		BigInteger value_3 = value_2.mod(SoPTru1BigInt); 
		BigInteger value_4 = value_3.multiply(KMuTru1ModPBigInt); 
		BigInteger value_5 = value_4.mod(SoPTru1BigInt);
		jtextarea_ChuKy.setText((jtextfield_SoGamma.getText() + " " + value_5.toString()));
	}
	
	public void Chuyen()
	{
		this.elgamalModel.setBanRo(jtextarea_VanBanKy.getText());
		this.jtextarea_VanBanKy_Check.setText(this.elgamalModel.getBanRo()+"");
		this.elgamalModel.setBanMa(jtextarea_ChuKy.getText());
		this.jtextarea_ChuKy_Check.setText(this.elgamalModel.getBanMa()+"");
	}
	
	public void KiemTra()
	{
		String banRo = jtextarea_VanBanKy_Check.getText();
		String bam = SHA_256Hash(banRo);
		BigInteger s = new BigInteger(bam, 16);
		BigInteger SoAlpha1 =new BigInteger(jtextfield_SoAlpha.getText());
        BigInteger SoP1 =new BigInteger(jtextfield_SoP.getText());
        BigInteger kq1 = SoAlpha1.modPow(s, SoP1);
        BigInteger SoBeta =new BigInteger(jtextfield_SoBeta.getText());
        int index=0;
        for(int i=0;i<jtextarea_ChuKy_Check.getText().length();i++)
        {
        	if(jtextarea_ChuKy_Check.getText().charAt(i) == ' ') index = i;
        }
        BigInteger SoGamma1 = new BigInteger(jtextarea_ChuKy_Check.getText().substring(0,index));
        int SoGamma2 = Integer.parseInt(jtextarea_ChuKy_Check.getText().substring(0,index));
        int ck = Integer.parseInt(jtextarea_ChuKy_Check.getText().substring(index+1));
	    BigInteger pow1 = SoGamma1.pow(ck);
	    BigInteger pow2 = SoBeta.pow(SoGamma2);
        BigInteger pow3= pow2.multiply(pow1);
        BigInteger kq2= pow3.mod(SoP1);
        
        if(kq1.compareTo(kq2)==0)
        {
        	jtextarea_ThongBao.setText("Chữ ký đúng"+"");
        }
        else 
        {
        	jtextarea_ThongBao.setText("Chữ ký sai"+"");
        }
	}
	
	public static int SNT(int n)
	{
		if(n<2) return 0;
		for(int i=2;i*i<=n;i++)
		{
			if(n%i==0) return 0;
		}
		return 1;
	}
	
	public static int UCLN(int a, int b) 
	{
        if(b==0) return a;
        return UCLN(b, a % b);
	}
	
	public long EuclidMoRong(int coSo, int soChiaDu)
	{
		int m0 = soChiaDu;
		int y = 0, x = 1;
		if(soChiaDu == 1) 
			return 0;
		while(coSo > 1)
		{
			int q = coSo / soChiaDu;
			int t = soChiaDu;
			soChiaDu = coSo % soChiaDu;
			coSo = t;
			t = y;
			y = x-q*y;
			x = t;
		}
		if(x<0)
			x+=m0;
		return x;
	}
	
	public void TaoKhoaNgauNhien()
	{
		int SoP, SoAlpha, SoA, SoK;
		Random ranDom = new Random();
		
		int min = 10000;
        long max = 20000;
        SoP = min + (int) (ranDom.nextDouble() * (max - min));;
        while(SNT(SoP)==0)
        {
        	SoP = min + (int) (ranDom.nextDouble() * (max - min));
        }
        
        int min1 = 2;
        int max1 = SoP-2;
		SoA = min1 + (int) (ranDom.nextDouble() * (max1 - min1));
		
		SoAlpha = min + (int) (ranDom.nextDouble() * (max - min));
		
		int min2 = 1;
        int max2 = SoP-2;
		SoK = min2 + (int) (ranDom.nextDouble() * (max2 - min2));
		while(UCLN(SoP-1,SoK)!=1)
        {
			SoK = min2 + (int) (ranDom.nextDouble() * (max2 - min2));
        }
		
		this.elgamalModel.setSoP(SoP);
		this.elgamalModel.setSoAlpha(SoAlpha);
		this.elgamalModel.setSoA(SoA);
		this.elgamalModel.setSoK(SoK);
		this.elgamalModel.setSoBeta(SoAlpha, SoA, SoP);
		this.elgamalModel.setSoGamma(SoAlpha, SoK, SoP);
		
		this.jtextfield_ChonSoP.setText(this.elgamalModel.getSoP()+"");
		this.jtextfield_SoP.setText(this.elgamalModel.getSoP()+"");
		this.jtextfield_ChonSoAlpha.setText(this.elgamalModel.getSoAlpha()+"");
		this.jtextfield_SoAlpha.setText(this.elgamalModel.getSoAlpha()+"");
		this.jtextfield_ChonSoA.setText(this.elgamalModel.getSoA()+"");
		this.jtextfield_SoA.setText(this.elgamalModel.getSoA()+"");
		this.jtextfield_ChonSoK.setText(this.elgamalModel.getSoK()+"");
		this.jtextfield_SoBeta.setText(this.elgamalModel.getSoBeta()+"");
		this.jtextfield_SoGamma.setText(this.elgamalModel.getSoGamma()+"");
	}
	
	public void File()
	{
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			File file = fc.getSelectedFile();
			String fileName = file.getName();
			this.elgamalModel.setFileName(file.getAbsolutePath());
			if(fileName.endsWith(".txt")) 
			{
				try 
				{
					List<String> allText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
					String result = "";
					for (String line : allText) 
					{
						result+=line;
						result+="\n";
					}
					this.elgamalModel.setContent(result);
					this.jtextarea_VanBanKy.setText(this.elgamalModel.getContent());;
				} 
				catch(Exception e1) 
				{
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void FileVanBan()
	{
		JFileChooser fc = new JFileChooser(); // Swing component to choose file
		int returnVal = fc.showOpenDialog(this); // Show dialog to choose file
		if (returnVal == JFileChooser.APPROVE_OPTION) // Condition checks if the user has selected a file 
		{
			File file = fc.getSelectedFile(); // Get file
			String fileName = file.getName(); 
			this.elgamalModel.setFileName(file.getAbsolutePath()); // Get file name
			if(fileName.endsWith(".txt")) 
			{
				try 
				{
					List<String> allText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
					String result = "";
					for (String line : allText) 
					{
						result+=line;
						result+="\n";
					}
					this.elgamalModel.setContent(result);
					this.jtextarea_VanBanKy_Check.setText(this.elgamalModel.getContent());;
				} 
				catch(Exception e1) 
				{
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void FileChuKy()
	{
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			File file = fc.getSelectedFile();
			String fileName = file.getName();
			this.elgamalModel.setFileName(file.getAbsolutePath());
			if(fileName.endsWith(".txt")) 
			{
				try 
				{
					List<String> allText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
					String result = "";
					for (String line : allText) 
					{
						result+=line;
					}
					this.elgamalModel.setContent(result);
					this.jtextarea_ChuKy_Check.setText(this.elgamalModel.getContent());;
				} 
				catch(Exception e1) 
				{
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void Save(String fileName)
	{
		try 
		{
			PrintWriter pw = new PrintWriter(fileName, "UTF-8"); // the class to write doc to file
			String data = this.jtextarea_ChuKy.getText();
			pw.print(data); // Write content to file
			pw.flush(); // 
			pw.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	}
	
	public void Luu()
	{
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			File file = fc.getSelectedFile();
			Save(file.getAbsolutePath());
		}
	}
}
