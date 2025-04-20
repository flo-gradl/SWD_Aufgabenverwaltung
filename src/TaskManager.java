import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task hinzugefügt: " + task);
    }

    public boolean removeTask(int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        if (removed) {
            System.out.println("Task mit ID " + id + " wurde entfernt.");
        } else {
            System.out.println("Task mit ID " + id + " nicht gefunden.");
        }
        return removed;
    }

    public boolean updateTaskStatus(int id, Status newStatus) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(newStatus);
                System.out.println("Status von Task #" + id + " aktualisiert zu: " + newStatus);
                return true;
            }
        }
        System.out.println("Task mit ID " + id + " nicht gefunden.");
        return false;
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Keine Aufgaben vorhanden.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    public void listTasksByStatus(Status status) {
        List<Task> filtered = tasks.stream()
                .filter(task -> task.getStatus() == status)
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("Keine Aufgaben mit Status: " + status);
        } else {
            filtered.forEach(System.out::println);
        }
    }

    public void listTasksByPriority(Priority priority) {
        List<Task> filtered = tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("Keine Aufgaben mit Priorität: " + priority);
        } else {
            filtered.forEach(System.out::println);
        }
    }

    public void printStatistics() {
        long totalTasks = tasks.size();

        long openTasks = tasks.stream().filter(task -> task.getStatus() == Status.OPEN).count();
        long inProgressTasks = tasks.stream().filter(task -> task.getStatus() == Status.IN_PROGRESS).count();
        long doneTasks = tasks.stream().filter(task -> task.getStatus() == Status.DONE).count();

        long lowPriority = tasks.stream().filter(task -> task.getPriority() == Priority.LOW).count();
        long mediumPriority = tasks.stream().filter(task -> task.getPriority() == Priority.MEDIUM).count();
        long highPriority = tasks.stream().filter(task -> task.getPriority() == Priority.HIGH).count();

        System.out.println("Gesamtanzahl der Aufgaben: " + totalTasks);
        System.out.println("Offene Aufgaben: " + openTasks);
        System.out.println("In Bearbeitung: " + inProgressTasks);
        System.out.println("Erledigte Aufgaben: " + doneTasks);
        System.out.println("Anzahl Aufgaben mit PRIORITÄT:");
        System.out.println("  LOW:    " + lowPriority);
        System.out.println("  MEDIUM: " + mediumPriority);
        System.out.println("  HIGH:   " + highPriority);
    }

}
