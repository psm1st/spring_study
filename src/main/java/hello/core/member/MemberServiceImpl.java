package hello.core.member;
//멤버 서비스에 대한 구현체
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member){
        memberRepository.save(member);
    } //다형성에 의해서 memberRepository의 save가 출력됨
    @Override
    public Member findMember(Long memberId){
        return memberRepository.findById(memberId);
    }
}
