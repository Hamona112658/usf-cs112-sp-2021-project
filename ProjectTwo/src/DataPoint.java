public class DataPoint<T> {
	private T x;
	private T y;
	private T z;
	private T u;
	
	private T label;
	
	
	public DataPoint(T x, T y, T z, T u, T label ) {
		this.x=x;
		this.y=y;
		this.z=z;
		this.u=u;
		this.label=label;
	}
	public void setx(T x) {
		this.x=x;
	}
	public void sety(T y) {
		this.y=y;
	}
	public void setz(T z) {
		this.z=z;
	}
	public void setu(T u) {
		this.u=u;
	}
	public void setLabel(T label) {
		this.label=label;
	}

	public T getx() {
		return x;
	}
	public T gety() {
		return y;
	}
	public T getz() {
		return z;
	}
	public T getu() {
		return u;
	}
	public T getLabel() {
		return label;
	}
	@Override
	public String toString() {
		return "("+String.valueOf(x)+" , "+String.valueOf(y)+" , "+String.valueOf(z)+" , "+String.valueOf(u)+") , label: +" + String.valueOf(label);
	}
}

