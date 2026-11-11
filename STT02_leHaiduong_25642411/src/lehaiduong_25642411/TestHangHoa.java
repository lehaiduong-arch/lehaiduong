package lehaiduong_25642411;

import java.time.LocalDate;

public class TestHangHoa {
	public static void main(String args[]) {
		try {
			System.out.println("=== Danh sach HANG HOA ===");
			QuanLyHangHoa ds = new QuanLyHangHoa(6);

			ds.them(new HangHoa("MH01", "Banh", "Orion", 10000.00, 10, LocalDate.of(2026, 10, 10)));
			ds.them(new HangHoa("MH02", "keo", "Orion", 10000.00, 10, LocalDate.of(2026, 10, 10)));
			ds.them(new HangHoa("MH03", "B", "Orion", 10000.00, 10, LocalDate.of(2026, 10, 10)));
			ds.them(new HangHoa("MH04", "Banh", "Orion", 10000.00, 10, LocalDate.of(2026, 10, 10)));
			ds.them(new HangHoa("MH05", "Banh", "Orion", 10000.00, 10, LocalDate.of(2026, 10, 10)));

			for (int i = 0; i < ds.getSoLuong(); i++)
				System.out.println(ds.getHangHoa(i));
		} catch (RuntimeException e) {
			System.out.println("Loi: " + e.getMessage());
		}
	}
}
