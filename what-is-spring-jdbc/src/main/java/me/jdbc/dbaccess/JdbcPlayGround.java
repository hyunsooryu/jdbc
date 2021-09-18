package me.jdbc.dbaccess;

import java.sql.*;

public class JdbcPlayGround {

    /**
     * 1. EXCEPTION
     *
     * CHECKED EXCEPTION VS UNCHECKED EXCEPTION
     *
     * 우리가 컴파일 할 때 발견되는 익셉션은 CHECKED EXCEPTION
     *
     * NullPoint -> Unchecked Exception
     *
     * 2. MYBATIS
     *
     * WHERE ID = #{id} -> PrepareStatement -> "1"
     *
     * WHERE ID = ${id} -> Statement -> 1 -> // Query Injection 공격
     *
     * selectMembers("1");
     *
     * # -> SELECT * FROM STUDY WHERE ID = "1";
     *
     * $ -> SELECT * FROM STUDY WHERE ID = 1;
     *
     *
     * 3. PrepareStatement, Statement 차이
     *
     * Cache 0
     * [틀] <SELECT ? FROM ?>
     *
     *
     * [틀] 계속 생성 Cache X
     *
     *
     *
     * @param args
     * @throws ClassNotFoundException
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/study?useUnicode=true@characterEncoding=utf8&serverTimezone=Asia/Seoul";

        //SPRING-JDBC X
        //1.Class 찾아온다.
        Class.forName(driverClassName);


        //SPRING JDBC X
        //2. Connection을 연다.
        Connection connection = DriverManager.getConnection(url, username, password);


        //3.쿼리를 만든다.
        //Statement statement = connection.createStatement();

        //4. 쿼리를 실행한 후 결과를 담는다.
        //ResultSet resultSet = statement.executeQuery("SELECT * FROM GS27");

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM GS27 WHERE id = ?");

        preparedStatement.setInt(1, 2);

        ResultSet resultSet = preparedStatement.executeQuery();

        //5. 결과를 뿌려준다.
        while(resultSet.next()){
            System.out.println("=====================================");
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("work_at"));
            System.out.println(resultSet.getString("speciality"));
            System.out.println(resultSet.getString("age"));
            System.out.println(resultSet.getString("phone_number"));
            System.out.println("=====================================");
        }

        //SPRING JDBC X
        //6. ***** 커넥션을 닫는다.
        preparedStatement.close();

        connection.close();


    }
}
