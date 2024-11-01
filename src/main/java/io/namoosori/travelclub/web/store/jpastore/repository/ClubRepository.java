package io.namoosori.travelclub.web.store.jpastore.repository;

import io.namoosori.travelclub.web.store.jpastore.jpo.TravelClubJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<TravelClubJpo, String> {
    //이름이 같은 club을 전부 가져와야하기 때문에, 반환타입을 리스트형태로 받아와야한다.
    List<TravelClubJpo> findAllByName(String name);
}
