package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    //엔티티 매핑 - 기본 키 매핑
    @Id //PK 알려줘야함
    @GeneratedValue(strategy = GenerationType.IDENTITY) //persist() 할 때 쿼리 날아감
    private Long id;
    @Column(name = "name")
    private String username;

    public Member() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //엔티티 매핑 - 필드와 컬럼 매핑
    /*
    private Integer age;

    @Enumerated(EnumType.STRING) //다른 데이터 타입이 추가되어도 string 이라 겹치지 않음
    private RoleType roleType;

    //과거버전
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    //최신버전
    private LocalDate localDate; //date 타입
    private LocalDateTime localDateTime; //timestamp 타입

    @Lob
    private String description;

    @Transient
    private int temp;

     */

    /*
    public Member() {

    }
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     */
}
