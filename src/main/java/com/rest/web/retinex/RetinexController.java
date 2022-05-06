package com.rest.web.retinex;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/retinex/api")
public class RetinexController {

    private final RetinexService retinexService;

    @PostMapping("/getImage")
    public ResponseEntity getImage(MultipartHttpServletRequest request) throws IOException {
        Map<String, String> reslt = retinexService.callRetinex(request);
        return ResponseEntity.ok(reslt);
    }

}
