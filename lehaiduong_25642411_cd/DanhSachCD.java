package Tuan4;

import java.util.Arrays;
import java.util.Comparator;

public class DanhSachCD {
    private CD[] danhSach;
    private int soLuongHienTai;
    private int kichThuocToiDa;

   
    public DanhSachCD(int kichThuocToiDa) {
        this.kichThuocToiDa = kichThuocToiDa;
        this.danhSach = new CD[kichThuocToiDa];
        this.soLuongHienTai = 0;
    }

    private void tangKT() {
        int kichThuocMoi = (kichThuocToiDa == 0) ? 1 : kichThuocToiDa * 2;
        CD[] danhSachMoi = new CD[kichThuocMoi];
        for (int i = 0; i < soLuongHienTai; i++) {
            danhSachMoi[i] = danhSach[i];
        }
        danhSach = danhSachMoi;
        kichThuocToiDa = kichThuocMoi;
    }

    public boolean themCD(CD cdMoi) {

        for (int i = 0; i < soLuongHienTai; i++) {
            if (danhSach[i].getMaCD() == cdMoi.getMaCD()) {
                System.out.println("Ma CD " + cdMoi.getMaCD() + " da ton tai!!");
                return false;
            }
        }
     
        if (soLuongHienTai >= kichThuocToiDa) {
            System.out.println("Danh sach day!! Bat dau tang kich thuoc");
            tangKT();
        }
        danhSach[soLuongHienTai] = cdMoi;
        soLuongHienTai++;
        return true;
    }

    public int soLuongCD() {
        return soLuongHienTai;
    }

    public double thanhTien() {
        double tong = 0;
        for (int i = 0; i < soLuongHienTai; i++) {
            tong += danhSach[i].getGiaThanh();
        }
        return tong;
    }

    public void sortTheoGia() {
        Arrays.sort(danhSach, 0, soLuongHienTai, new Comparator<CD>() {
            @Override
            public int compare(CD cd1, CD cd2) {
                return Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh());
            }
        });
    }

    public void sortTheoTua() {
        Arrays.sort(danhSach, 0, soLuongHienTai, new Comparator<CD>() {
            @Override
            public int compare(CD cd1, CD cd2) {
                return cd1.getTuaCD().compareTo(cd2.getTuaCD());
            }
        });
    }

    public void xuatDanhSach() {
        if (soLuongHienTai == 0) {
            System.out.println("Danh sach rong!!!");
            return;
        }
        System.out.printf("%-10s %-25s %-20s %10s %-30s\n",
                "Ma CD", "Tua CD", "Ca Sy", "So Bai Hat", "Gia Thanh");
        for (int i = 0; i < soLuongHienTai; i++) {
            System.out.println(danhSach[i].toString());
        }
    }
}