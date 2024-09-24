package io.namoosori.travelclub.spring.service.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TravelClubCdo extends io.namoosori.travelclub.web.service.sdo.TravelClubCdo implements Serializable {
    //
    private String name;
    private String intro;
}
