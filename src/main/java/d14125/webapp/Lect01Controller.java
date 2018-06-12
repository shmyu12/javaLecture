package d14125.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author d14125
 */

@Controller
@RequestMapping("/lect01")
public class Lect01Controller {
    
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "こんにちは";
    }
    
    public int count = 0;
    
    @RequestMapping("/counter")
    @ResponseBody
    public String counter() {
        count++;
        return "" + count;
    }
}
