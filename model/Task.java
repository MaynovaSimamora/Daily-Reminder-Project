package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task implements ITask {
    private String title;
    private LocalDate dueDate;
    private boolean isCompleted; 

    public Task(String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    @Override public String getTitle() { return title; }
    @Override public LocalDate getDueDate() { return dueDate; }
    @Override public boolean isOverdue() { return dueDate.isBefore(LocalDate.now()); }
    @Override public boolean isCompleted() { return isCompleted; } 
    @Override public void markAsCompleted() { isCompleted = true; } 

    @Override
    public void displayInfo() {
        String status = isCompleted ? "[✓]" : "[ ]";
        String deadlineStatus = isOverdue() ? " (LEWAT)" : 
            " (SISA " + ChronoUnit.DAYS.between(LocalDate.now(), dueDate) + " HARI)";
        System.out.println(status + " " + title + " | Deadline: " + dueDate + deadlineStatus);
    }
}