package storage;

import model.Task;
import java.io.*;
import java.util.List;

public abstract class FileStorage {
    // Abstract method untuk polymorphism
    public abstract void saveToFile(List<Task> tasks, String filename) throws IOException;

    public List<Task> loadFromFile(String filename) throws Exception {
        // Implementasi baca file
        return new ArrayList<>();
    }
}

