

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

public class ProductInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{        
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			
			// GET parameters
			String pid = request.getParameter("id");
			
			
			String name = null, category = null, quote = null, color = null, connection = null,
					dimension = null, description = null;
			
			int id = 0;
			double price = 0, weight = 0;
			
			
			keyboard kb = jsonToObject.getKeyboard(Integer.parseInt(pid));
			
			
			id = kb.getId();
			name = kb.getName();
			category = kb.getCategory();
			price = kb.getPrice();
			quote = kb.getQuote();
			color = kb.getColor();
			connection = kb.getConnection();
			dimension = kb.getDimension();
			weight = kb.getWeight();
			description = kb.getDescription();
		
			
			
			out.println("<!DOCTYPE html><html><head><title>The Yard</title>");
			out.println("<link rel='icon' href='https://cdn0.iconfinder.com/data/icons/e-commerce-and-shopping-2/512/keyboard_device_computer_modern_web_typing_keys_usability_tool_equipment_computing_flat_design_icon-512.png'>");
			out.println("<link rel='stylesheet' href='css/home.css'><link rel='stylesheet' href='css/product.css'></head><body>");
			out.println("<div id='container_main' class='wrapper'> <div id='header'><ul id='primary_menu'>");
			out.println("<li><span class='nav_title'><a href='home.jsp'>HOME</a></span></li>");
			out.println("<li><span class='nav_title'><a href='about.html'>ABOUT</a></span></li>");
			out.println("<li><span class=\"nav_title\"><a href=\"ShoppingCart?list=CART\">CART</a></span></li><li><span class=\"nav_title\"><a href=\"displayproduct\">HISTORY</a></span></li>");
			out.println("</ul>");
			out.println("<div id='home'>");
			out.println("<p id='scrap' class='logo'><a href='home.jsp'><span>SCRAP</span></a></p>");
			out.println("<p id='yard' class='logo'><a href='home.jsp'><span>YARD</span></a></p>");
			out.println("</div></div></div>");
			out.println("<div id='container_product_info' class='wrapper'><div class='product'><div class='productimg'>");
			out.println("<img src='img/keyboard_" + id + ".jpg'>");
			out.println("</div><div class='a'>");
			out.println("<p class='product_name'>" + name + "</p>");
			out.println("<p class='product_category'>" + category + "</p>");
			out.println("<p class=\"product_price\">" + price + "</p>");
			out.println("<p id='product_quote' class='product_specs'>" + quote + "</p>");
			out.println("<p id='product_color' class='product_specs'><span class='category_title'>Color: </span>" + color +"</p>");
			out.println("<p id='product_connection' class='product_specs'><span class='category_title'>Connection: </span>" + connection + "</p>");
			out.println("<p id='product_dimensions' class='product_specs'><span class='category_title'>Dimension:</span>" + dimension + "</p>");
			out.println("<p id='product_weight' class='product_specs'><span class='category_title'>Weight:</span>" + weight + "</p>");
			out.println("<p id='product_description' class='product_specs'>" + description + "</p>");
			//out.println("<button onclick='' id='buybtn'>Add To Cart</button>");
			out.println("<div>");
			out.println("<form method=\"get\" action=\"ShoppingCart?id=" + id + "\">");
			out.println("Enter Quantity <input type=\"text\" name=\"quantity\" required pattern=\"[0-9]{1,2}\" minlength=\"1\" maxlength=\"2\"><br>");
			out.println("<input type=\"hidden\" name=\"keyid\" value=\"" + id + "\">");
			out.println("<input type=\"submit\" value=\"Add to Cart\" name=\"add\">");
			out.println("</form>");
			out.println("</div>");
			
			
			out.println("</div></div></div>");
			out.println("</body></html>");
		}	
	}
}

