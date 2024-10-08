package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;

public class StudentDAO extends DAO{

    // 指定された学生名を含む学生情報を検索する
    public List<Student> search(String student_name) throws Exception {
        List<Student> list = new ArrayList<>();

        // データベース接続を取得
        Connection con = getConnection();

        // 学生名を含む学生情報を検索するためのSQL文を準備
        PreparedStatement st = con.prepareStatement(
                "select * from student where student_name like ?");
        st.setString(1, "%" + student_name + "%"); // プレースホルダーに値をセット
        ResultSet rs = st.executeQuery(); // クエリを実行

        // 検索結果をリストに追加
        while (rs.next()) {
            Student p = new Student();
            p.setstudent_id(rs.getInt("student_id"));
            p.setstudent_name(rs.getString("student_name"));
            p.setcourse_id(rs.getString("course_id"));
            list.add(p);
        }
        st.close(); // ステートメントをクローズ
        con.close(); // 接続をクローズ
        return list;
    }

    // 新しい学生情報を追加する
    public int insert(Student student) throws Exception {

        // データベース接続を取得
        Connection con = getConnection();

        // 学生情報を追加するためのSQL文を準備
        PreparedStatement st = con.prepareStatement("insert into student values(?, ?, ?)");

        st.setInt(1, student.getstudent_id()); // プレースホルダーに値をセット
        st.setString(2, student.getstudent_name());
        st.setString(3, student.getcourse_id());

        int line = st.executeUpdate(); // クエリを実行

        st.close(); // ステートメントをクローズ
        con.close(); // 接続をクローズ
        return line;
    }

    // 全ての学生情報を取得する
    public List<Student> GetList(
            HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        List<Student> list = new ArrayList<>();

        // データベース接続を取得
        Connection con = getConnection();

        // 全ての学生情報を取得するためのSQL文を準備
        PreparedStatement st = con.prepareStatement("select s.student_id, s.student_name, c.course_name from student s join course c on s.course_id = c.course_id");

        ResultSet rs = st.executeQuery(); // クエリを実行

        // 検索結果をリストに追加
        while (rs.next()) {
            Student p = new Student();
            p.setstudent_id(rs.getInt("student_id"));
            p.setstudent_name(rs.getString("student_name"));
            p.setcourse_name(rs.getString("course_name"));
            list.add(p);
        }
        st.close(); // ステートメントをクローズ
        con.close(); // 接続をクローズ
        return list;
    }

    // 指定された学生情報を更新する
    public int update(Student student) throws Exception {
        // データベース接続を取得
        Connection con = getConnection();

        // 学生情報を更新するためのSQL文を準備
        PreparedStatement st = con.prepareStatement("update student set student_name = ?, course_id = ? where student_id = ?");

        st.setString(1, student.getstudent_name()); // プレースホルダーに値をセット
        st.setString(2, student.getcourse_id());
        st.setInt(3, student.getstudent_id());
        int line = st.executeUpdate(); // クエリを実行

        st.close(); // ステートメントをクローズ
        con.close(); // 接続をクローズ
        return line;
    }

    // 指定された学生名を持つ学生情報を削除する
    public void delete(String student_name) throws Exception {
        // データベース接続を取得
        Connection con = getConnection();

        // 学生情報を削除するためのSQL文を準備
        PreparedStatement st = con.prepareStatement("DELETE FROM student WHERE student_name = ?");

        st.setString(1, student_name); // プレースホルダーに値をセット
        st.executeUpdate(); // クエリを実行

        st.close(); // ステートメントをクローズ
        con.close(); // 接続をクローズ
    }
}
