package web.component;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.Cust;
import com.cust.CustBiz;

@WebServlet("/cdetail")
public class cdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 CustBiz biz;
    public cdetail() {
        super();
        biz = new CustBiz();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cust cust  = null;
		response.setCharacterEncoding("EUC-KR");
		
		PrintWriter out = response.getWriter();
		String result = "";
		try {
			cust = biz.get("id");
			result +="<table border=2 >";
			
				result += "<tr><td><a href='cdetail'>"+cust.getId()+"</a></td><td>"+cust.getName()+"</td><td>"+cust.getAge()+"</td></tr>";
			
			result +="</table>";
		} catch (Exception e) {
			result+= "<h1>List FAIL</h1>";
			e.printStackTrace();
		}
		
		
		out.println(result);
		out.close();
		
	}

}


