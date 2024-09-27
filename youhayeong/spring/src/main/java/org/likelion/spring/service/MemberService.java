package org.likelion.spring.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.likelion.spring.domain.Member;
import org.likelion.spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기에는 readonly true / 쓰기에는 x = 기본적으로 true 넣고 쓰기에만 어노테이션
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); // 회원 검증 로직(중복 회원)
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty())
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }

    // 회원 전체 조회 - transactional readonly = true로
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 단일 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
