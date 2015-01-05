package il.ac.shenkar.controller;

import il.ac.shenkar.model.InventoryException;
import il.ac.shenkar.model.MySQLInventoryDAO;
import il.ac.shenkar.model.Product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class InventoryController
 */
@WebServlet("/controller/*")
public class InventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InventoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String path = request.getPathInfo();
		RequestDispatcher dispatcher = null;
		PrintWriter out = response.getWriter();
		if(path.endsWith("products")) {
			
			try {
				Object ob = MySQLInventoryDAO.getInstance().getProducts();
				request.setAttribute("products", ob);
				dispatcher = getServletContext().getRequestDispatcher("/products.jsp");
				dispatcher.forward(request, response);
			}
			catch (InventoryException e) {
				request.setAttribute("exception", e);
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}	
		} 
		else if(path.endsWith("addproduct")) {
			dispatcher = getServletContext().getRequestDispatcher("/addproduct.jsp");	
			dispatcher.forward(request, response);
		}
		else if(path.endsWith("menu")){
			dispatcher = getServletContext().getRequestDispatcher("/menu.jsp");
			dispatcher.forward(request, response);
		}
		else if (path.contains("insert")) {
			try {
				int productId = Integer.parseInt(request.getParameter("product_id"));
				double productPrice = Double.parseDouble(request.getParameter("product_price"));
				String productName = request.getParameter("product_name");
				Product product = new Product(productId,productPrice,productName);
				MySQLInventoryDAO.getInstance().addProduct(product);
				dispatcher = getServletContext().getRequestDispatcher("/added.jsp");
				dispatcher.forward(request, response);
			}
			catch (InventoryException e) {
				request.setAttribute("exception", e);
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}	
		}
		else {
			request.setAttribute("exception", new InventoryException("request path is not supported",new Exception()));
			dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
		
	}


}
