package beanNameAware.src;

import java.util.List;

public class DatabaseRowBean {
	private String rowId;
	private int noOfColumns;
	private List<String> values;
	
	public int getNoOfColumns() {
		return noOfColumns;
	}
	public void setNoOfColumns(int noOfColumns) {
		this.noOfColumns = noOfColumns;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	
}
