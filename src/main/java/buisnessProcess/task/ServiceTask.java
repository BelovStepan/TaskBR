package buisnessProcess.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ServiceTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        int randomData = new Random().nextInt(100);
        int postValue = (int) delegateExecution.getVariable("postValue");
        int summaPostValueAndRandomData = randomData + postValue;
        delegateExecution.setVariable("randomData", randomData);
        delegateExecution.setVariable("summaPostValueAndRandomData", summaPostValueAndRandomData);
    }
}
