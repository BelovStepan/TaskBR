package buisnessProcess.task;

import buisnessProcess.resultStore.ResultStore;
import buisnessProcess.resultStore.ResultStoreRepository;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskB implements JavaDelegate {
        @Autowired
        private ResultStoreRepository resultStoreRepository;

    public TaskB(ResultStoreRepository resultStoreRepository) {
        this.resultStoreRepository = resultStoreRepository;
    }

    @Override
        public void execute(DelegateExecution delegateExecution) {
            int postValue = (int) delegateExecution.getVariable("postValue");
            int randomData = (int) delegateExecution.getVariable("randomData");
            int summaPostValueAndRandomData = (int) delegateExecution.getVariable("summaPostValueAndRandomData");
            ResultStore resultStore = new ResultStore("taskB", postValue, randomData, summaPostValueAndRandomData);
            resultStoreRepository.save(resultStore);
        }
    }
