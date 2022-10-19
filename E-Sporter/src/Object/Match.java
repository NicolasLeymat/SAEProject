package Object;

import java.sql.Date;

public class Match {

	private Date date;

	public Match(Date date) {
		this.setDate(date);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
