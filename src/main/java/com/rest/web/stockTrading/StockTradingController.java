package com.rest.web.stockTrading;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stockTrading/api")
public class StockTradingController {

    private final StockTradingRepository stockTradingRepository;

    @GetMapping("/getResultList")
    public ResponseEntity getResultList(String name) {

        List<StockTradingDto> info = stockTradingRepository.findStockTradingAll(name);

        return ResponseEntity.ok(info);
    }

    @GetMapping("/getResultListYear")
    public ResponseEntity getResultListYear(String name, String year) {
        HashMap<String, Object> map = new HashMap<>();

        List<StockTradingDto> info = stockTradingRepository.findStockTradingYear(name, year+"-01-01");

        Pageable sPaging = PageRequest.of(0,10,Sort.Direction.DESC,"stockPrice");
        List<StockTradingDto> topStock = stockTradingRepository.findStockTradingTop(name, sPaging);

        Pageable pPaging = PageRequest.of(0,10,Sort.Direction.DESC,"portfolioHistory");
        List<StockTradingDto> topPortfolio = stockTradingRepository.findStockTradingTop(name, pPaging);

        map.put("info", info);
        map.put("topStock", topStock);
        map.put("topPortfolio", topPortfolio);

        List<StockTradingDto> detailInfo = stockTradingRepository.findStockTradingAll(name);
        map.put("detailInfo", detailInfo);

        return ResponseEntity.ok(map);
    }

}
