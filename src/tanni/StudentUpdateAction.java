package tanni;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class StudentUpdateAction extends Action{
	public String execute(
		HttpServletRequest request,HttpServletResponse response
	)throws Exception{
		try{
		// リクエストパラメータから学生IDを取得し、Integerに変換、学生名を取得、コースIDを取得、、
		Integer student_id = Integer.parseInt(request.getParameter("student_id"));
		String student_name = request.getParameter("student_name");
		String course_id = request.getParameter("course_id");

		// Studentオブジェクトを作成し、取得したデータを設定
		Student p = new Student();
		p.setstudent_id(student_id);
		p.setstudent_name(student_name);
		p.setcourse_id(course_id);

		// StudentDAOのインスタンスを作成し、updateメソッドを呼び出して学生の情報を更新
		StudentDAO dao = new StudentDAO();
		dao.update(p);

		// 更新完了ページにリダイレクト
		return "updatecomplete.jsp";
		} catch (Exception e) {
			// その他の例外処理
			request.setAttribute("error", "更新中にエラーが発生しました: " + e.getMessage());
			return "updateerror.jsp"; // エラーページにリダイレクト
		}
	}
}