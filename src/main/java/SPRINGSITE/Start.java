package SPRINGSITE;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class);
    }
}


// *A PI
//1. 스프링: Java를 이용한 미리 만들어진 다양한 API 들
    //스프링 부트: 스프링 내 자주 사용도는 API 들의 기본 세팅
        //@SpringBootApplication
        //1. MVC 컴포넌트 기본값을 세팅해준다.
        //2. tomcat 내장서버 지원.
        //3. restful API HTTP (URL) 를 이용한 자원공유
    //1. SpringApplication.run(현재클래스명.class); :스프링 실행.

//2. 타임리프 : 템플릿 엔진(정적문서에 데이터를 넣어주는 프로그램)
    //타임리프 -> JS[ O ]
        //1. JSP 2. 타임리프 3.머스테치


//3. 데이터베이스
    //1. DAO: 순수 자바형식의 SQL 작성
    //2. SQL Mapper [xml] 방식 : MyDatis(DBMS)
    //3. JPA :JDBC(  jAVA - DB ) API
        //JPA 사용목적은 SQL 작성 코드 줄이기.


    //1. Spring Data JPA
    //2. MySQL DATA
