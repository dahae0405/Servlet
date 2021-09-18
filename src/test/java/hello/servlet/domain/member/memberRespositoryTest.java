package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class memberRespositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance(); // 리파지토리 테스트. 리파지토리는 싱글톤으로 생성했으므로 getInstance로 사용


    // 순서 보자이 없기때문에, test1 과 test2 트렌젝션이 꼬이는데. 그걸 방지.
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        // given
        Member member = new Member("kim",20);

        // when
        Member savedMember = memberRepository.save( member );

        // then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat( findMember ).isEqualTo( savedMember );

    }

    @Test
    void saveAll(){
        // given
         Member member1 = new Member("yim",21);
         Member member2 = new Member("lee",21);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        //개수
        Assertions.assertThat(result.size() ).isEqualTo(2);
        //내용
        Assertions.assertThat(result).contains(member1, member2);
    }


}
