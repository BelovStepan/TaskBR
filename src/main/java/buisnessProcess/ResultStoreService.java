package buisnessProcess;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultStoreService implements JavaDelegate {

    @Autowired
    private ResultStoreRepository resultStoreRepository;

    public void execute(DelegateExecution delegateExecution) {

    }

    public void calculation (DelegateExecution delegateExecution, int warriors) {
        warriors = (int) delegateExecution.getVariable("warriors");
        int enemyWarriors = (int) (Math.random() * 100);
        String battleStatus = "Undefined";
        boolean isWin = false;

        if ((warriors - enemyWarriors) > 0) {
            isWin = true;

            battleStatus = "Victory!";

        } else {
            battleStatus = "Fail :(";
        }

        if (warriors < 1 || warriors > 100) {
            throw new BpmnError("warriorsError");
        }

        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        delegateExecution.setVariable("battleStatus", battleStatus);
        delegateExecution.setVariable("isWin", isWin);
    }
}
