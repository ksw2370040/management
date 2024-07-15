package tanni;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class Select2Action extends Action {
	public String execute(
		HttpServletRequest request,HttpServletResponse response
	)throws Exception{
		// セッションを取得
		HttpSession session = request.getSession();

		// StudentDAOのインスタンスを作成
		StudentDAO dao = new StudentDAO();

		// 学生のリストを取得するためにDAOメソッドを呼び出す
		List<Student> list = dao.GetList(request, response);

		// 取得した学生のリストをセッションに保存
		session.setAttribute("list", list);

		// updateselect.jspページにリダイレクト
		return "updateselect.jsp";
		}
	}