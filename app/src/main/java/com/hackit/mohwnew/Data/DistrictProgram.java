package com.hackit.mohwnew.Data;

public class DistrictProgram {
    private float completion_rate;
    private String title;
    private String description;
    private String under;
    private boolean completionStatus;

    public DistrictProgram() {
    }

    public DistrictProgram(String title, String description, boolean completionStatus) {
        this.title = title;
        this.description = description;
        this.completionStatus = completionStatus;
    }

    public DistrictProgram(float completion_rate, String title, String description, String under, boolean completionStatus) {
        this.completion_rate = completion_rate;
        this.title = title;
        this.description = description;
        this.under = under;
        this.completionStatus = completionStatus;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    public float getCompletion_rate() {
        return completion_rate;
    }

    public void setCompletion_rate(float completion_rate) {
        this.completion_rate = completion_rate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnder() {
        return under;
    }

    public void setUnder(String under) {
        this.under = under;
    }
}
