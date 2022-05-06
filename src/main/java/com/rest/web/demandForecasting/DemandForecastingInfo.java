package com.rest.web.demandForecasting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder // builder를 사용할수 있게 합니다.
@Entity // jpa entity임을 알립니다.
@Getter // user 필드값의 getter를 자동으로 생성합니다.
@Setter
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Post Entity에서 User와의 관계를 Json으로 변환시 오류 방지를 위한 코드
public class DemandForecastingInfo {

    @Id
    private Long idx;

    private String id;
    private String date;
    private int itemQty;
    private double q10;
    private double q50;
    private double q90;
    private String infoType;

}
