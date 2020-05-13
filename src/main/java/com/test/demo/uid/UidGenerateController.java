package com.test.demo.uid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:cai.chaoxiong
 * @Date: 2020/5/13 10:29
 */
@Controller
@RequestMapping
public class UidGenerateController {
    @Autowired
    private UidGenService uidGenService;

    @GetMapping("/getuid")
    @ResponseBody
    public String getUid() {
        return String.valueOf( uidGenService.getUid() );
    }


}
