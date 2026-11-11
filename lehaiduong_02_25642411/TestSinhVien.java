package lehaiduong_02_25642411;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TestSinhVien {
    public static void main(String[] args) {
        System.out.println("===== DANH SACH MON HOC (ENUM) =====");
        for (MonHoc mh : MonHoc.values()) {
            System.out.println("  - " + mh);
        }
        System.out.println();

        ListSinhVien ql = new ListSinhVien();

        ql.them(new SinhVienChinhQui("SV01", "Nguyen Van An", LocalDate.of(2003, 5, 10),
                "21DTH01", 3, MonHoc.LAP_TRINH_JAVA, "Co so 1"));
        ql.them(new SinhVienChinhQui("SV02", "Tran Thi Binh", LocalDate.of(2003, 8, 20),
                "21DTH01", 4, MonHoc.CO_SO_DU_LIEU, "Co so 2"));
        ql.them(new SinhVienChinhQui("SV03", "Le Hoang Cuong", LocalDate.of(2003, 5, 10),
                "21DTH02", 3, MonHoc.LAP_TRINH_JAVA, "Co so 3"));

        ql.them(new SinhVienTuXa("SV04", "Pham Thu Duyen", LocalDate.of(2004, 1, 15),
                "21DTH02", 2, MonHoc.TOAN_ROI_RAC, "Zoom"));
        ql.them(new SinhVienTuXa("SV05", "Hoang Van Em", LocalDate.of(2003, 8, 20),
                "21DTH01", 3, MonHoc.LAP_TRINH_JAVA, "Microsoft Teams"));
        ql.them(new SinhVienTuXa("SV06", "Ly Minh Quan", LocalDate.of(2003, 3, 5),
                "21DTH02", 3, MonHoc.MANG_MAY_TINH, "Google Meet"));

        ql.them(new SinhVien("SV07", "Do Thu Ha", LocalDate.of(2004, 7, 12),
                "21DTH01", 3, MonHoc.TRI_TUE_NHAN_TAO));

        System.out.println("===== DANH SACH SINH VIEN (DA HINH) =====");
        ql.layTatCa().forEach(System.out::println);

        System.out.println("\n===== DEMO DA HINH (POLYMORPHISM) =====");
        ql.layTatCa().forEach(sv ->
                System.out.printf("%-8s | Loai: %-10s | Thanh tien: %,.0f VND | %s%n",
                        sv.getMaSV(), sv.getLoai(), sv.thanhTien(), sv.getThongTinRieng()));

        System.out.println("\n===== 1. GOM NHOM THEO LOP =====");
        Map<String, List<SinhVien>> theoLop = ql.nhomTheo(SinhVien::getLop);
        theoLop.forEach((lop, ds) -> {
            System.out.println("Lop: " + lop + " (" + ds.size() + " SV)");
            ds.forEach(sv -> System.out.println("   -> " + sv));
        });

        System.out.println("\n===== 2. GOM NHOM THEO LOAI =====");
        Map<String, List<SinhVien>> theoLoai = ql.nhomTheo(SinhVien::getLoai);
        theoLoai.forEach((loai, ds) -> {
            System.out.println("Loai: " + loai + " (" + ds.size() + " SV)");
            ds.forEach(sv -> System.out.println("   -> " + sv.getHoTen()));
        });

        System.out.println("\n===== 3. TONG THANH TIEN THEO LOP =====");
        Map<String, Double> sumLop = ql.tongTheoNhom(SinhVien::getLop, SinhVien::thanhTien);
        sumLop.forEach((lop, sum) ->
                System.out.printf("Lop %-10s : Tong = %,.0f VND%n", lop, sum));

        System.out.println("\n===== 4. TONG THANH TIEN THEO MON =====");
        Map<MonHoc, Double> sumMon = ql.tongTheoNhom(SinhVien::getMonHoc, SinhVien::thanhTien);
        sumMon.forEach((mon, sum) ->
                System.out.printf("%-25s : %,.0f VND%n", mon.getTenMon(), sum));

        System.out.println("\n===== 5. TONG THANH TIEN THEO LOAI =====");
        Map<String, Double> sumLoai = ql.tongTheoNhom(SinhVien::getLoai, SinhVien::thanhTien);
        sumLoai.forEach((loai, sum) ->
                System.out.printf("Loai %-12s : %,.0f VND%n", loai, sum));

        System.out.println("\n===== 6. DEM SO LUOT THEO MON =====");
        Map<MonHoc, Integer> demMon = ql.demTheoNhom(SinhVien::getMonHoc);
        demMon.forEach((mon, count) ->
                System.out.printf("%-25s -> %d sinh vien%n", mon.getTenMon(), count));

        System.out.println("\n===== 7. LOC SINH VIEN CHINH QUY =====");
        List<SinhVien> dsChinhQui = ql.tim(sv -> sv instanceof SinhVienChinhQui);
        dsChinhQui.forEach(sv -> System.out.println("  " + sv));

        System.out.println("\n===== 8. LOC SINH VIEN TU XA =====");
        List<SinhVien> dsTuXa = ql.tim(sv -> sv instanceof SinhVienTuXa);
        dsTuXa.forEach(sv -> System.out.println("  " + sv));

        System.out.println("\n===== 9. SAP XEP THEO THANH TIEN GIAM DAN =====");
        ql.sapXepGiamDan(Comparator.comparingDouble(SinhVien::thanhTien));
        ql.layTatCa().forEach(sv -> System.out.println("  " + sv));

        System.out.println("\n===== 10. TIM MON HOC THEO TEN =====");
        MonHoc timThay = MonHoc.fromTenMon("Mang may tinh");
        if (timThay != null) {
            System.out.println("Da tim thay: " + timThay);
        } else {
            System.out.println("Khong tim thay mon hoc!");
        }

        System.out.println("\n===== 11. HAVING: TONG THEO LOP >= 1,500,000 =====");
        Map<String, Double> havingLop = ql.tongTheoNhom_Having(
                SinhVien::getLop, SinhVien::thanhTien, 1_500_000);
        if (havingLop.isEmpty()) System.out.println("  (Khong co nhom nao thoa)");
        else havingLop.forEach((lop, sum) ->
                System.out.printf("  Lop %-10s : %,.0f VND%n", lop, sum));

        System.out.println("\n===== 12. HAVING: MON CO >= 2 SV =====");
        Map<MonHoc, Integer> havingDemMon = ql.demTheoNhom_Having(SinhVien::getMonHoc, 2);
        if (havingDemMon.isEmpty()) System.out.println("  (Khong co nhom nao thoa)");
        else havingDemMon.forEach((mon, dem) ->
                System.out.printf("  %-25s : %d SV%n", mon.getTenMon(), dem));
    }
}
