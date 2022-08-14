package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 데이터 저장
    Optional<Member> findById(Long id); // 데이터 반환
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 모든 회원 리스트 반환

    void clearStore();
}
