package model;

import java.time.LocalDate;

public class PriorityTask extends Task {
    private String priority;

    public PriorityTask(String title, LocalDate dueDate, String priority) {
        super(title, dueDate);
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  ⚠ Prioritas: " + priority);
    }
}