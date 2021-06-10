# 📖 인터페이스

## 인터페이스(interface)

### 인터페이스란? - 사전적 의미
하나의 시스템을 구성하는 2개의 구성 요소(하드웨어, 소프트웨어) 또는 2개의 시스템이 상호 작용할 수 있도록 접속되는 경계(boundary), 이 경계에서 상호 접속하기 위한 하드웨어, 소프트웨어, 조건, 규약 등을 포괄적으로 가리키는 말

### 실생활 인터페이스란?

### JDBC(Java Database Connectivity)를 통한 인터페이스 이해하기

#### MSSQL DB로 서비스 시작
jdbc_interface1.PNG

#### 2년 후 상황
- 서비스 대박났다. 2년 사이에 데이터량이 증가하는 속도가 엄청 빨라졌다.
- 최초 DB 서버 한 대에서 데이터량 많아지면서 16대로 증가
- MSSQL 한 대 구매 비용이 2년 전 1천만원에서 5천만원으로 올랐다. 조만간 새로운 버전이 나오면서 비용 증가 예상
- 비용을 감당하려면 무료 데이터베이스인 MySQL로 변경하는 것이 좋겠다.
  jdbc_interface2.PNG

#### 문제 상황
- 데이터베이스에 대한 작업을 담당하는 자바 소스 코드가 MSSQL와 밀접하게 연관되어 있어 이 소스 코드를 변경하는데 많은 비용이 발생한다.
- 많은 소스 코드가 변경되면서 서비스의 안정성을 확보할 수 없다.

#### 해결 방법
- 자바 소스 코드와 DB 작업에 필요한 공통 부분을 추상화(abstraction)해 표준으로 만든다.
- 각 DB 회사들이 이 표준에 따라 구현하도록 한다.
  jdbc_interface3.PNG
- 자바를 기반으로 하는 소프트웨어는 DB 종류는 고려하지 않고 인터페이스만 지키면서 구현을 하면 추후 DB가 변경되더라도 소스 코드를 수정하지 않아도 된다.

#### JDBC 코드
- 데이터베이스 회사에서 구현한 코드를 로딩하기
```
public class DriverManager {
    public static Connection getConnection() throws SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql:주소:포트/DB명" , "username", "password");
    }
}
```
- 데이터베이스 연결 인터페이스(Connection)
```
public interface Connection  {
    PreparedStatement prepareStatement(String sql) throws SQLException;
}
```
- SQL 쿼리에 인자를 전달하고 쿼리를 실행한다.
```
public interface PreparedStatement extends Statement {
    void setInt(int parameterIndex, int x) throws SQLException; // int 값 전달

    void setString(int parameterIndex, String x) throws SQLException; // String 값 전달

    […] // 자바의 기본 데이터베이스 모두 지원

    ResultSet executeQuery() throws SQLException; // select 쿼리

    int executeUpdate() throws SQLException; // insert, update, delete 쿼리
}
```
- select 쿼리를 실행한 결과를 자바 데이터로 변환
```
public interface ResultSet {
    int getInt(int columnIndex) throws SQLException;

    String getString(String columnLabel) throws SQLException;

    [...] // 자바가 지원하는 데이터 타입에 대한 메소드 존재함.

    boolean isFirst() throws SQLException;

    boolean isLast() throws SQLException;
}
```

#### 인터페이스(interface)
- interface는 자바에서 한 단계 더 높은 추상화를 하기 위해 사용된다.
- interface는 구현 로직은 존재하지 않으며 메소드에 대한 입력(input), 출력(output)만 정의하고 있다.
- interface를 활용해 추상화를 하는 이유는 소프트웨어에 변경이 발생할 경우 소스 코드에 변경을 최소화함으로써 유지보수 비용을 줄이고, 변화에 빠르게 대응하기 위함이다.
- 추상화를 함으로써 미래의 변화에 빠르게 대응할 수 있지만 추상화를 하려면 추상화에 따른 개발 비용이 발생한다.