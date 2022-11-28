package buisnessProcess.resultStore;

import javax.persistence.*;

@Entity
public class ResultStore {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int postValue;
    private int randomData;
    private int summaPostValueAndRandomData;

    public ResultStore() {
    }

    public ResultStore(String name, int postValue, int randomData, int summaPostValueAndRandomData) {
        this.id = id;
        this.name = name;
        this.postValue = postValue;
        this.randomData = randomData;
        this.summaPostValueAndRandomData = summaPostValueAndRandomData;
    }
}

