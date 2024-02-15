package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {
    @Test
    @DisplayName("스프링없는 순수한 DI컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1.조회 : 호출할때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        
        //2.조회 : 호출할때마다 객체생성
        MemberService memberService2 = appConfig.memberService();

        //참고값이 다름
        System.out.println("memberService1 = "+memberService1);
        System.out.println("memberService2 = "+memberService2);

        //memberservice1 =/= memberservice2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void SingletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = "+singletonService1);
        System.out.println("singletonService2 = "+singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
       // AppConfig appConfig = new AppConfig();
       ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1.조회 : 호출할때마다 객체 생성
        MemberService memberService1 = ac.getBean("meberService",MemberService.class);
        
        //2.조회 : 호출할때마다 객체생성
        MemberService memberService2 = ac.getBean("meberService",MemberService.class);

        //참고값이 다름
        System.out.println("memberService1 = "+memberService1);
        System.out.println("memberService2 = "+memberService2);

        //memberservice1 =/= memberservice2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}
