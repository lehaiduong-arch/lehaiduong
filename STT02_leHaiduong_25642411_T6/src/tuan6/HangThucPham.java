package tuan6;

import java.time.LocalDate;

public class HangThucPham implements Comparable<HangThucPham> {
	private int id;
	private final String maHang;
	private String tenHang;
	private LocalDate ngaySX;
	private LocalDate ngayHH;
	private float gia;
	private static int demSoLuong = 0;

	public HangThucPham() {
		this.id = ++demSoLuong;
		this.maHang = "MAC_DINH";
		this.tenHang = "Hang_mac_dinh";
		this.ngaySX = LocalDate.now();
		this.ngayHH = LocalDate.now().plusDays(7);
		this.gia = 1.0f;
	}

	public HangThucPham(String maHang, String tenHang, LocalDate ngaySX,
						LocalDate ngayHH, float gia) {
		this.id = ++demSoLuong;
		if(maHang == null || maHang.trim().isEmpty()) {
			throw new IllegalArgumentException("Ma hang khong duoc de trong");
		}
		if(tenHang == null || tenHang.trim().isEmpty()) {
			throw new IllegalArgumentException("Ten hang khong duoc de trong");
		}
		if(gia <= 0) {
			throw new IllegalArgumentException("Gia phai lon hon 0");
		}
		if(!kiemTraNgaySanXuat(ngaySX)) {
			throw new IllegalArgumentException("Ngay san xuat khong duoc la tuong lai");
		}
		if(!kiemTraNgayHetHan(ngaySX, ngayHH)) {
			throw new IllegalArgumentException("Ngay het han phai sau ngay San xuat");
		}
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
		this.gia = gia;
	}

	private boolean kiemTraNgaySanXuat(LocalDate ngaySX) {
		return ngaySX != null && !ngaySX.isAfter(LocalDate.now());
	}

	private boolean kiemTraNgayHetHan(LocalDate ngaySX, LocalDate ngayHH) {
		return ngaySX != null && ngayHH != null && ngayHH.isAfter(ngaySX);
	}

	public int getId() { return id; }
	public String getMaHang() { return maHang; }
	public String getTenHang() { return tenHang; }
	public LocalDate getNgaySanXuat() { return ngaySX; }
	public LocalDate getNgayHetHan() { return ngayHH; }
	public float getGia() { return gia; }

	public void setTenHang(String tenHang) {
		if(tenHang == null || tenHang.trim().isEmpty()) {
			throw new IllegalArgumentException("Ten hang khong duoc rong!");
		}
		this.tenHang = tenHang;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if(!kiemTraNgaySanXuat(ngaySanXuat)) {
			throw new IllegalArgumentException("Ngay SX khong duoc tuong lai!");
		}
		if(this.ngayHH != null && !kiemTraNgayHetHan(ngaySanXuat, this.ngayHH)) {
			throw new IllegalArgumentException("Ngay SX phai truoc ngay HH!");
		}
		this.ngaySX = ngaySanXuat;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if(this.ngaySX == null) {
			throw new IllegalArgumentException("Chua co ngay SX!");
		}
		if(!kiemTraNgayHetHan(this.ngaySX, ngayHetHan)) {
			throw new IllegalArgumentException("Ngay HH phai sau ngay SX!");
		}
		this.ngayHH = ngayHetHan;
	}

	public void setGia(float gia) {
		if(gia <= 0) {
			throw new IllegalArgumentException("Gia phai lon hon 0!");
		}
		this.gia = gia;
	}

	public boolean kiemTraHetHan() {
		return LocalDate.now().isAfter(this.ngayHH);
	}

	public String trangThaiChiTiet() {
		LocalDate homNay = LocalDate.now();
		if(homNay.isBefore(ngaySX)) return "Chua san xuat";
		if(homNay.isAfter(ngayHH)) return "Het Han";
		if(homNay.isEqual(ngayHH)) return "Het han hom nay";
		long con = ngayHH.toEpochDay() - homNay.toEpochDay();
		return "Con " + con + " Ngay";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Khong the sao chep bai hang thuc pham!!");
	}

	@Override
	public int compareTo(HangThucPham o) {
		return Integer.compare(this.id, o.id);
	}

	@Override
	public String toString() {
		return String.format("| %-4d | %-10s | %-18s | %-12s | %-12s | %-10.0f",
				id, maHang, tenHang, ngaySX, ngayHH, gia);
	}
}
