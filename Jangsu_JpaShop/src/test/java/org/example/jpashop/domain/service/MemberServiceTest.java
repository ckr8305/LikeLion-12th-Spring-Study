package org.example.jpashop.domain.service;

import jakarta.persistence.EntityManager;
import org.example.jpashop.domain.Member;
import org.example.jpashop.domain.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    public void 회원가입() throws Exception{
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long savedId = memberService.join(member);

        // then
        // entityManager.flush(); // 강제로 DB의 영속성 컨텍스트에 쿼리를 날림
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    public void 중복회원_검사() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");
        // when
        memberService.join(member1);
        try {
            memberService.join(member2);
        } catch (IllegalStateException e) {
            return;
        }

        // then
        fail("예외가 발생해야 합니다.");
    }
}