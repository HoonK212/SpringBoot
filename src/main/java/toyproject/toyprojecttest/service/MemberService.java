package toyproject.toyprojecttest.service;

import org.springframework.stereotype.Service;
import toyproject.toyprojecttest.domain.Member;
import toyproject.toyprojecttest.repository.MemberRepository;
import toyproject.toyprojecttest.repository.MemoryMemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
        회원 가입
         */
    public Long join(Member member) {

//        long start = System.currentTimeMillis();

//        try {
            validateDulicateMember(member); // 중복 회원 검증
            memberRepository.save(member);
            return member.getId();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join -> " + timeMs + "ms");
//        }
    }

    private void validateDulicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /*
    전체 회원 조회
     */
    public List<Member> findMembers() {

//        long start = System.currentTimeMillis();

//        try {
            return memberRepository.findAll();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("findMembers -> " + timeMs + "ms");
//        }
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
