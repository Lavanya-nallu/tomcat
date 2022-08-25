package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Totalmaks extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
     {
		res.setContentType("text/html");
    	 PrintWriter out=res.getWriter();
    	 String title="Read all parameters";
    	 String doctype="<!doctype html public \"-//w3c//dtd html 4.0"+"tansitional//en\">\n";
    	 out.println(doctype+
    			 "<html>\n"+
    			 "<head><title>"+title+"</title></head>\n"+
    			 "<body>\n"+
    			   "<h1 align=\"center\">"+title+
    			   "<table width=\"100%\" height=\"300%\" align=\"center\" border=\"1\">\n"+
    			      "<tr bgcolor=\"green\">\n"+
    			          "<th>param name</th>\n"+
    			          "<th>param value</th>\n"+
    			      "</tr>\n"
    			 );
    	 Enumeration<String> paramNames = req.getParameterNames();
    	 while(paramNames.hasMoreElements())
    	 {
    		 String paramName=paramNames.nextElement();
    		 //out.print("<tr><td>"+paramName+"</td></tr>\n");
    		 String[] paramValues=req.getParameterValues(paramName);
    		 if(paramValues.length==1)
    		 {
    			 String paramValue=paramValues[0];
    			 if(paramValue.length()==0)
    			 {
    				 out.println("<tr><td>"+paramName+"</td>"+"<td>"+paramValue+"</td></tr>\n");
    				 // out.println("<td><i>no value</i></td>");
    			 }
    			 else {
    			 out.println("<tr><td>"+paramName+"</td>"+"<td>"+paramValue+"</td></tr>\n");
    			 }
    		 }
    		 else
    		 {
    			 out.println("<ul>");
    			 for(int i=0;i<paramValues.length;i++)
    			 {
    				 out.println("<li>"+"<tr><td>"+paramName+"</td>"+"<td>"+paramValues[i]+"</td></tr>\n"+"</li>");
    				// out.println("<li>"+paramValues[i]+"</li>\n");
    			 }
    			 out.println("</ui>");
    		 }
    	 }
    	 out.println("</tr>\n</table>\n</body>\n</html>");
     }
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doGet(req,res);
	}
}
