import java.time.LocalDateTime;
import java.util.HashMap;

public class Timer {
    private final HashMap<Project, Thread> projectThreadHashMap = new HashMap<>();
    /**
     * crea un hilo que irá contando el tiempo
     * @param project el proyecto del cual se empezará a contar
     */
    public void startTimer(Project project){
        // si ya esta en ejecución o ya se ha acabado no hace nada
        if(project.isRunning() || project.getFinishDate() != null){
            return;
        }
        project.setRunning(true);
        // inicializar la primera vez que se inicia el proyecto
        if(project.getStartDate() == null){
            project.setStartDate(LocalDateTime.now());
        }
        long startTime = System.currentTimeMillis();
        projectThreadHashMap.put(project, new Thread(new Runnable() {
            @Override
            public void run() {
                long elapsedTime = 0;
                while (project.isRunning()){
                    try{
                        Thread.currentThread().wait(1000);
                        elapsedTime = System.currentTimeMillis() - startTime;
                        project.setMilisegundos(elapsedTime);
                    }
                    catch (InterruptedException e){
                        elapsedTime = System.currentTimeMillis() - startTime;
                        project.setMilisegundos(elapsedTime);
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }));
        projectThreadHashMap.get(project).start();
    }

    /**
     * pone en pausa al proyecto
     * @param project el proyecto a pausar
     */
    public void stopTimer(Project project){
        if(project.isRunning() || project.getFinishDate() != null) {
            project.setRunning(false);
            projectThreadHashMap.get(project).interrupt();
        }
    }

    /**
     * finaliza el proyecto
     * @param project el proyecto a finiquitar
     */
    public void finishTimer(Project project){
        if (project.getFinishDate() == null){
            if (project.isRunning()){
                stopTimer(project);
            }
            project.setFinishDate(LocalDateTime.now());
        }
    }
}
