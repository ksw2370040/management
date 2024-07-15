package tanni;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import tool.Action;

public class StudentDeleteAction extends Action{
	public String execute(
			HttpServletRequest request,HttpServletResponse response
		)throws Exception{
		try{
		// リクエストパラメータから学生名を取得
		String student_name = request.getParameter("student_name");

		// StudentDAOのインスタンスを作成
		StudentDAO dao = new StudentDAO();

		// 学生名をもとにデータベースから学生のデータを削除
		dao.delete(student_name);

		// deletecomplete.jspページにリダイレクト
		return "deletecomplete.jsp";
    	} catch (Exception e) {
        // 例外処理
    		request.setAttribute("error", "削除中にエラーが発生しました: " + e.getMessage());
        	return "deleteerror.jsp"; // エラーページにリダイレクト
    	}
	}

}