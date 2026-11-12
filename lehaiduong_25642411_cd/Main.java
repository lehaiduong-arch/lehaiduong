package Tuan4;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		DanhSachCD quanLyCD = new DanhSachCD(100);
		quanLyCD.themCD(new CD(1, "Nhac tre top 1", "Duong Domic", 15, 150000));
		quanLyCD.themCD(new CD(2, "US-UK Hits", "Taylor Swift", 20, 200000));
		quanLyCD.themCD(new CD(3, "Nhac ballad hay nhat nam 2023", "Nguyen Hoang Dung", 1, 250000));
		int luaChon = 0;
	        do {
	            System.out.println("\n========== MENU QUAN LY CD ==========");
	            System.out.println("1. Them CD moi");
	            System.out.println("2. Tinh so luong CD hien co");
	            System.out.println("3. Tinh tong gia thanh");
	            System.out.println("4. Sap xep giam dan theo gia thanh");
	            System.out.println("5. Sap xep tang dan theo tua CD");
	            System.out.println("6. Xuat toan bo danh sach");
	            System.out.println("0. Thoat");
	            System.out.print("Nhap lua chon cua ban: ");
	            
	            try {
	                luaChon = Integer.parseInt(scanner.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Vui long nhap so nguyen!");
	                continue;
	            }
	            switch (luaChon) {
                case 1:
                    System.out.println("--- Nhap thong tin CD moi ---");
                    System.out.print("Nhap ma CD: ");
                    int ma = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhap tua CD: ");
                    String tua = scanner.nextLine();
                    System.out.print("Nhap ten ca sy: ");
                    String caSy = scanner.nextLine();
                    System.out.print("Nhap so bai hat: ");
                    int soBai = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhap gia thanh: ");
                    float gia = Float.parseFloat(scanner.nextLine());

                    CD cdMoi = new CD(ma, tua, caSy, soBai, gia);
                    if (quanLyCD.themCD(cdMoi)) {
                        System.out.println("Them CD thanh cong!");
                    }
                    break;

                case 2:
                    System.out.println("So luong CD hien co trong danh sach: " + quanLyCD.soLuongCD());
                    break;

                case 3:
                    System.out.printf("Tong gia thanh cua tat ca CD: %.2f\n", quanLyCD.thanhTien());
                    break;

                case 4:
                    quanLyCD.sortTheoGia();
                    System.out.println("Da sap xep danh sach giam dan theo gia thanh.");
                    quanLyCD.xuatDanhSach(); 
                    break;

                case 5:
                    quanLyCD.sortTheoTua();
                    System.out.println("Da sap xep danh sach tang dan theo tua CD.");
                    quanLyCD.xuatDanhSach(); 
                    break;

                case 6:
                    System.out.println("--- DANH SACH CD HIEN TAI ---");
                    quanLyCD.xuatDanhSach();
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh. Tam biet!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        } while (luaChon != 0);

        scanner.close();
    }
	           
}