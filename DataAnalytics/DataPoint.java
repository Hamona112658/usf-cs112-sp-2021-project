
public class DataPoint {
	private Double f1;
	private Double f2;
	private String label;
	private Boolean test;
	
	public DataPoint() {
		f1=0.0;
		f2=0.0;
		label="";
		test= null;
	}
	public DataPoint(Double f1,Double f2,String label,Boolean test) {
		this.f1=f1;
		this.f2=f2;
		this.label= label ;
		this.test= test;
	}
	public Double getF1() {
		return f1;
	}
	public Double getF2() {
		return f2;
	}
	public void setTest(Boolean test) {
		this.test= test;
	}
}
