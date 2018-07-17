

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.uci.rest.model.keyboard;
import com.uci.rest.service.jsonToObject;

public class ReadCookies extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{        
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
	
			
			// Get an array of Cookies associated with this domain
			Cookie cookies[] = request.getCookies();
			
			out.println("<br>");
			out.println("<h1>History</h1>");
			
			int historyCount = 0;
			
				for (int i = cookies.length - 1; i >= 0 && historyCount < 5; i--)
				{
					if(cookies[i].getName().contains("history"))
					{
						// Get product id (adn initialize the rest)
						String pid = cookies[i].getValue(), name = "", category = "";
						int id = 0;
						double price = 0;
						
						
						keyboard kb = jsonToObject.getKeyboard(Integer.parseInt(pid));
						id = kb.getId();
						name = kb.getName();
						category = kb.getCategory();
						price = kb.getPrice();
					    
						out.println("<a href='historyproduct?id=" + id + "'>");
						out.println("<div class=''>");
						out.println("<div class='img'><img src='img/keyboard_" + id + ".jpg'></div>");
						out.println("<p class='product_name'>" + name + "</p>");
						out.println("<p class='product_category'>" + category + "</p>");
						out.println("<p class='product_price'>$" + price + "</p>");
						out.println("</div></a>");
						
						historyCount++;
					}
					
				}

		} 

	}
}

