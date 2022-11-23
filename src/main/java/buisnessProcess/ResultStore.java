package buisnessProcess;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "result_store")
public class ResultStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double postValue;
    private double randomData;
    private double sumOfValues;

    public ResultStore() {
    }

    public ResultStore(Long id, double postValue, double randomData, double sumOfValues) {
        this.id = id;
        this.postValue = postValue;
        this.randomData = randomData;
        this.sumOfValues = sumOfValues;
    }


}
