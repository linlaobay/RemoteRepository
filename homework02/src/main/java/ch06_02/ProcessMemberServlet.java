package ch06_02;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch06_02/member.do")
public class ProcessMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("eId");
		int id2 = -1;
		if (id != null && id.trim().length() > 0) {
				try {
					id2 =Integer.valueOf(id);
				} catch (NumberFormatException e) {
					errorMessage.put("id", "必須為數值");
					e.printStackTrace();
				}
		}else {
			errorMessage.put("id", "必須輸入");
		}
		String year = request.getParameter("eyear");
		int year2 = -1;
		if (year != null && year.trim().length() > 0) {
			try {
				year2 =Integer.valueOf(year);
			} catch (NumberFormatException e) {
				errorMessage.put("year", "必須為數值");
				e.printStackTrace();
			}
	}else {
		errorMessage.put("year", "必須輸入");
	}
		String week = request.getParameter("eweek");
		int week2 = -1;
		if (week != null && week.trim().length() > 0) {
			try {
				week2 =Integer.valueOf(week);
			} catch (NumberFormatException e) {
				errorMessage.put("week", "必須為數值");
				e.printStackTrace();
			}
	}else {
		errorMessage.put("week", "必須輸入");
	}
		String type = request.getParameter("etype");
		if (type == null || type.trim().length() == 0) {
			errorMessage.put("type", "必須輸入");
		}
		String age = request.getParameter("eage");
		if (age == null || age.trim().length() == 0) {
			errorMessage.put("age", "必須輸入");
		}
		String county = request.getParameter("ecounty");
		if (county == null || county.trim().length() == 0) {
			errorMessage.put("county", "必須輸入");
		}
		String visit = request.getParameter("evisit");
		int visit2 = -1;
		if (visit != null && visit.trim().length() > 0) {
			try {
				visit2 =Integer.valueOf(visit);
			} catch (NumberFormatException e) {
				errorMessage.put("visit", "必須為數值");
				e.printStackTrace();
			}
	}else {
		errorMessage.put("visit", "必須輸入");
	}
		String tatlevisits = request.getParameter("etatlevisits");
		int tatlevisits2 = -1;
		if (tatlevisits != null && tatlevisits.trim().length() > 0) {
			try {
				tatlevisits2 =Integer.valueOf(tatlevisits);
			} catch (NumberFormatException e) {
				errorMessage.put("tatlevisits", "必須為數值");
				e.printStackTrace();
			}
		}else {
			errorMessage.put("tatlevisits", "必須輸入");
		}
	
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/InsertMemberForm.jsp");
			rd.forward(request, response);
			return;
		}
		MemberBean mb = new MemberBean(id2, year2, week2, type, age, county, visit2, tatlevisits2);
		try {
			MemberService service = new MemberService();
			service.insertMember(mb);
			session.setAttribute("memberBean", mb);
			response.sendRedirect(
		             response.encodeRedirectURL("InsertMemberSuccess.jsp"));
			return;
        } catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1 
				|| e.getMessage().indexOf("Duplicate entry") != -1) {
				errorMessage.put("id", "帳號重複，請重新輸入帳號");
			} else {
				errorMessage.put("exception", "資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/InsertMemberForm.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
