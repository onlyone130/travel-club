package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.web.service.MembershipService;
import io.namoosori.travelclub.web.service.sdo.MemberCdo;
import io.namoosori.travelclub.web.service.sdo.MembershipCdo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MembershipController {

    private MembershipService membershipService;

    public MembershipController(MembershipService membershipService){
        this.membershipService = membershipService;
    }

    @PostMapping //localhost:8090/member
    public String register(@RequestBody MembershipCdo membershipCdo){
        return membershipService.registerMembership(membershipCdo);
    }
}
