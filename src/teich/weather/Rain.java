package teich.weather;

import com.google.gson.annotations.SerializedName;

public class Rain {

	@SerializedName("3h")
	private int threeH;

	public int getThreeH() {
		return threeH;
	}

	public void setThreeH(int threeH) {
		this.threeH = threeH;
	}

	@Override
	public String toString() {
		return "rain [threeH=" + threeH + "]";
	}

}
