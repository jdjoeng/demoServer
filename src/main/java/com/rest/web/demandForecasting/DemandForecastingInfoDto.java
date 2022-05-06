package com.rest.web.demandForecasting;

import lombok.Data;

@Data
public class DemandForecastingInfoDto {
    private String id;
    private String date;
    private Long itemQty;
    private double q10;
    private double q50;
    private double q90;
    private String infoType;

    private String name;
    private String yearMonth;

    public DemandForecastingInfoDto(String id, Long itemQty, double q10, double q50, double q90) {
        this.id = id;
        this.itemQty = itemQty;
        this.q10 = q10;
        this.q50 = q50;
        this.q90 = q90;
    }

    public DemandForecastingInfoDto(String id, String date, int itemQty, double q10, double q50, double q90) {
        this.id = id;
        this.date = date;
        this.itemQty = (long) itemQty;
        this.q10 = q10;
        this.q50 = q50;
        this.q90 = q90;
    }

    public DemandForecastingInfoDto(String id, String name, Long itemQty, double q10, double q50, double q90) {
        this.id = id;
        this.name = name;
        this.itemQty = itemQty;
        this.q10 = q10;
        this.q50 = q50;
        this.q90 = q90;
    }

    public DemandForecastingInfoDto(String id, String name, String date, int itemQty, double q10, double q50, double q90) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.itemQty = (long) itemQty;
        this.q10 = q10;
        this.q50 = q50;
        this.q90 = q90;
    }
}
