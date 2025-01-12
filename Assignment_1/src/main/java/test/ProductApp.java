package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/dis")

public class ProductApp extends  GenericServlet {

	public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String pName=req.getParameter("pname");
		String pId=req.getParameter("pid");
		String pPrice=req.getParameter("pprice");
		String pQty=req.getParameter("pqty");
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.write("==========product details=========");
		pw.write("<br>Product Name:"+pName);
		pw.write("<br>Product id:"+pId);
		pw.write("<br>Product price:"+pPrice);
		pw.write("<br>Product quantity:"+pQty);
	}
	public void destroy()
	{
		
	}

}
