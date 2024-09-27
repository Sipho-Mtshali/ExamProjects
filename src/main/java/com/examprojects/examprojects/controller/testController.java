package com.examprojects.examprojects.controller;
import com.examprojects.examprojects.model.testModel;
import com.examprojects.examprojects.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class testController {

    @Autowired
    private testService testService;

    @GetMapping("/create")
    public String createTestForm(Model model) {
        model.addAttribute("test", new testModel());
        return "create_test";
    }

    @PostMapping("/create")
    public String createTest(@ModelAttribute testModel test) {
        testService.createTest(test);
        return "redirect:/lecturer/dashboard";
    }

    @GetMapping("/edit/{id}")
    public String editTestForm(@PathVariable Long id, Model model) {
        testModel test = testService.getTestById(id);
        model.addAttribute("test", test);
        return "edit-test";
    }

    @PostMapping("/edit")
    public String editTest(@ModelAttribute testModel test) {
        testService.createTest(test);
        return "redirect:/lecturer/dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deleteTest(@PathVariable Long id) {
        testService.deleteTest(id);
        return "redirect:/lecturer/dashboard";
    }
}

