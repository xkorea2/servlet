package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;
    private String username;
    private int age;

    public Member() {   //기본 생성자도 만들어준다.
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
