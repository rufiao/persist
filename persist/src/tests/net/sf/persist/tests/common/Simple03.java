
//$Id$

package net.sf.persist.tests.common;

import net.sf.persist.annotations.Column;
import net.sf.persist.annotations.Table;

@Table(name="simple")
public class Simple03 {

	private long id;
	private String stringCol;
	//private long intCol;

	@Column(autoGenerated=true)
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getStringCol() { return stringCol; }
	public void setStringCol(String stringCol) { this.stringCol = stringCol; }

	// lacks int_col mapping, will blow
	//public long getIntCol() { return intCol; }
	//public void setIntCol(long intCol) { this.intCol = intCol; }

}
