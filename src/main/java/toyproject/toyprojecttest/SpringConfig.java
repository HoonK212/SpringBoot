package toyproject.toyprojecttest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toyproject.toyprojecttest.repository.MemberRepository;
import toyproject.toyprojecttest.repository.MemoryMemberRepository;
import toyproject.toyprojecttest.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
