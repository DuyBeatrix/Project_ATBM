package model;

public class ElgamalModel 
{
	private int soP, soAlpha, soA, soBeta, soK, soGamma, soDelta;
	private String banRo, banMa;
	private String fileName, content;

	public ElgamalModel() {
	}
	
	public int getSoP() {
		return soP;
	}
	public void setSoP(int soP) {
		this.soP = soP;
	}
	public int getSoAlpha() {
		return soAlpha;
	}
	public void setSoAlpha(int soAlpha) {
		this.soAlpha = soAlpha;
	}
	public int getSoA() {
		return soA;
	}
	public void setSoA(int soA) {
		this.soA = soA;
	}
	public int getSoBeta() {
		return soBeta;
	}
	public void setSoBeta(int soAlpha, int soA, int soP) {
		this.soBeta = BinhPhuongVaNhan(soAlpha, soA, soP);
	}
	public int getSoK() {
		return soK;
	}
	public void setSoK(int soK) {
		this.soK = soK;
	}
	public String getBanRo() {
		return banRo;
	}
	public void setBanRo(String banRo) {
		this.banRo = banRo;
	}
	public int getSoGamma() {
		return soGamma;
	}
	public void setSoGamma(int soAlpha, int soK, int soP) {
		this.soGamma = BinhPhuongVaNhan(soAlpha, soK, soP);
	}
	public int getSoDelta() {
		return soDelta;
	}
	public void setSoDelta(int soDelta) {
		this.soDelta = soDelta;
	}
	public String getBanMa() {
		return banMa;
	}
	public void setBanMa(String banMa) {
		this.banMa = banMa;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public static int BinhPhuongVaNhan(int coSo, int soMu, int soChiaDu) {
	    if (soMu == 0) 
	        return 1;
	    if (soMu == 1)
	        return coSo % soChiaDu;
	    int p = BinhPhuongVaNhan(coSo, soMu / 2, soChiaDu);
	    int result = (p * p) % soChiaDu;
	    if (result < 0)
	        result += soChiaDu;
	    if (soMu % 2 != 0)
	        result = (result * coSo) % soChiaDu;
	    return result;
	}
}
