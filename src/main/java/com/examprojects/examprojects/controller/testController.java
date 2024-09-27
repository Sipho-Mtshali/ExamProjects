package com.examprojects.examprojects.controller;

import com.examprojects.examprojects.model.testModel;
import com.examprojects.examprojects.model.lecturerModel; // Ensure you import the lecturerModel
import com.examprojects.examprojects.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {
    private static final Logger logger = LoggerFactory.getLogger(testController.class);
    @Autowired
    private testService testService;

    @GetMapping("/create_test")
    public String createTestForm(@RequestParam Long lecturerId, Model model) {
        model.addAttribute("test", new testModel());
        model.addAttribute("lecturerId", lecturerId); // Add lecturerId to the model
        return "create_test"; // Ensure this corresponds to your view name
    }

    @PostMapping("/create_test")
    public String createTest(@ModelAttribute testModel test, @RequestParam Long lecturerId, RedirectAttributes redirectAttributes) {
        try {
            // Create a new lecturerModel object and set the ID
            lecturerModel lecturer = new lecturerModel();
            lecturer.setId(lecturerId); // Set the lecturer ID

            // Set the lecturer in the test
            test.setLecturer(lecturer);

            // Save the test
            testService.createTest(test);
            redirectAttributes.addFlashAttribute("success", "Test created successfully!"); // Success message
            return "redirect:/lecturer/dashboard";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error creating test: " + e.getMessage()); // Error message
            logger.error("Error creating test: ", e); // Log the exception stack trace
            return "redirect:/test/create_test?lecturerId=" + lecturerId; // Redirect back to the form
        }
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
