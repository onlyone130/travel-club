package io.namoosori.travelclub.web.store.jpastore.jpo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//lombok 관련 설정
@Getter
@Setter
@NoArgsConstructor
public class TravelClubJpo {

    //jpa에 의해서 테이블이 생성되는 것을 확인할 수 있다.
    @Id
    private String id;
    private String name;
    private String intro;
    private long foundationTime;

}
