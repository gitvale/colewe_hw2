package uni.colewe.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uni.colewe.shared.MyDictionaryEntry;

@SuppressWarnings("serial")
public class MyDictServlet extends HttpServlet {
	private MyDictionary dict_servlet;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
	    String query = req.getParameter("query");
	    String rev = req.getParameter("rev");
	    String sW = req.getParameter("sW");
	    
	    if(query == null || rev == null || sW == null){
	    	resp.setStatus(400);
	    	out.println("<!doctype html>");
	    	out.println("<html>");
	    	out.println("<head></head>");
	    	out.println("<body>");
	    	out.println("<h3>Invalid request parameters</h3>");
	    	out.println("<div>Try this: ?query=in&rev=true&sW=true</div>");
	    	out.println("</body>");
	    	out.println("</html>");
	    	
	    } else {
	    	resp.setStatus(200);
	    	Set<MyDictionaryEntry> results = dict_servlet.treeLookUp(query, Boolean.valueOf(rev), Boolean.valueOf(sW));
	    	out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    	out.println("<results>");
	    	for(MyDictionaryEntry entry : results){
	    		out.println("\t<entry>");
	    		out.println("\t\t<rus>" + entry.getRus() + "</rus>");
	    		out.println("\t\t<pos>" + entry.getPos() + "</pos>");
	    		out.println("\t\t<eng>" + entry.getEng() + "</eng>");
	    		out.println("\t</entry>");
	    	}
	    	out.println("</results>");
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		resp.setStatus(501);
		out.print("Post requests cannot be handled as of yet");
	}

	@Override
	public void init() throws ServletException {
		dict_servlet = new MyDictionary(getServletContext().getRealPath("/WEB-INF/dictdata_servlet.txt"));
	}

}
