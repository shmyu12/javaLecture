/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d14125.webapp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author d14125
 */
@Controller
@RequestMapping("/d14125")
public class D14125Controller {
    
    public List<D14125Subject> subjectList;
    public int creditsSum;
    public boolean canGraduate;
    
    public D14125Controller() {
        subjectList = new ArrayList<>();
        creditsSum = 0;
        canGraduate = true;
    }
    
    @RequestMapping("/subj_mgmt")
    public String showHome(ModelMap modelMap) {
        modelMap.addAttribute("subjectList", subjectList);
        modelMap.addAttribute("creditsSum", creditsSum);
        modelMap.addAttribute("canGraduate", canGraduate&&creditsSum>=20);
        return "d14125/home";
    }
    
    @RequestMapping("/input_result")
    public String showInputResult(
            @RequestParam("name") String name, 
            @RequestParam("credit") int credit,
            @RequestParam("score") double score,
            @RequestParam("attendance") int attendance,
            @RequestParam("absence") int absence,
            @RequestParam("compulsory") String compulsory)
            {
        D14125Subject subject = new D14125Subject();
        subject.name = name;
        subject.numOfCredit = credit;
        subject.score = score;
        subject.numOfAttendance = attendance;
        subject.numOfAbsence = absence;
        subject.isCompulsory = Boolean.valueOf(compulsory);
        subjectList.add(subject);
        
        if (subject.isEarnable()) creditsSum+=subject.numOfCredit;

        canGraduate &= subject.canGraduate();
        
        return "redirect:/d14125/subj_mgmt";
    }
    
    @RequestMapping("/del_subject")
    public String delGrades(@RequestParam("delIndex") int index) {
        if (subjectList.get(index).isEarnable()) creditsSum-=subjectList.get(index).numOfCredit;
        subjectList.remove(index);
        canGraduate = this.canGraduate();
        return "redirect:/d14125/subj_mgmt";
    }
    
    @RequestMapping("/clear_subjects")
    public String clearSubjects() {
        subjectList.clear();
        creditsSum = 0;
        canGraduate = true;
        return "redirect:/d14125/subj_mgmt";
    }
    
    public boolean canGraduate() {
        boolean tmp = true;
        for (D14125Subject subject: subjectList) {
            tmp &= subject.canGraduate();
        }
        return tmp;
    }
}
