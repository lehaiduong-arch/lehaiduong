package m23_25642411_lehaiduong;
import java.time.LocalDate;

 class GiaoDichNha extends GiaoDich {
	 private String loaiNha;
	 private String diaChi;
	 
	 public GiaoDichNha (String ma ,LocalDate ngay , double donGia,
			 			double dienTich, String loaiNha , String diaChi) {
		 super(ma,ngay,donGia,dienTich);
		 this.loaiNha=loaiNha;
		 this.diaChi=diaChi;
	 }

	@Override
	public double thanhTien() {
		// TODO Auto-generated method stub
		if(loaiNha.equalsIgnoreCase("cao cap")) {
			return dienTich*donGia;
		}
		return dienTich*donGia*0.9;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return"[Nha]" + super.toString() +"| loai: " + loaiNha + "| diaChi"+ diaChi;
	}

}
