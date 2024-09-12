package io.namoosori.travelclub.spring.store.mapstore;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.store.MemberStore;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MemberMapStore implements MemberStore {

    //실제 CommunityMember를 저장하기 위한 컬렉션 프레임워크의 인스턴스화
    private Map<String, CommunityMember> memberMap;

    public MemberMapStore() {
        this.memberMap = new LinkedHashMap<>();
    }

    @Override
    public String create(CommunityMember member) {
        //위의 변수는 membermap에 저장하기만 하면 되는 것이기 때문에 구현이 간단하다.
        memberMap.put(member.getId(), member);
        //새로 생성된 Id를 반환할 수 있도록 한다.
        return member.getId();
    }

    @Override
    public CommunityMember retrieve(String memberId) {
        //해당 member의 id를 가지고 있는 community를 리턴하게 됨
        return memberMap.get(memberId);
    }

    @Override
    public CommunityMember retrieveByEmail(String email) {
        CommunityMember targetMember = null;
        for (CommunityMember member : memberMap.values()) {
            if (member.getEmail().equals(email)) {
                targetMember = member;
                //이메일 중복 허용X
                break;
            }
        }
        return targetMember;
    }

    @Override
    public List<CommunityMember> retrieveByName(String name) {
        //동일한 이름의 community를 list 형태로 반환하는 코드
        return memberMap.values().stream()
                .filter(member -> member.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public void update(CommunityMember member) {
        //파리미터로 넘어온 member는 이미 업데이트가 된 상태의 파라미터가 넘어온다.
        memberMap.put(member.getId(), member);
    }

    @Override
    public void delete(String memberId) {
        memberMap.remove(memberId);
    }

    @Override
    public boolean exists(String memberId) {
        return Optional.ofNullable(memberMap.get(memberId)).isPresent();
    }
}
