package hello.hellospring.controller;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

//    private final MemberService memberService = new MemberService(); // 신규 인스턴스(객체) 생성 방법


    // 기존 Controller에 연결 방법 (
    private final MemberService memberService;

    @Autowired // 생성자에 Autowired가 있으면, 여기에 있는 MemberService를 Spring Container에 있는 MemberService에 연결시킴.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
