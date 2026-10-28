package org.example.studentfeedback;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentFeedbackService {
    private static List<StudentFeedbackInfo> feedbackList = new ArrayList<>();

    public static StudentFeedbackInfo addFeedback(StudentFeedbackInfo feedbackInfo) {
        feedbackList.add(feedbackInfo);
        return feedbackInfo;
    }

    public static List<StudentFeedbackInfo> getAllFeedback() {
        return feedbackList;
    }
}
