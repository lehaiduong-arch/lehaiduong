package quanlycd;

public class CDlist {
    private CD[] danhSachCD;
    private int soLuong;
    private int khaNang;

    private static final int KICH_THUOC_BAN_DAU = 5;

    public CDlist() {
        this.khaNang = KICH_THUOC_BAN_DAU;
        this.danhSachCD = new CD[khaNang];
        this.soLuong = 0;
    }

    public CDlist(int n) {
        this.khaNang = (n <= 0) ? KICH_THUOC_BAN_DAU : n;
        this.danhSachCD = new CD[khaNang];
        this.soLuong = 0;
    }

    public int laySoLuong() {
        return soLuong;
    }

    public CD layCDTaiViTri(int i) {
        if (i < 0 || i >= soLuong) return null;
        return danhSachCD[i];
    }

    private void moRongMang() {
        int kichThuocMoi = khaNang * 2;
        CD[] mangMoi = new CD[kichThuocMoi];
        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = danhSachCD[i];
        }
        danhSachCD = mangMoi;
        khaNang = kichThuocMoi;
        System.out.println(">> Da mo rong mang len " + khaNang + " phan tu.");
    }

    public int timViTriTheoMa(int maCD) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSachCD[i].getMaCD() == maCD) {
                return i;
            }
        }
        return -1;
    }

    public boolean themCD(CD cd) {
        if (timViTriTheoMa(cd.getMaCD()) != -1) {
            System.out.println("X Loi: Ma CD " + cd.getMaCD() + " da ton tai!");
            return false;
        }
        if (soLuong == khaNang) {
            moRongMang();
        }
        danhSachCD[soLuong] = cd;
        soLuong++;
        return true;
    }

    public boolean xoaCD(int maCD) {
        int viTri = timViTriTheoMa(maCD);
        if (viTri == -1) {
            System.out.println("X Khong tim thay CD ma " + maCD);
            return false;
        }
        for (int i = viTri; i < soLuong - 1; i++) {
            danhSachCD[i] = danhSachCD[i + 1];
        }
        danhSachCD[soLuong - 1] = null;
        soLuong--;
        return true;
    }

    public boolean capNhatCD(int maCD, String tuaMoi, int soBaiMoi, double giaMoi) {
        int viTri = timViTriTheoMa(maCD);
        if (viTri == -1) {
            System.out.println("X Khong tim thay CD ma " + maCD);
            return false;
        }
        CD cd = danhSachCD[viTri];
        cd.setTuaCD(tuaMoi);
        cd.setSoBaiHat(soBaiMoi);
        cd.setGiaThanh(giaMoi);
        return true;
    }

    public CD timTheoMa(int maCD) {
        int viTri = timViTriTheoMa(maCD);
        return (viTri == -1) ? null : danhSachCD[viTri];
    }

    public CDlist timTheoTienTo(String tuKhoa) {
        CDlist ketQua = new CDlist();
        String tk = tuKhoa.toLowerCase();
        for (int i = 0; i < soLuong; i++) {
            if (danhSachCD[i].getTuaCD().toLowerCase().startsWith(tk)) {
                ketQua.themCD(danhSachCD[i]);
            }
        }
        return ketQua;
    }

    public CDlist timTheoHauTo(String tuKhoa) {
        CDlist ketQua = new CDlist();
        String tk = tuKhoa.toLowerCase();
        for (int i = 0; i < soLuong; i++) {
            if (danhSachCD[i].getTuaCD().toLowerCase().endsWith(tk)) {
                ketQua.themCD(danhSachCD[i]);
            }
        }
        return ketQua;
    }

    public CDlist timGanGiong(String tuKhoa) {
        CDlist ketQua = new CDlist();
        String tk = tuKhoa.toLowerCase();
        for (int i = 0; i < soLuong; i++) {
            if (danhSachCD[i].getTuaCD().toLowerCase().contains(tk)) {
                ketQua.themCD(danhSachCD[i]);
            }
        }
        return ketQua;
    }

    public int tinhSoLuongCD() {
        return soLuong;
    }

    public double tinhTongGiaThanh() {
        double tong = 0;
        for (int i = 0; i < soLuong; i++) {
            tong += danhSachCD[i].getGiaThanh();
        }
        return tong;
    }

    public double tinhGiaTrungBinh() {
        return (soLuong == 0) ? 0 : tinhTongGiaThanh() / soLuong;
    }

    public CD timCDDatNhat() {
        if (soLuong == 0) return null;
        CD max = danhSachCD[0];
        for (int i = 1; i < soLuong; i++) {
            if (danhSachCD[i].getGiaThanh() > max.getGiaThanh()) {
                max = danhSachCD[i];
            }
        }
        return max;
    }

    public CD timCDRenhNhat() {
        if (soLuong == 0) return null;
        CD min = danhSachCD[0];
        for (int i = 1; i < soLuong; i++) {
            if (danhSachCD[i].getGiaThanh() < min.getGiaThanh()) {
                min = danhSachCD[i];
            }
        }
        return min;
    }

    public void hienThiDanhSach() {
        if (soLuong == 0) {
            System.out.println("Danh sach CD trong!");
            return;
        }
        System.out.println("\n+------------+---------------------------+--------------+-----------------+");
        System.out.println("| Ma CD      | Tua CD                    | So bai hat   | Gia thanh       |");
        System.out.println("+------------+---------------------------+--------------+-----------------+");
        for (int i = 0; i < soLuong; i++) {
            System.out.println(danhSachCD[i]);
        }
        System.out.println("+------------+---------------------------+--------------+-----------------+");
    }

    public void sapXepGiamDanTheoGia() {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                if (danhSachCD[i].getGiaThanh() < danhSachCD[j].getGiaThanh()) {
                    CD temp = danhSachCD[i];
                    danhSachCD[i] = danhSachCD[j];
                    danhSachCD[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep giam dan theo gia thanh.");
    }

    public void sapXepTangDanTheoTua() {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                if (danhSachCD[i].getTuaCD().compareToIgnoreCase(danhSachCD[j].getTuaCD()) > 0) {
                    CD temp = danhSachCD[i];
                    danhSachCD[i] = danhSachCD[j];
                    danhSachCD[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep tang dan theo tua CD.");
    }
}