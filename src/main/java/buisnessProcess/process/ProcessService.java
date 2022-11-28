package buisnessProcess.process;

import buisnessProcess.resultStore.ResultStoreService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {
    @Autowired
    private TaskService taskService;

    @Autowired
    private ResultStoreService resultStoreService;

    public ProcessService(TaskService taskService, ResultStoreService resultStoreService) {
        this.taskService = taskService;
        this.resultStoreService = resultStoreService;
    }

    public String startTheProcess(int postValue) {
        String result = resultStoreService.start(postValue);
        return result;
    }

    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    public void completeTask(String taskId) {
        taskService.complete(taskId);
    }

    public String getHistoryInformation() {
        return resultStoreService.historyInformation();
    }
}
