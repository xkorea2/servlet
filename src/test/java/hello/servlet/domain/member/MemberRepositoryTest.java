package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("kim1", 21);
        Member member2 = new Member("kim2", 22);
        Member member3 = new Member("kim3", 23);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        //then
        List<Member> all = memberRepository.findAll();
        for (Member member : all) {
            System.out.println("member.username = " + member.getUsername());
        }
        Assertions.assertThat(all).isEqualTo(memberRepository.findAll());
        Assertions.assertThat(all.size()).isEqualTo(3);
        Assertions.assertThat(all).contains(member1, member2, member3);
    }
}
