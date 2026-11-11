package stt02_25642411_lehaiduong;
import java.time.LocalDate;
import java.util.*;

abstract class KhachHang {
    protected String    maKhachHang;
    protected String    hoTen;
    protected LocalDate ngayLapHoaDon;
    protected double    soKW;
    protected double    donGia;

    public KhachHang(String ma, String ten, LocalDate ngay,
                     double soKW, double donGia) {
        this.maKhachHang   = ma;
        this.hoTen         = ten;
        this.ngayLapHoaDon = ngay;
        this.soKW          = soKW;
        this.donGia        = donGia;
    }

    public abstract double thanhTien();

    public LocalDate getNgayLapHoaDon() { return ngayLapHoaDon; }
    public String    getMaKhachHang()   { return maKhachHang; }
    public String    getHoTen()         { return hoTen; }

    @Override
    public String toString() {
        return String.format("%s | %s | Ngày: %s | TT: %,.0f",
                maKhachHang, hoTen, ngayLapHoaDon, thanhTien());
    }
}



