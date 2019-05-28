package ch06_02;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch06_02/Search.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		request.setCharacterEncoding("UTF-8");
		String id2 = request.getParameter("eId");
		int id = 0;
		// 檢核使用者的輸入資料
		if (id2 == null || id2.trim().length() == 0) {
			errorMessage.put("id", "ID欄必須輸入");
		}else if (id2 != null && id2.trim().length() > 0) {
				try {
					id =Integer.valueOf(id2);
				} catch (NumberFormatException e) {
					errorMessage.put("id", "ID欄必須為數值");
					e.printStackTrace();
				}
			
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/SearchForm.jsp");
			rd.forward(request, response);
			return;
		}
		MemberDao dao = new MemberDao();
			try {
				MemberBean bean = dao.select(id);
				String str = null;
				
				str = "<table border='1'><tr>"
						+ "<th width='200px'>id</th>"
						+ "<th width='200px'>year</th>"
						+ "<th width='200px'>week</th>"
						+ "<th width='200px'>type</th>"
						+ "<th width='200px'>age</th>"
						+ "<th width='200px'>county</th>"
						+ "<th width='200px'>visit</th>"
						+ "<th width='200px'>tatlevisits</th>";
				
				str += "<tr><td>" + bean.getId() + "</td><td>" + bean.getYear() + "</td><td>" + bean.getWeek()
						+ "</td><td>" + bean.getType() + "</td><td>" + bean.getAge() + "</td><td>"
						+ bean.getCounty() +"</td><td>"+ bean.getVisit() +"</td><td>"+ bean.getTatlevisits() +"</td></tr>";
				
				str += "</table>";
				session.setAttribute("SearchInfo", str);

				response.sendRedirect("SearchSuccess.jsp");
				return;

			} catch (Exception e) {
				errorMessage.put("exception", "資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/Search.jsp");
			rd.forward(request, response);
			return;
		}
	}