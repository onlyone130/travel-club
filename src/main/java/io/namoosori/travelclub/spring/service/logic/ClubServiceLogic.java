package io.namoosori.travelclub.spring.service.logic;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;
import io.namoosori.travelclub.spring.store.ClubStore;
import io.namoosori.travelclub.spring.util.exception.NoSuchClubException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clubService")
public class ClubServiceLogic implements ClubService {

    private ClubStore clubStore;

    public ClubServiceLogic(ClubStore clubStore) {
        this.clubStore = clubStore;
    }

    @Override
    public String registerClub(TravelClubCdo club) {
        //clubStore.create();
        TravelClub newClub = new TravelClub(club.getName(), club.getIntro());
        newClub.checkValidation();
        return clubStore.create(newClub);
    }

    @Override
    public TravelClub findClubById(String id) {
        //map에 등록된 해당 id의 객체를 찾아서 리턴해줄 것.
        return clubStore.retrieve(id);
    }

    @Override
    public List<TravelClub> findClubsByName(String name) {
        //리스트형태로 리턴해줄 것
        return clubStore.retrieveByName(name);
    }

    @Override
    public void modify(String clubId, NameValueList nameValues) {
        //NameValueList에는 변경되어야하는 값들이 들어가 있음.
        TravelClub foundedClub = clubStore.retrieve(clubId);
        if (foundedClub != null) {
            throw new NoSuchClubException("No Such club with id : " + clubId);
        }
        foundedClub.modifyValues(nameValues);
        //값이 변경된 club을 보내줘서 map에 있는 데이터도 변경되도록 함.
        clubStore.update(foundedClub);
    }

    @Override
    public void remove(String clubId) {
        if (!clubStore.exists(clubId)) {
            throw new NoSuchClubException("No Such club with id : " + clubId);
        }
        clubStore.delete(clubId);
    }
}
