/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d14125.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author d14125
 */
@Controller
@RequestMapping("/lect02")
public class Lect02Controller {
    
    @RequestMapping("/hello")
    public String hello() {
        return "lect02/hello";
    }
    
    public int count = 0;
    
    @RequestMapping("/counter")
    public String counter(ModelMap modelMap) {
        count++;
        modelMap.addAttribute("count", count);
        return "lect02/counter";
    }
    
    @RequestMapping("/omikuji")
    public String omikuji(ModelMap modelMap) {
        String result;
        double rand = Math.random();
        if (rand < 0.2) {
            result = "凶";
        } else if (rand < 0.8) {
            result = "吉";
        } else {
            result = "大吉";
        }
        modelMap.addAttribute("result", result);
        return "lect02/omikuji";
    }
    
    @RequestMapping("/dice")
    public String dice(ModelMap modelMap) {
        String result;
        int rand = (int)(Math.random()*6+1);
        result = Integer.toString(rand);
        modelMap.addAttribute("result", result);
        return "lect02/dice";
    }
}
