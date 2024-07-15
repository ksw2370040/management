package tanni;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class StudentUpdateSelectAction extends Action{
	public String execute(
		HttpServletRequest request,HttpServletResponse response
	)throws Exception{
		// リクエストパラメータから学生名を取得
		String student_name = request.getParameter("student_name");

		// StudentDAOのインスタンスを作成
		StudentDAO dao = new StudentDAO();

		// 学生名をもとにデータベースを検索し、該当する学生のリストを取得
		List<Student> list = dao.search(student_name);

		// 取得した学生のリストをリクエスト属性に設定
		request.setAttribute("list", list);

		// 検索結果を表示するJSPページにリダイレクト
		return "update.jsp";

	}
}