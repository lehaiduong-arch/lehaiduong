package Bai5;

import java.time.LocalDate;

public class test {
    public static void main(String[] args) {
        try {
            HangThucPham h1 = new HangThucPham(
                    "001",
                    "Gao",
                    100000,
                    LocalDate.of(2018, 7, 10),
                    LocalDate.of(2018, 8, 10)
            );

            HangThucPham h2 = new HangThucPham(
                    "002",
                    "Mi",
                    5000,
                    LocalDate.of(2018, 3, 1),
                    LocalDate.of(2018, 9, 1)
            );

            HangThucPham h3 = new HangThucPham(
                    "003",
                    "Nuoc",
                    10000,
                    LocalDate.of(2017, 3, 1),
                    LocalDate.of(2018, 3, 1)
            );

            System.out.printf(
                    "%-8s %-15s %15s %15s %15s %-15s%n",
                    "Ma_Hang",
                    "Ten_Hang",
                    "Don_Gia",
                    "Ngay_SX",
                    "Ngay_HH",
                    "Ghi_Chu"
            );

            System.out.println(
                    "--------------------------------------------------------------------------"
            );

            System.out.println(h1);
            System.out.println(h2);
            System.out.println(h3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
