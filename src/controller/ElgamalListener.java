package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ElgamalView;

public class ElgamalListener implements ActionListener
{
	ElgamalView elgamalView;
	
	public ElgamalListener(ElgamalView elgamalView) 
	{
		this.elgamalView = elgamalView;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String button = e.getActionCommand();
		
		if(button.equals("Tạo khóa"))
		{
			this.elgamalView.TaoKhoa();
		}
		else if(button.equals("Ký"))
		{
			this.elgamalView.Ky();
		}
		else if(button.equals("Chuyển"))
		{
			this.elgamalView.Chuyen();
		}
		else if(button.equals("Tạo khóa ngẫu nhiên"))
		{
			this.elgamalView.TaoKhoaNgauNhien();
		}
		else if(button.equals("File"))
		{
			this.elgamalView.File();
		}
		else if(button.equals("File văn bản"))
		{
			this.elgamalView.FileVanBan();
		}
		else if(button.equals("File chữ ký"))
		{
			this.elgamalView.FileChuKy();
		}
		else if(button.equals("Lưu"))
		{
			this.elgamalView.Luu();
		}
		else if(button.equals("Kiểm tra chữ ký"))
		{
			this.elgamalView.KiemTra();
		}
	}
}
