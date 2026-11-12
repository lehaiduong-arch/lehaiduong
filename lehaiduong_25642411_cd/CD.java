package Tuan4;

public class CD {

	private int maCD;
	private String tuaCD;
	private String caSy;
	private int soBaiHat;
	private float giaThanh;

	public CD() {
	}

	public CD(int maCD, String tuaCD, String caSy, int soBaiHat, float giaThanh) throws Exception {
		this.maCD = maCD;
		this.tuaCD = tuaCD;
		this.caSy = caSy;
		setSoBaiHat(soBaiHat);
		setGiaThanh(giaThanh);
	}

	public String getCaSy() {
		return caSy;
	}

	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}

	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}

	public String getTuaCD() {
		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}

	public int getSoBaiHat() {
		return soBaiHat;
	}

	public void setSoBaiHat(int soBaiHat) throws Exception {
		if (soBaiHat>0) {
			this.soBaiHat = soBaiHat;
		} else {
			throw new Exception("So bai hat > 0");
		}

	}

	public float getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(float giaThanh) throws Exception {
		if (giaThanh < 0) {
			throw new Exception("Invalid giaThanh > 0");
		} else {
			this.giaThanh = giaThanh;
		}

	}

    @Override
    public String toString() {
        return String.format("%-10d %-25s %-20s %-10d %18.2f", maCD, tuaCD, caSy, soBaiHat, giaThanh);
    }

}
