package hello.core.Member;
import org.assertj.core.api.Assertions; //assertj코드는 테스트를 하기 위함의 라이브러리임
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
//import hello.core.member.MemberServiceImpl;

public class MemberServiceTest {
    MemberService memberService;
    
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
        //member가 findMember와 일치한지 테스트
    }
}
