package class1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws SQLException {
        //输出数据
        String sql = "SELECT * FROM task1.学生信息";
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement st = conn.prepareStatement(sql);
        //执行查询语句并返回结果集
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            //注意：这里要与数据库里的字段对应
            System.out.print("姓名：" + rs.getString("姓名") + " ");
            System.out.print("学号：" + rs.getString("学号") + " ");
            System.out.print("学院：" + rs.getString("学院") + " ");
            System.out.print("专业：" + rs.getString("专业") + " ");
            System.out.print("\n");
        }
            conn.commit();
        //增加数据
            String sql2 = "insert into task1.学生信息(学号, 姓名, 学院, 专业) VALUES (?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql2);
            pst.setString(1, "20201050499");
            pst.setString(2, "郑楠");
            pst.setString(3, "信息学院");
            pst.setString(4, "物联网工程");
            int result = pst.executeUpdate();
            if (result != 0) {
            System.out.println("插入成功！");
        }
            conn.commit();
        //更新数据
           String sql3 = "update task1.学生信息 set 学号=20201050435 where 学号=20201050499";
           PreparedStatement pst1 = conn.prepareStatement(sql3);
           int re3 = pst1.executeUpdate();
           if (re3 != 0) {
            System.out.println("更新成功！");
        }
           conn.commit();
        //删除数据
           String sql4 = "delete from task1.学生信息 where 学号=20201050435";
           PreparedStatement pst2 = conn.prepareStatement(sql4);
           int re4 = pst2.executeUpdate();
           if (re4 != 0) {
            System.out.println("删除成功！");
          }
            conn.commit();
            conn.close();
    }
}
