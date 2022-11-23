package process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @RequestMapping("/start")
    public int startProcessInstance(@RequestParam int warriors) {
        return processService.startTheProcess(warriors);
    }
}
