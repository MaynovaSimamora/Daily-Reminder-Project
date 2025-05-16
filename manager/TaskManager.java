package manager;

import model.ITask;
// import model.Task;
import model.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TaskManager {
    private List<ITask> tasks = new ArrayList<>();  

    public void addTask(ITask task) {
        tasks.add(task);
        System.out.println("✓ Tugas ditambahkan: " + task.getTitle());
    }

    public void showAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Belum ada tugas!");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print((i+1) + ". ");
            tasks.get(i).displayInfo();
        }
    }

    public void removeCompletedTasks() {
        Iterator<ITask> iterator = tasks.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            ITask task = iterator.next();
            if (task.isCompleted()) {
                iterator.remove();
                count++;
            }
        }
        System.out.println(count + " tugas selesai dihapus");
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
            System.out.println("✓ Tugas selesai: " + tasks.get(index).getTitle());
        } else {
            throw new IndexOutOfBoundsException("Nomor tugas tidak valid.");
        }
    }

    public boolean hasCompletedTasks() {
        for (ITask task : tasks) {
            if (task.isCompleted()) {
                return true;
            }
        }
        return false;
    }

    public void showTasksByDeadline() {
        List<ITask> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort(Comparator.comparing(ITask::getDueDate));

        System.out.println("=== Tugas Berdasarkan Deadline Terdekat ===");
        for (ITask t : sortedTasks) {
            t.displayInfo();
            System.out.println();
        }
    }


    public List<ITask> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public void checkOverdueTasks() {
        tasks.stream()
            .filter(task -> !task.isCompleted() && task.isOverdue())
            .forEach(task -> System.out.println("⚠ " + task.getTitle() + " sudah lewat deadline!"));
    }
}