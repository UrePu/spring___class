package SPRINGSITE.entity;


import javax.persistence.*;
@Entity //해당 클래스를 엔티티(DB테이블고 매핑] 로 사용
@Table(name ="test") //DB 사용될 테이블 이름 정하기
public class TestEntity { //클래스

    @Id //기본키 설정 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동번호 auto key
    public int no; //필드
    @Column(name = "content") //DB에서 사용할 필드명 정하기.
    public String content; //내용

}


//jpa JAVA <-----JPA(매핑) -----> DB
    //1. java 클래스를 엔티티화 하면 DB 테이블이 자동 생성돈다


    //Entity클래스             table
    //필드                    column