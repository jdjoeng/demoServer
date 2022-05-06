package com.rest.web.retinex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RetinexViewController {

    @GetMapping("/retinex/view")
    public String retinex() {
        return "vision/retinex";
    }

}
