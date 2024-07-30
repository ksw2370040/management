package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"*.action"})
public class FrontController extends HttpServlet {

    // HTTP POSTリクエストを処理するメソッド
    public void doPost(
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        // レスポンスに書き込みを行うためのPrintWriterを取得
        PrintWriter out = response.getWriter();
        try {
            // リクエストパスからアクション名を取得
            String path = request.getServletPath().substring(1);
            String name = path.replace(".a", "A").replace("/", ".");
            // アクション名に対応するクラスを動的にロードし、インスタンスを生成
            Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();
            // アクションのexecuteメソッドを実行し、フォワード先のURLを取得
            String url = action.execute(request, response);
            // 指定されたURLにリクエストをフォワード
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            // 例外が発生した場合、スタックトレースをレスポンスに出力
            e.printStackTrace(out);
        }
    }

    // HTTP GETリクエストを処理するメソッド
    public void doGet(
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        // POSTメソッドと同じ処理を行う
        doPost(request, response);
    }
}
