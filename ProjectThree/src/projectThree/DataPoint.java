package projectThree;
public class DataPoint<T> {
	private T x;
	private T y;
	
	private T dataLabel;
	private T predictorLabel;
	
	public DataPoint(T x, T y, T dataLabel,T predictorLabel ) {
		this.x=x;
		this.y=y;
		this.dataLabel=dataLabel;
		this.predictorLabel=predictorLabel;
		
	}
	public void setx(T x) {
		this.x=x;
	}
	public void sety(T y) {
		this.y=y;
	}
	
	public void setDataLabel(T dataLabel) {
		this.dataLabel=dataLabel;
	}
	public void setPredictorLabel(T predictorLabel) {
		this.predictorLabel=predictorLabel;
	}

	public T getx() {
		return x;
	}
	public T gety() {
		return y;
	}
	
	public T getDataLabel() {
		return dataLabel;
	}
	public T getPredictorLabel() {
		return predictorLabel;
	}
	@Override
	public String toString() {
		return "("+String.valueOf(x)+" , "+String.valueOf(y)+" , dataLabel: +" + String.valueOf(dataLabel)+" , predictorLabel: +" + String.valueOf(predictorLabel);
	}
}

