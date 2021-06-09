package jpaTest.jpaShop.service;

import jpaTest.jpaShop.domain.Member;
import jpaTest.jpaShop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /**
    * 회원가입입
    **/
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }
    //회원전체조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    //회원단건조회
    public Member findMember(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
