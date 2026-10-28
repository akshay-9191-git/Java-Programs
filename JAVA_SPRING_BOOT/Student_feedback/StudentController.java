package org.example.studentfeedback;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class StudentController {
    private final StudentFeedbackService feedbackService;

    public StudentController(StudentFeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public StudentFeedbackInfo submitFeedback(
            @RequestBody StudentFeedbackInfo feedback) {
        return feedbackService.addFeedback(feedback);
    }

    @GetMapping
    public List<StudentFeedbackInfo> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }
}
