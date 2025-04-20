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

        //Alternative
//        for (int i = 0; i < tasks.size(); i++) {
//            if (tasks.get(i).getId() == id) {
//                tasks.remove(i);
//                System.out.println("Task mit ID " + id + " wurde entfernt.");
//                return true;
//            }
//        }
//        System.out.println("Task mit ID " + id + " nicht gefunden.");
//        return false;
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
            for(Task task : tasks){
                System.out.println(task);
            }
        }
    }

    public void listTasksByStatus(Status status) {
        List<Task> filtered = tasks.stream()
                .filter(task -> task.getStatus() == status)
                .toList();

        //Alternative
//        List<Task> filtered = new ArrayList<>();
//        for (Task task : tasks) {
//            if (task.getStatus() == status) {
//                filtered.add(task);
//            }
//        }


        if (filtered.isEmpty()) {
            System.out.println("Keine Aufgaben mit Status: " + status);
        } else {
            for(Task task : filtered){
                System.out.println(task);
            }
        }
    }

    public void listTasksByPriority(Priority priority) {
        List<Task> filtered = tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("Keine Aufgaben mit Priorität: " + priority);
        } else {
            for(Task task : filtered){
                System.out.println(task);
            }
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

//      Alternative
//        for (Task task : tasks) {
//            // Status zählen
//            if (task.getStatus() == Status.OPEN) {
//                openTasks++;
//            } else if (task.getStatus() == Status.IN_PROGRESS) {
//                inProgressTasks++;
//            } else if (task.getStatus() == Status.DONE) {
//                doneTasks++;
//            }
//
//            // Priorität zählen
//            if (task.getPriority() == Priority.LOW) {
//                lowPriority++;
//            } else if (task.getPriority() == Priority.MEDIUM) {
//                mediumPriority++;
//            } else if (task.getPriority() == Priority.HIGH) {
//                highPriority++;
//            }
//        }

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
