package buisnessProcess.resultStore;

import org.activiti.engine.*;
import org.activiti.engine.history.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResultStoreService {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    public ResultStoreService(RuntimeService runtimeService, TaskService taskService, HistoryService historyService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.historyService = historyService;
    }

    public String start(Integer postValue) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("postValue", postValue);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process_pool1", variables);
        return processInformation();
    }

    public String processInformation() {
        List<Task> taskList = taskService.createTaskQuery().orderByTaskCreateTime().asc().list();
        StringBuilder processAndTaskInfo = new StringBuilder();

        processAndTaskInfo.append("Количество запущенных в данный момент экземпляров процесса = " + runtimeService.createProcessInstanceQuery().count());
        taskList.forEach(task -> {
            processAndTaskInfo.append("\nID текущего процесса: " + task.getId()
                    + "\nТекущая задача: " + task.getName()
                    + "\nИсполнитель: " + task.getAssignee()
                    + "\nОписание задачи: " + task.getDescription());
        });

        return processAndTaskInfo.toString();
    }

    public String historyInformation() {
        List<HistoricTaskInstance> historicActivityInstancesList = historyService.createHistoricTaskInstanceQuery().list();
        List<HistoricVariableInstance> historicActivityInstancesList2 = historyService.createHistoricVariableInstanceQuery().list();
        StringBuilder processAndTaskInfo = new StringBuilder();

        historicActivityInstancesList.forEach(task -> {
            processAndTaskInfo.append("Описание задачи: " + task.getDescription()+ "\n");
        });

        historicActivityInstancesList2.forEach(task -> {
            processAndTaskInfo.append("\nПеременная: " + task.getVariableName()
                    + " = " + task.getValue());
        });

            return processAndTaskInfo.toString();
    }
}
