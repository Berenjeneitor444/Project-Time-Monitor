import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * clase que representa un projecto del cual se registrarán tiempos
 */

public class Project {

    // Attributes
    private String projectName;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private boolean isRunning;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    // Constructor
    public Project(String Name){
        projectName = Name;
        startDate = LocalDateTime.now();
        finishDate = null;
        isRunning = false;
    }


}
