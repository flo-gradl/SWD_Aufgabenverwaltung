public class Main {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        Task task1 = new SimpleTask("Dokumentation schreiben", Priority.HIGH, Status.OPEN);
        Task task2 = new SimpleTask("Tests durchführen", Priority.MEDIUM, Status.IN_PROGRESS);
        Task task3 = new SimpleTask("Code Review", Priority.LOW, Status.OPEN);

        manager.addTask(task1);
        manager.addTask(task2);
        manager.addTask(task3);

        System.out.println("\n--- Alle Aufgaben ---");
        manager.listTasks();

        System.out.println("\n--- Aufgaben mit Status OPEN ---");
        manager.listTasksByStatus(Status.OPEN);

        System.out.println("\n--- Aufgaben mit Priorität HIGH ---");
        manager.listTasksByPriority(Priority.HIGH);

        System.out.println("\n--- Status aktualisieren ---");
        manager.updateTaskStatus(1, Status.DONE);

        System.out.println("\n--- Aufgabe löschen ---");
        manager.removeTask(2);

        System.out.println("\n--- Alle Aufgaben ---");
        manager.listTasks();

        System.out.println("\n--- Aufgaben Statistik ---");
        manager.printStatistics();


    }
}