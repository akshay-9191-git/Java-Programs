package org.example.collagecomplaint;

public class Complaint {
    private int id;
    private String description;
    private String category;
    private String status;

    public Complaint() {
    }

    public Complaint(int id, String description,
                     String category, String status) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
