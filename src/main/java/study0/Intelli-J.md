###  자주 사용되는 단축키

- import 정리 (Optimize imports) : Ctrl + Alt + O

- 자동 코드 정렬 : Ctrl + Alt + L

- 자바클래스 main메서드 자동생성 : main + Tab

- 생성자,Getter와Setter,메서드 오버라이딩 자동완성 :	Alt + Insert

- 변수 추출하기 : Ctrl + Alt + V

- 메서드 추출하기 : Ctrl + Alt + M

- gradle.. maven..
  
  - 그래들 환경 구축
    - https://lifove.tistory.com/57

  - 그래들 설치
    - https://thecodinglog.github.io/gradle/2019/09/11/install-gradle-in-windows.html

  - 그래들 설정
    - https://kjkjjang.wordpress.com/2019/04/15/intellij-%EC%82%AC%EC%9A%A9gradle-%EA%B8%B0%EB%B0%98-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%ED%99%98%EA%B2%BD%EA%B5%AC%EC%84%B1/

  - 테스트 파일 설정
    - https://devms.tistory.com/50

  - 이렇게 생긴 bulid.gradle 에
    - https://unluckyjung.github.io/develop-setting/2021/02/12/Junit5-AssertJ-Init/

  - 라이브러리 의존성 설정
    - https://www.daleseo.com/assertj/

  - 최상위 폴더 - 마우스 우클릭 - add framework support...

  - pom 에 아래와 같이 추가
    - https://stackoverflow.com/questions/39831447/maven-assertj-intellij-confusion-with-scope
    - https://assertj.github.io/doc/
```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

    <groupId>groupId</groupId>
    <artifactId>programmers</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
            <!-- use 2.9.1 for Java 7 projects -->
            <version>3.20.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>


</project>
```
