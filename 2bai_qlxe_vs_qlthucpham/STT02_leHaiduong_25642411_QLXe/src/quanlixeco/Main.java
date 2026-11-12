public class Main {
    public static void main(String[] args) {
        Vehicle xe1 = new Vehicle("Le Hai Duong Furry", "Vision", 40000000, 100);
        Vehicle xe2 = new Vehicle("Nguyen Thanh Hoang Ha", "Xe Lan", 5000000, 10);
        Vehicle xe3 = new Vehicle();
        
        System.out.println("Nhap thong tin xe cua m:");
        xe3.nhapXe();
        
        System.out.println("\n=========================================================================================");
        System.out.printf("%-25s %-15s %-15s %-15s %-15s\n", "Ten chu xe", "Loai xe", "Tri gia", "Dung tich", "Thue");
        System.out.println("=========================================================================================");
        xe1.xuatXe();
        xe2.xuatXe();
        xe3.xuatXe();
    }
}