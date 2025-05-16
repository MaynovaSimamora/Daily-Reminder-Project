package model;

import java.time.LocalDate;

public interface ITask {
    String getTitle();
    LocalDate getDueDate();
    void displayInfo();
    boolean isOverdue();
    boolean isCompleted();
    void markAsCompleted(); 
}