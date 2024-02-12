package hello.core;
import hello.core.member.*;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args){
        MemberService memberService = new MemberServiceImpl();
        Member member=new Member(1L,"memberA",Grade.VIP); //1L인 이유는 long타입이어서
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find Member = "+findMember.getName());
    }
}
