package il.ac.shenkar.model;

public class InventoryException extends Exception {
	public InventoryException(String msg) {
		super(msg);
	}
	public InventoryException(String msg, Throwable throwable) {
		super(msg,throwable);
	}
}