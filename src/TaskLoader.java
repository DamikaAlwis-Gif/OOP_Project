import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskLoader implements ITaskLoader{
    private TaskRepositoryService taskRepositoryService;
    private DataOperationsService dataOperationsService;
    public TaskLoader(TaskRepositoryService taskRepositoryService, DataOperationsService dataOperationsService) {
        this.taskRepositoryService = taskRepositoryService;
        this.dataOperationsService = dataOperationsService;
    }

    @Override
    public void loadTasks() {
        List<String> personalTaskLines = dataOperationsService.readData(dataOperationsService.getPersonalTaskLocation());
        List<String> officialTaskLines = dataOperationsService.readData(dataOperationsService.getOfficialTaskLocation());


        ArrayList<ATask> taskList = new ArrayList<>();
        for (String line:personalTaskLines){

            String[] arr = line.split(",");
            String[] date = arr[1].trim().split("-");
            LocalDate localDate = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            if(arr.length ==2){
                taskList.add(new PersonalTask(arr[0],localDate ));
            }
            else{
                taskList.add(new PersonalTask(arr[0],localDate,Integer.parseInt(arr[2])));
            }
        }

        for (String line:officialTaskLines){

            String[] arr = line.split(",");
            String[] date = arr[1].trim().split("-");
            LocalDate localDate = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            if(arr.length ==4){
                taskList.add(new OfficialTask(arr[0],localDate,arr[2], arr[3] ));
            }
            else{
                taskList.add(new OfficialTask(arr[0],localDate,arr[2],arr[3],Integer.parseInt(arr[4])));
            }
        }
        taskRepositoryService.setTaskList(taskList);

    }
}
