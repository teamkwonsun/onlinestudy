package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private  MemberRepository memberRepository ;
    private  DiscountPolicy discountPolicy;



    //@Autowired //생성자가 하나일떄는 자동으로 @Autowired가 적용된다.
    public OrderServiceImpl(
            @Qualifier("memberRepository")
            MemberRepository memberRepository,
            @Qualifier("discountPolicy")
            DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Autowired
    public void init(
            @Qualifier("memberRepository")
            MemberRepository memberRepository,
            @Qualifier("discountPolicy")
            DiscountPolicy discountPolicy){
        this.memberRepository= memberRepository;
        this.discountPolicy = discountPolicy;

    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
