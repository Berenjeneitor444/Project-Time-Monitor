import java.time.LocalDateTime;

/**
 * clase que representa un projecto del cual se registrarán tiempos
 */

public class Project {

    // Attributes
    private String projectName;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private boolean isRunning;
    private long milisegundos = 0;

    // Getters and Setters

    public boolean isRunning() {
        return isRunning;
    }
    public void setRunning(boolean running) {
        isRunning = running;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public long getMilisegundos() {
        return milisegundos;
    }

    public void setMilisegundos(long milisegundos) {
        this.milisegundos = milisegundos;
    }

    // Constructor
    public Project(String Name){
        projectName = Name;
        startDate = null;
        finishDate = null;
        isRunning = false;
    }



}
