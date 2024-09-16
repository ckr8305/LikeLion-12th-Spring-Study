package org.likelion.spring.service;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.likelion.spring.domain.Member;
import org.likelion.spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        // given 주어졌을때
        Member member = new Member();
        member.setName("kim");

        // when 실행 하면
        Long savedId = memberService.join(member);

        // then 실행 결과
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when
        memberService.join(member1);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);    // 같은 이름이기에 예외 발생 - 이미 존재 하는 회원 예외 발생
        });

        // then
        assertEquals("이미 존재하는 회원입니다.", exception.getMessage());
    }
}