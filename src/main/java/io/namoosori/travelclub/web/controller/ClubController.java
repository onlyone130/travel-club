package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.web.service.ClubService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
