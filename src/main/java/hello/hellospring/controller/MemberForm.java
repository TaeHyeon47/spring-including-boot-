package hello.hellospring.controller;

public class MemberForm {
    private String name; // 여기에 html 상의 name 값이 들어오게 된다.

    public String getName() {
        return name;
    }

    public void setName(String name) { // name 값이 들어갈 때 setName을 통해 들어간다.
        this.name = name;
    }
}
