package il.ac.shenkar.model;

import java.util.*;

public interface InventoryDAO {
	public Collection<Product> getProducts() throws InventoryException;
	public boolean addProduct(Product product) throws InventoryException;
}
