package org.example.studentfeedback;

public class StudentFeedbackInfo {
    private String name;
    private String subject;
    private String feedback;

    public StudentFeedbackInfo() {
    }

    StudentFeedbackInfo(String name, String subject, String feedback) {
        this.name = name;
        this.subject = subject;
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
