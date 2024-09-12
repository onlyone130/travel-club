package io.namoosori.travelclub.spring.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NameValue {
    //두가지 필드를 가지는 클래스
    private String name;
    private String value;

    @Override
    public String toString() {
        //
        StringBuilder builder = new StringBuilder();

        builder.append("NameValue{")
                .append("name='").append(name).append('\'')
                .append(", value='").append(value).append('\'')
                .append('}');

        return builder.toString();
    }
}
