package m23_25642411_lehaiduong;
import java.time.LocalDate;
 class GiaoDichDat extends GiaoDich {
	 private String loaiDat;
	 
	 public GiaoDichDat (String ma , LocalDate ngay , double donGia,
			 			double dienTich,String loaiDat) {
		super(ma,ngay ,donGia,dienTich);
		this.loaiDat=loaiDat;
	 }

	@Override
	public double thanhTien() {
		// TODO Auto-generated method stub
		if(loaiDat.equalsIgnoreCase("A")) {
			return dienTich*donGia*1.5;
		}
		return dienTich*donGia;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Dat]"+super.toString()+"| loai"+loaiDat;
	}
	 
	 
	 

}
