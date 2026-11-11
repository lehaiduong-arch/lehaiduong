package tuan1.bai1Hinhtron;

import java.util.Scanner;

public class hinhtronbai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ban kinh r: ");
        double r = sc.nextDouble();

        HinhTron ht = new HinhTron(r);

        System.out.println("Dien tich hinh tron = " + ht.tinhDienTich());
        System.out.println("Chu vi hinh tron = " + ht.tinhChuVi());

        sc.close();
    }
}
