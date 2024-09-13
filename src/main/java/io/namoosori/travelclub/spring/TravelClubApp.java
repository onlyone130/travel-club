package io.namoosori.travelclub.spring;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TravelClubApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        String[] beanNames = context.getBeanDefinitionNames();
//      System.out.println(Arrays.toString(beanNames));

        //MemberService의 인스턴스를 참조할 수 있게 됨.
        MemberService memberService = context.getBean("memberServiceLogic", MemberService.class);

        String memberId = memberService.registerMember(
                new MemberCdo(
                        "test@nextree.io",
                        "Kim",
                        "Test Member",
                        "010-0000-0000",
                        "2010.10.10"));

        CommunityMember foundedMember = memberService.findMemberById(memberId);
        //해당 데이터가 있는지 확인하는 형태. formal한 형태는 아님
        System.out.println(foundedMember.toString());

//        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "Test TravelClub");
//        ClubService clubService = context.getBean("clubService", ClubService.class);
//
//        String clubId = clubService.registerClub(clubCdo);
//
//        TravelClub foundedClub = clubService.findClubById(clubId);
//        System.out.println("Club name " + foundedClub.getName());
//        System.out.println("Club intro " + foundedClub.getIntro());
//        //System.out.println("Club foundationTime " + foundedClub.getFoundationTime());
//        System.out.println("Club name " + new Date(foundedClub.getFoundationTime()));
    }
}