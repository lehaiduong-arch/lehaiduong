package lehaiduong_25642411;

import java.util.Arrays;

public class QuanLyHangHoa {
	private HangHoa[] danhSach;
	private int soLuong;

	public QuanLyHangHoa(int sucChua) {
		if (sucChua <= 0)
			throw new RuntimeException("Suc chua phai lon hon 0!");
		danhSach = new HangHoa[sucChua];
		soLuong = 0;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public int getSucChua() {
		return danhSach.length;
	}

	public HangHoa getHangHoa(int viTri) {
		if (viTri < 0 || viTri >= soLuong)
			throw new RuntimeException("Vi tri khong hop le!");
		return danhSach[viTri];
	}

	private int timViTri(String maHang) {
		for (int i = 0; i < soLuong; i++) {
			if (danhSach[i].getMaHang().equalsIgnoreCase(maHang))
				return i;
		}
		return -1;
	}

	private boolean kiemTraTrungMa(String maHang) {
		return timViTri(maHang) != -1;
	}

	public void them(HangHoa hh) {
		if (hh == null)
			throw new RuntimeException("Hang hoa khong hop le!");
		if (kiemTraTrungMa(hh.getMaHang()))
			throw new RuntimeException("Ma hang hoa da ton tai !");
		if (soLuong >= danhSach.length) {
			int sucChuaMoi = (int) Math.ceil(danhSach.length * 1.75);
			danhSach = Arrays.copyOf(danhSach, sucChuaMoi);
		}
		danhSach[soLuong] = hh;
		soLuong++;
	}

	public void xoa(HangHoa hh) {
		if (hh == null)
			throw new RuntimeException("Hang hoa khong hop le!");
		int viTri = timViTri(hh.getMaHang());
		if (viTri == -1)
			throw new RuntimeException("Khong tim thay hang hoa can xoa!");
		for (int i = viTri; i < soLuong - 1; i++)
			danhSach[i] = danhSach[i + 1];
		danhSach[soLuong - 1] = null;
		soLuong--;
	}
}
