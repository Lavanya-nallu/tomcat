package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AllParamNames extends HttpServlet{
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
    	 int total=0;
    	 out.println(doctype+
    			 "<html>\n"+
    			 "<head><title>"+title+"</title></head>\n"+
    			 "<body>\n"+
    			   "<h1 align=\"center\">"+title+
    			   "<table width=\"50%\" height=\"100%\" align=\"center\" border=\"1\">\n"+
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
    		 //System.out.println(paramValues.toString());
    		 if(paramValues.length==1)
    		 {
    			 String paramValue=paramValues[0];
    			 System.out.println(paramValue);
    			 if(paramValue.length()==0)
    			 {
    				 System.out.println(paramValue.length());
    				 out.println("<tr><td>"+paramName+"</td>"+"<td>"+paramValue+"</td></tr>\n");
    				 // out.println("<td><i>no value</i></td>");
    			 }
    			 else {
    			 out.println("<tr><td>"+paramName+"</td>"+"<td>"+paramValue+"</td></tr>\n");
    			 total=total+Integer.parseInt(paramValue);
    			 }
    		 }
    		 else
    		 {
    			 out.println("<ul>");
    			 for(int i=0;i<paramValues.length;i++)
    			 {
    				 System.out.println("list");
    				 out.println("<li>"+"<tr><td>"+paramName+"</td>"+"<td>"+paramValues[i]+"</td></tr>\n"+"</li>");
    				// out.println("<li>"+paramValues[i]+"</li>\n");
    				 System.out.println(paramValues[i]);
    				 total=total+Integer.parseInt(paramValues[i]);
    			 }
    			 out.println("</ui>");
    		 }
    	 }
    	 out.println("</tr>\n</table>\n");
    	 out.println("<b>total=====</b>"+total+"</body></html>");
    	 
     }
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doGet(req,res);
	}
}
