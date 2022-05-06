package com.rest.web.demandForecasting;

import com.rest.common.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/demandForecasting/api")
public class DemandForecastingController {

    private final DemandForecastingRepository analysisResultInfoRepository;

    private final ResponseService responseService;

    @GetMapping("/getResultList")
    public ResponseEntity getResultList(String type) {

        List<DemandForecastingInfoDto> info = analysisResultInfoRepository.findResultList(type);

        return ResponseEntity.ok(responseService.getListResult(info));
    }

    @GetMapping("/getResultListById")
    public ResponseEntity getResultListById(String id, String type) {

        List<DemandForecastingInfoDto> info = analysisResultInfoRepository.findResultListByIdType(id, type);
        //List<AnalysisResultInfoDto> list = info.stream().map(m -> new AnalysisResultInfoDto(m.getId(), m.getDate(), (long) m.getItemQty(), m.getQ10(), m.getQ50(), m.getQ90())).collect(Collectors.toList());

        return ResponseEntity.ok(responseService.getListResult(info));
    }

    @GetMapping("/getResultListByIdName")
    public ResponseEntity getResultListByIdName(String type, String name) {
        HashMap<String, Object> map = new HashMap<>();

        List<DemandForecastingInfoDto> info = analysisResultInfoRepository.findResultListByTypeName(type, name);

        List<DemandForecastingInfoDto> ordrInfo = analysisResultInfoRepository.findResultListByTypeNameOrderItem(type, name);

        map.put("info", info);
        map.put("ordr", ordrInfo);

        return ResponseEntity.ok(responseService.getMapResult(map));
    }

}
