package io.namoosori.travelclub.spring.store.mapstore;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.store.ClubStore;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("clubStore")
public class ClubMapStore implements ClubStore {

    private Map<String, TravelClub> clubMap;

    public ClubMapStore() {
        this.clubMap = new LinkedHashMap<>();
    }

    @Override
    public String create(TravelClub club) {
        clubMap.put(club.getId(), club);
        return club.getId();
    }

    @Override
    public TravelClub retrieve(String clubId) {
        return clubMap.get(clubId);
    }

    //동일한 이름의 클럽이 있을 수 있고, 똑같은 이름을 가진 클럽을 모두 반환하겠다.
    @Override
    public List<TravelClub> retrieveByName(String name) {
        return clubMap.values().stream()
                .filter( club -> club.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public void update(TravelClub club) {
        //업데이트된 상태로 넘어옴.
        clubMap.put(club.getId(), club);
    }

    @Override
    public void delete(String clubId) {
        clubMap.remove(clubId);
    }

    @Override
    public boolean exists(String clubId) {
        //해당 클럽id를 가지고 있는지 확인.
        //return clubMap.containsKey(clubId);
        return Optional.ofNullable(clubMap.get(clubId)).isPresent();
    }
}
