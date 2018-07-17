

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.glassfish.jersey.client.ClientConfig;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.uci.rest.model.keyboard;

public class DisplayProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{       
				
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			out.println("<link rel=\"stylesheet\" href=\"css/home.css\">");
			out.println("<div id='container_main' class='wrapper'> <div id='header'><ul id='primary_menu'>");
			out.println("<li><span class='nav_title'><a href='home.jsp'>HOME</a></span></li>");
			out.println("<li><span class='nav_title'><a href='about.html'>ABOUT</a></span></li>");
			out.println("<li><span class=\"nav_title\"><a href=\"ShoppingCart?list=CART\">CART</a></span></li><li><span class=\"nav_title\"><a href=\"displayproduct\">HISTORY</a></span></li>");
			out.println("</ul>");
			out.println("<div id='home'>");
			out.println("<p id='scrap' class='logo'><a href='home.jsp'><span>SCRAP</span></a></p>");
			out.println("<p id='yard' class='logo'><a href='home.jsp'><span>YARD</span></a></p>");
			out.println("</div></div></div>");

			out.println("<div>");
			request.getRequestDispatcher("readcookies").include(request, response);
			out.println("</div>");
			
		}
	}
}

