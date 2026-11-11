package HinhChuNhatTuan1;

import java.util.Scanner;

public class HCNtuan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap Chieu Dai: ");
        double dai = sc.nextDouble();
        System.out.println("Nhap Chieu Rong: ");
        double rong = sc.nextDouble();

        HinhChuNhat hcn = new HinhChuNhat(dai, rong);

        System.out.println(hcn);
        System.out.println("Dien tich Hinh Chu Nhat la: " + hcn.tinhDienTich());
        System.out.println("Chu Vi Hinh Chu Nhat la: " + hcn.tinhChuVi());

        sc.close();
    }
}
