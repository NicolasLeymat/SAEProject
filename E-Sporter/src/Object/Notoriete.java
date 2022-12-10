package Object;

public enum Notoriete {

	DEPARTEMENTAL(1) ,REGIONAL(2), NATIONAL(3);

	private int value;

	Notoriete(int i) {
		this.value = i;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
