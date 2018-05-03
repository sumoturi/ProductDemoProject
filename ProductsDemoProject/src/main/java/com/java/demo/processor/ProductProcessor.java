package com.java.demo.processor;

import java.io.IOException;

import com.java.demo.bo.ProductDO;
import com.java.demo.dao.ProductDAO;

/**
 * Servlet implementation class ProductProcessor
 */


/**
 * This class is used to accept the request from the server and gives the
 * response.
 * 
 * @author moturi
 * 
 */


public class ProductProcessor extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductDAO shoeDaoObj = null;

	/**
	 * This constructor is used to create instance for the ProductDAO class
	 * by using get bean method from spring.xml file.
	 */

	public ProductProcessor() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "Spring.xml" });
		shoeDaoObj = context.getBean("productDaoObj", ProductDAO.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * Whenever this method get the request from server , it calls the doPost
	 * method. In doPost method, it consists of business logic and gives the
	 * response.
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * This method takes the input values from the input class and performs the
	 * business logic. It takes the view from the request dispatcher and
	 * displays the results in the Product Processor page itself.
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer shoeOut = null;
		ProductDO shoeDO = null;
		ProductDO shoeInObj1 = (ProductDO) request
				.getAttribute("shoeIn");
		if (shoeInObj1!=null) {
			String shoeName = shoeInObj1.getShoeName();
			String shoeDesc = shoeInObj1.getShoeDescription();
			String shoePolish = shoeInObj1.getShoePolish();
			Integer shoeId = shoeInObj1.getShoeId();
			if ((shoeName!=null)&&(shoeDesc!=null)&&(shoePolish!=null)) {
				shoeOut = shoeDaoObj.addShoe(shoeName, shoeDesc, shoePolish);
				request.setAttribute("shoeOut", shoeOut);
				RequestDispatcher reqDispObj = request
						.getRequestDispatcher("view/SearchProduct.jsp");
				reqDispObj.forward(request, response);
			} else if(shoeId!=0){
				shoeDO = shoeDaoObj.getShoeByPK(shoeId);
				request.setAttribute("shoeOut", shoeDO);
				RequestDispatcher reqDispObj = request
						.getRequestDispatcher("view/ProductOutput.jsp");
				reqDispObj.forward(request, response);
			}else if((shoeName!=null)){
				shoeDaoObj.updateShoe(shoeId, shoeName);
				RequestDispatcher reqDispObj = request
						.getRequestDispatcher("view/Home.jsp");
				reqDispObj.forward(request, response);
			}else {
				response.sendRedirect("view/Home.jsp");
			}
		} else {
			response.sendRedirect("view/Home.jsp");
		}
	}

}
