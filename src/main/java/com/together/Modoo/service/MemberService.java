package com.together.Modoo.service;

import com.together.Modoo.model.Member;
import com.together.Modoo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(Member member) {
        memberRepository.save(member);
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void update(Member member) {
        Optional<Member> optionalMember = memberRepository.findById(member.getId());
        if(optionalMember.isEmpty())
            throw new RuntimeException();

        Member member1 = optionalMember.get();
        member1.update(member);
    }

    public void delete(Long id){
        return;
    }
}
