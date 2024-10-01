package io.namoosori.travelclub.web.store.jpastore;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.store.ClubStore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubJpaStore implements ClubStore {
    @Override
    public String create(TravelClub club) {
        return "";
    }

    @Override
    public TravelClub retrieve(String clubId) {
        return null;
    }

    @Override
    public List<TravelClub> retrieveByName(String name) {
        return List.of();
    }

    @Override
    public List<TravelClub> retrieveAll() {
        return List.of();
    }

    @Override
    public void update(TravelClub club) {

    }

    @Override
    public void delete(String clubId) {

    }

    @Override
    public boolean exists(String clubId) {
        return false;
    }
}
