package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
// import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetAllParamValues extends HttpServlet{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
     {
    	 PrintWriter out=res.getWriter();
    	 String title="Reading all form params and perform total of marks";
    	 String doctype="<!doctype html public \"-//w3c//dtd html 4.0" + "transitional//en\">\n";
    	 int total=0,telugu,hindi,english,maths,science,social;
    	  telugu=Integer.parseInt(req.getParameter("telugu"));
    	  hindi=Integer.parseInt(req.getParameter("hindi"));
    	  english=Integer.parseInt(req.getParameter("english"));
    	  maths=Integer.parseInt(req.getParameter("maths"));
    	  science=Integer.parseInt(req.getParameter("science"));
    	  social=Integer.parseInt(req.getParameter("social"));
    	  total=telugu+hindi+english+maths+science+social;
    	 out.println(doctype+
    			 "<html>\n"+
    			 "<head><title>"+title+"</title></head>\n"+
    			 "<body>\n"+
    			    "<b>Total marks=====</b>"+total+
    			 "</body>\n"+
    			 "</html>"
    			 );
     }
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doGet(req,res);
	}
}
