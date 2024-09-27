package com.examprojects.examprojects.controller;

import com.examprojects.examprojects.model.testModel;
import com.examprojects.examprojects.model.lecturerModel;
import com.examprojects.examprojects.service.gradeService;
import com.examprojects.examprojects.service.testService;
import com.examprojects.examprojects.service.lecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lecturer")
public class lecturerController {

    @Autowired
    private testService testService;

    @Autowired
    private gradeService gradeService;

    @Autowired
    private lecturerService lecturerService;

    @GetMapping("/dashboard")
    public String getDashboard(Model model, @RequestParam Long lecturerId) {
        List<testModel> tests = testService.getTestsByLecturerId(lecturerId);
        model.addAttribute("tests", tests);
        model.addAttribute("lecturerId", lecturerId); // Ensure lecturerId is passed to the view
        return "lecturer_dashboard";
    }

    @GetMapping("/create_test")
    public String createTestForm(Model model) {
        model.addAttribute("test", new testModel());
        return "create_test";
    }

    @PostMapping("/create_test")
    public String createTest(@ModelAttribute testModel test, @RequestParam Long lecturerId, Model model) {
        lecturerModel lecturer = lecturerService.getLecturerById(lecturerId);
        test.setLecturer(lecturer);
        testService.createTest(test);
        return "redirect:/lecturer/dashboard?lecturerId=" + lecturerId;
    }

    @GetMapping("/edit-test/{id}")
    public String editTestForm(@PathVariable Long id, Model model) {
        testModel test = testService.getTestById(id);
        model.addAttribute("test", test);
        return "edit-test";
    }

    @GetMapping("/delete-test/{id}")
    public String deleteTest(@PathVariable Long id, @RequestParam Long lecturerId) {
        testService.deleteTest(id);
        return "redirect:/lecturer/dashboard?lecturerId=" + lecturerId;
    }

    @GetMapping("/view-grades")
    public String viewGrades(@RequestParam Long testId, Model model) {
        model.addAttribute("grades", gradeService.getGradesByTestId(testId));
        return "view-grades";
    }
}
