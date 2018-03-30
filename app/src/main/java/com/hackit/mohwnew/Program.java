package com.hackit.mohwnew;

/**
 * Created by praji on 31-Mar-18.
 */

public class Program {
    int completed;
    float completion_rate;
    String description;
    String title;
    int total;
    String under;

    public Program() {}

    public Program(int completed, float completion_rate, String description, String title, int total, String under) {
        this.completed = completed;
        this.completion_rate = completion_rate;
        this.description = description;
        this.title = title;
        this.total = total;
        this.under = under;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public float getCompletionRate() {
        return completion_rate;
    }

    public void setCompletionRate(float completionRate) {
        this.completion_rate = completionRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getUnder() {
        return under;
    }

    public void setUnder(String under) {
        this.under = under;
    }
}
