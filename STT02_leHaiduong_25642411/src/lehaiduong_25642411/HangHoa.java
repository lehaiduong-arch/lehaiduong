package lehaiduong_25642411;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangHoa {
	private String maHang;
	private String tenHang;
	private String hangSX;
	private double giaBan;
	private float soLuongTon;
	private LocalDate ngayNhapHang;

	public HangHoa(String maHang, String tenHang, String hangSX, double giaBan, float soLuongTon, LocalDate ngayNhapHang) {
		setMaHang(maHang);
		setTenHang(tenHang);
		setHangSX(hangSX);
		setGiaBan(giaBan);
		setSoLuongTon(soLuongTon);
		setNgayNhapHang(ngayNhapHang);
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		if (maHang == null || maHang.trim().isEmpty())
			throw new RuntimeException("Ma Hang khong duoc rong !");
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if (tenHang == null || tenHang.trim().isEmpty())
			throw new RuntimeException("Ten Hang khong duoc rong !");
		this.tenHang = tenHang;
	}

	public String getHangSX() {
		return hangSX;
	}

	public void setHangSX(String hangSX) {
		if (hangSX == null || hangSX.trim().isEmpty())
			throw new RuntimeException("Hang san xuat khong duoc rong !");
		this.hangSX = hangSX;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		if (giaBan <= 0)
			throw new RuntimeException("Gia ban phai lon hon 0!");
		this.giaBan = giaBan;
	}

	public float getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(float soLuongTon) {
		if (soLuongTon < 0)
			throw new RuntimeException("So luong ton phai lon hon hoac = 0!");
		this.soLuongTon = soLuongTon;
	}

	public LocalDate getNgayNhapHang() {
		return ngayNhapHang;
	}

	public void setNgayNhapHang(LocalDate ngayNhapHang) {
		if (ngayNhapHang == null || ngayNhapHang.isAfter(LocalDate.now()))
			throw new RuntimeException("Ngay nhap hang phai truoc hoac bang ngay hien tai !");
		this.ngayNhapHang = ngayNhapHang;
	}

	public double tinhTongGiaTri() {
		return giaBan * soLuongTon;
	}

	@Override
	public String toString() {
		return String.format("%-8s %-12s %-8s %8.2f %8.2f %-10s %10.2f",
				maHang, tenHang, hangSX, giaBan, soLuongTon,
				ngayNhapHang.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				tinhTongGiaTri());
	}
}
