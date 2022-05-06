package com.rest.web.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex")
public class ExViewController {

    @GetMapping("/airflow/view")
    public String airflowWeb() {
        return "ex/airflowWeb";
    }

    @GetMapping("/akhq/view")
    public String akhqWeb() {
        return "ex/akhqWeb";
    }

}
