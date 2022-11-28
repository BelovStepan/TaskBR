package buisnessProcess.process;

import buisnessProcess.resultStore.ResultStoreService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @Autowired
    private ResultStoreService resultStoreService;

    public ProcessController(ProcessService processService, ResultStoreService resultStoreService) {
        this.processService = processService;
        this.resultStoreService = resultStoreService;
    }

    @PostMapping("/start")
    @ResponseBody
    public String startProcessInstance(@RequestParam int postValue) {
        return processService.startTheProcess(postValue);
    }

    @PostMapping("/tasks")
    public String getTasks(@RequestParam String assignee) {
        List<Task> tasks = processService.getTasks(assignee);
        return tasks.toString();
    }

    @PostMapping("/completetask")
    public String completeTask(@RequestParam String taskId) {
        processService.completeTask(taskId);
        return "Задача с идентификатором " + taskId + " завершена!";
    }

    @PostMapping("/result")
    public String getResult() {
        return processService.getHistoryInformation();
    }
}
