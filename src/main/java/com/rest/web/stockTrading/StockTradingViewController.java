package com.rest.web.stockTrading;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stockTrading")
public class StockTradingViewController {

    @GetMapping("/AAPL/view")
    public String wmAnalysisRst() {
        return "model/stockTradingAAPL";
    }

}
