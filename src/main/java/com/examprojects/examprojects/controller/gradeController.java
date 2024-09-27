package com.examprojects.examprojects.controller;
import com.examprojects.examprojects.service.gradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/grade")
public class gradeController {

    @Autowired
    private gradeService gradeService;

    @GetMapping("/view")
    public String viewGrades(@RequestParam Long testId, Model model) {
        model.addAttribute("grades", gradeService.getGradesByTestId(testId));
        return "view-grades";
    }
}

