package tanni;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class StudentAddAction extends Action{
	public String execute(
		HttpServletRequest request,HttpServletResponse response
	)throws Exception{
		try{
		// リクエストパラメータから学生IDを取得し、整数に変換、学生名を取得、コースIDを取得
		Integer student_id = Integer.parseInt(request.getParameter("student_id"));
		String student_name = request.getParameter("student_name");

		// リクエストパラメータから
		String course_id = request.getParameter("course_id");

		// Studentオブジェクトを作成し、取得したデータをセット
		Student p = new Student();
		p.setstudent_id(student_id);
		p.setstudent_name(student_name);
		p.setcourse_id(course_id);

		// StudentDAOのインスタンスを作成し、学生データをデータベースに挿入
		StudentDAO dao = new StudentDAO();
		dao.insert(p);

		// addcomplete.jspページにリダイレクト
		return "addcomplete.jsp";

		} catch (Exception e) {
			// 例外処理
			request.setAttribute("error", "更新中にエラーが発生しました: " + e.getMessage());
			return "adderror.jsp"; // エラーページにリダイレクト
		}

	}
}