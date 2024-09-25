package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.shared.NameValueList;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//사용자 요청을 처리하기 위해서 서비스에 접근하는 클래스를 ControllerService라고 한다.
@RestController
//@Controller 라는 어노테이션을 사용할 수도 있지만 "뷰페이지"가 있을 경우에만 보통 사용한다.
public class ClubController {

    //url을 통해서 접근을 하니까 test()라는 메소드에 접근할 수 있는 메소드를 정의해야함. annotation을 써주면 된다. test용 코드.
//    @GetMapping("/test")
//    public String test() {
//        return "Hello Spring MVC~~";
//    }

    private ClubService clubService;

    //생성자를 통한 주입을 받게 된다.
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping("/club") //localhost:8090/club
    public String register(@RequestBody TravelClubCdo travelClubCdo) {
        return clubService.registerClub(travelClubCdo);
    }

    //retreive 매소드 구현. 전체 club 조회
    @GetMapping("/club/all")
    public List<TravelClub> findAll() {
        return clubService.findAll();
    }

    //url을 보낼 때, clubId라는 값을 find() 안에 넣는 동작
    @GetMapping("/club/{clubId}")
    public TravelClub find(@PathVariable String clubId){
        return clubService.findClubById(clubId);
    }

    //아래와 같은 코드로 실행하게 되면 어떠한 url을 가져와야하는지 모르기 때문에 500 에러가 발생하게 된다.
    //@GetMapping("/club/{name}")
    @GetMapping("/club") //localhost:8090/club?name=JavaClub
    public List<TravelClub> findByName(@RequestParam String name) { //getMapping에 있어서 url 3개가 구분이 되게 된다. url 충돌 발생 사라짐.
        System.out.println(name);
        return clubService.findClubsByName(name);
    }

    //수정할 때는 putMapping이다. 파라미터를 보낼 때 http body에 담겨서 온다. 그렇기 때문에 requestbody annotation을 사용해야한다.
    @PutMapping("/club/{clubId}")
    public void modify(@PathVariable String clubId, @RequestBody NameValueList nameValueList){
        clubService.modify(clubId, nameValueList);
    }

    @DeleteMapping("/club/{clubId}")
    public void delete(@PathVariable String clubId){
        clubService.remove(clubId);
    }
}
