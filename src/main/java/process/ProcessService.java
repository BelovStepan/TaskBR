package process;

import buisnessProcess.ResultStoreRepository;
import buisnessProcess.ResultStoreService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {
    @Autowired
    private ResultStoreRepository resultStoreRepository;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ResultStoreService resultStoreService;

    // start the process and set employee as variable
    public int startTheProcess(int warriors) {
        //resultStoreService.calculation(null,warriors);
        warriors =228;
        return warriors;
    }
}
