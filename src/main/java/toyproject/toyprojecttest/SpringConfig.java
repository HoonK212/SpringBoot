package toyproject.toyprojecttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toyproject.toyprojecttest.repository.JpaMemberRepository;
import toyproject.toyprojecttest.repository.MemberRepository;
import toyproject.toyprojecttest.repository.MemoryMemberRepository;
import toyproject.toyprojecttest.service.MemberService;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }
}
