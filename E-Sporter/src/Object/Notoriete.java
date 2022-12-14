package Object;

public enum Notoriete {

	LOCAL(1) ,NATIONAL(2), INTERNATIONAL(3);

	private int value;

	Notoriete(int i) {
		this.value = i;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
