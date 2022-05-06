package com.rest.web.demandForecasting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demandForecasting")
public class DemandForecastingViewController {

    @GetMapping("/deepAR/view")
    public String deepAR() {
        return "model/deepAR";
    }

    @GetMapping("/deepAR/cloud/view")
    public String deepARCloud() {
        return "model/deepAR_cloud";
    }

    @GetMapping("/deepAR/calender/view")
    public String deepARCalender() {
        return "model/deepAR_calender";
    }

    @GetMapping("/gradientBoostingRegressor/view")
    public String gradientBoostingRegressor() {
        return "model/gradientBoostingRegressor";
    }

    @GetMapping("/gradientBoosting/view")
    public String gradientBoosting() {
        return "model/gradientBoosting";
    }

    @GetMapping("/prophet/view")
    public String prophet() {
        return "model/prophet";
    }

    @GetMapping("/imgClustering/view")
    public String imgClustering() {
        return "model/imgClustering";
    }

}
