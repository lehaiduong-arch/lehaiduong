package quanlycd;

import java.util.Scanner;

public class main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CDlist ql = new CDlist();
        int luaChon = -1;

        do {
            System.out.println("\n================ MENU QUAN LY CD ================");
            System.out.println("| 1. Them CD (tu mo rong mang khi day)           |");
            System.out.println("| 2. Xoa CD theo ma                              |");
            System.out.println("| 3. Sua / Cap nhat CD theo ma                   |");
            System.out.println("| 4. Tim kiem theo ma                            |");
            System.out.println("| 5. Tim theo tua - TIEN TO (ben trai)           |");
            System.out.println("| 6. Tim theo tua - HAU TO (ben phai)            |");
            System.out.println("| 7. Tim theo tua - GAN GIONG (chua tu khoa)     |");
            System.out.println("| 8. Hien thi danh sach                          |");
            System.out.println("| 9. Thong ke                                    |");
            System.out.println("| 10. Sap xep giam dan theo gia thanh            |");
            System.out.println("| 11. Sap xep tang dan theo tua CD               |");
            System.out.println("| 0. Thoat                                       |");
            System.out.println("=================================================");
            System.out.print(" Chon chuc nang: ");

            try {
                luaChon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Vui long nhap so!");
                continue;
            }

            switch (luaChon) {
                case 1:  themCD(ql); break;
                case 2:  xoaCD(ql); break;
                case 3:  capNhatCD(ql); break;
                case 4:  timTheoMa(ql); break;
                case 5:  timTheoTienTo(ql); break;
                case 6:  timTheoHauTo(ql); break;
                case 7:  timGanGiong(ql); break;
                case 8:  ql.hienThiDanhSach(); break;
                case 9:  thongKe(ql); break;
                case 10: 
                    ql.sapXepGiamDanTheoGia(); 
                    ql.hienThiDanhSach(); 
                    break;
                case 11: 
                    ql.sapXepTangDanTheoTua(); 
                    ql.hienThiDanhSach(); 
                    break;
                case 0:  
                    System.out.println("Tam biet!"); 
                    break;
                default: 
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);

        sc.close();
    }

    static void themCD(CDlist ql) {
        try {
            System.out.print("Nhap ma CD (>0): ");
            int ma = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap tua CD: ");
            String tua = sc.nextLine();
            System.out.print("Nhap so bai hat (>0): ");
            int sbh = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap gia thanh (>0): ");
            double gia = Double.parseDouble(sc.nextLine());

            if (ql.themCD(new CD(ma, tua, sbh, gia))) {
                System.out.println("Them CD thanh cong!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi: Du lieu so khong hop le!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void xoaCD(CDlist ql) {
        try {
            System.out.print("Nhap ma CD can xoa: ");
            int ma = Integer.parseInt(sc.nextLine());
            if (ql.xoaCD(ma)) {
                System.out.println("Xoa CD thanh cong!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ma CD phai la so!");
        }
    }

    static void capNhatCD(CDlist ql) {
        try {
            System.out.print("Nhap ma CD can cap nhat: ");
            int ma = Integer.parseInt(sc.nextLine());
            if (ql.timTheoMa(ma) == null) {
                System.out.println("X Khong tim thay CD ma " + ma);
                return;
            }
            System.out.print("Nhap tua CD moi: ");
            String tua = sc.nextLine();
            System.out.print("Nhap so bai hat moi: ");
            int sbh = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap gia thanh moi: ");
            double gia = Double.parseDouble(sc.nextLine());

            if (ql.capNhatCD(ma, tua, sbh, gia)) {
                System.out.println("Cap nhat CD thanh cong!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi: Du lieu nhap vao phai la so!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void timTheoMa(CDlist ql) {
        try {
            System.out.print("Nhap ma CD can tim: ");
            int ma = Integer.parseInt(sc.nextLine());
            CD kq = ql.timTheoMa(ma);
            if (kq != null) {
                System.out.println("Tim thay:");
                System.out.println(kq);
            } else {
                System.out.println("X Khong co CD ma " + ma);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ma phai la so!");
        }
    }

    static void timTheoTienTo(CDlist ql) {
        System.out.print("Nhap tien to tua CD (so khop BEN TRAI): ");
        String tk = sc.nextLine();
        CDlist kq = ql.timTheoTienTo(tk);
        System.out.println("Tim thay " + kq.laySoLuong() + " ket qua (bat dau bang '" + tk + "'):");
        kq.hienThiDanhSach();
    }

    static void timTheoHauTo(CDlist ql) {
        System.out.print("Nhap hau to tua CD (so khop BEN PHAI): ");
        String tk = sc.nextLine();
        CDlist kq = ql.timTheoHauTo(tk);
        System.out.println("Tim thay " + kq.laySoLuong() + " ket qua (ket thuc bang '" + tk + "'):");
        kq.hienThiDanhSach();
    }

    static void timGanGiong(CDlist ql) {
        System.out.print("Nhap tu khoa (tim GAN GIONG, chua o bat ky vi tri nao): ");
        String tk = sc.nextLine();
        CDlist kq = ql.timGanGiong(tk);
        System.out.println("Tim thay " + kq.laySoLuong() + " ket qua (chua '" + tk + "'):");
        kq.hienThiDanhSach();
    }

    static void thongKe(CDlist ql) {
        System.out.println("\n===== THONG KE =====");
        System.out.println("So luong CD: " + ql.tinhSoLuongCD());
        System.out.printf("Tong gia thanh: %,.2f VND\n", ql.tinhTongGiaThanh());
        System.out.printf("Gia trung binh: %,.2f VND\n", ql.tinhGiaTrungBinh());
        CD max = ql.timCDDatNhat();
        CD min = ql.timCDRenhNhat();
        if (max != null) {
            System.out.println("CD dat nhat:  " + max);
            System.out.println("CD re nhat:   " + min);
        }
    }
}