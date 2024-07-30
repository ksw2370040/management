package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
    static DataSource ds; // データソースの静的フィールド

    // データベース接続を取得するメソッド
    public Connection getConnection() throws Exception {
        if (ds == null) { // データソースがまだ初期化されていない場合
            InitialContext ic = new InitialContext(); // 初期コンテキストを取得
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/kadai"); // データソースをJNDIルックアップ
        }
        return ds.getConnection(); // データソースから接続を取得して返す
    }
}
