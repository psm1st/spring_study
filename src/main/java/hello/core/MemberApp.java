package hello.core;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.*;
//import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args){
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        @SuppressWarnings("resource")
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); 
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member=new Member(1L,"memberA",Grade.VIP); //1L인 이유는 long타입이어서
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find Member = "+findMember.getName());
    }
}
