package subscriber;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class Subscriber {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String city;
    private int phoneNumber;
    private int contractNumber;
    private double balance;
    private int timeCityConversation;
    private int timeIntercityConversation;
    private double internetTraffic;

}

