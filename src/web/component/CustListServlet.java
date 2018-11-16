package web.component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.Cust;
import com.cust.CustBiz;

@WebServlet({ "/CustListServlet", "/clist" })
public class CustListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustBiz biz;
    public CustListServlet() {
        super();
        biz = new CustBiz();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Cust> list  = null;
		response.setCharacterEncoding("EUC-KR");
		
		PrintWriter out = response.getWriter();
		String result = "";
		try {
			list = biz.get();
			result +="<table border=2 >";
			for(Cust c:list) { 
				result += "<tr><td><a href='cdetail?id="+c.getId()+"'>"+c.getId()+"</a></td><td>"+c.getName()+"</td><td>"+c.getAge()+"</td></tr>";
			}
			result +="</table>";
		} catch (Exception e) {
			result+= "<h1>List FAIL</h1>";
			e.printStackTrace();
		}
		
		
		out.println(result);
		out.close();
		
	}

}
