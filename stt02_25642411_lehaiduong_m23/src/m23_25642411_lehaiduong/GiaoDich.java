package m23_25642411_lehaiduong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class GiaoDich{
	protected String maGiaoDich;
	protected LocalDate ngayGiaoDich;
	protected double donGia;
	protected double dienTich;
	
	
	
	public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich) {
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}
	
	public abstract double thanhTien();

	public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("ma:%-6s |ngay : %s | don gia : %,.0f | DT : %.1f | thanh tien : %,.0f",
								maGiaoDich,ngayGiaoDich.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
								,donGia,dienTich,thanhTien());
	}
	

}

