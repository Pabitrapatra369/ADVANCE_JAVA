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
public class BookDetails extends GenericServlet{

	public void init() throws ServletException
	{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String bName=req.getParameter("bname");
		String bAuth=req.getParameter("bauth");
		String bPrice=req.getParameter("bprice");
		String bDesc=req.getParameter("bdesc");
		String bDate=req.getParameter("bdate");
		
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.write("==========Book Info================");
		pw.write("<br>Book Name:"+bName);
		pw.write("<br>Book Author:"+bAuth);
		pw.write("<br>Book price:"+bPrice);
		pw.write("<br>Book description:"+bDesc);
		pw.write("<br>Book assigned date:"+bDate);
	}
	public void destroy()
	{
		
	}

}
