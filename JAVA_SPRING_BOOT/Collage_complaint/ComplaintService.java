package org.example.collagecomplaint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ComplaintService {
    private final List<Complaint> complaintList = new ArrayList<>();
    private int nextId = 1;

    public Complaint addComplaint(Complaint complaint) {
        complaint.setId(nextId++);
        complaint.setStatus("PENDING");
        complaintList.add(complaint);
        return complaint;
    }

    public List<Complaint> getAllComplaints() {
        return complaintList;
    }
}
