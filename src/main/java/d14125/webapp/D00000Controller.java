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
@RequestMapping("/d00000")
public class D00000Controller {
    
    public List<D00000Grades> gradesList;
    
    public D00000Controller() {
        gradesList = new ArrayList<>();
    }

    @RequestMapping("/show_grades")
    public String showGradesForm(ModelMap modelMap) {
        
        List<D00000Grades> fGradesList = new ArrayList<>();
        D00000Grades ave = new D00000Grades();
        
        if (!gradesList.isEmpty()) {
            for (D00000Grades grades : gradesList) {
                if (grades.haveF()) fGradesList.add(grades);
                ave.english += grades.english;
                ave.japanese += grades.japanese;
                ave.math += grades.math;
                ave.sum += grades.sum;
            }
            ave.english /= gradesList.size();
            ave.japanese /= gradesList.size();
            ave.math /= gradesList.size();
            ave.sum /= gradesList.size();
        }

        modelMap.addAttribute("gradesList", gradesList);
        modelMap.addAttribute("fGradesList", fGradesList);
        modelMap.addAttribute("ave", ave);
        return "d00000/show_grades";
    }
    
    @RequestMapping("/input_form")
    public String showInputForm(ModelMap modelMap) {
        return "d00000/input_form";
    }
    
    @RequestMapping("/input_result")
    public String showInputResult(
            @RequestParam("name") String name, 
            @RequestParam("english") String english,
            @RequestParam("japanese") String japanese,
            @RequestParam("math") String math) {
        D00000Grades grades = new D00000Grades();
        grades.name = name;
        grades.english = Integer.parseInt(english);
        grades.japanese = Integer.parseInt(japanese);
        grades.math = Integer.parseInt(math);
        grades.sum();
        gradesList.add(grades);

        return "/d00000/input_result";
    }

    @RequestMapping("/del_grades")
    public String delGrades(@RequestParam("delIndex") String index) {
        gradesList.remove(Integer.parseInt(index));
        return "redirect:/d00000/show_grades";
    }
    
    @RequestMapping("/clear_grades")
    public String clearGrades() {
        gradesList.clear();
        return "redirect:/d00000/show_grades";
    }
}
