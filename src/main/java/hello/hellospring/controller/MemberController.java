package hello.hellospring.controller;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

//    private final MemberService memberService = new MemberService(); // 신규 인스턴스(객체) 생성 방법


    // 기존 Controller에 연결 방법 (
    private final MemberService memberService;

    @Autowired // 생성자에 Autowired가 있으면, 여기에 있는 MemberService를 Spring Container에 있는 MemberService에 연결시킴.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") // URL에 작성 시 일반적으로 GET 매핑
    public String createForm() {
        return "members/createMemberForm";

    }

    @PostMapping("/members/new")
    public String create(MemberForm form) { // html의 name 값이 MemberForm의 String name에 값이 들어가게 됨.
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); // html에서 불러오는 값을 세팅한다.
        return "members/memberList";
    }
}
