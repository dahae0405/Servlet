package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  동시성 문제가 고려 되지않기때문에, 실무에서는 concurrentHashMap, AtomicLong 사용 고려
 *
 *  싱글톤으로 만들기
 *      ㄴ mvc에서는 싱글통으로 자동 보장.
 *
 * **/
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId( ++sequence );
        store.put( member.getId(), member );
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>( store.values() );
    }

    public void clearStore(){
        store.clear();
    }

}
