import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuldLombok {
    private int id;
    private String name;
    private int age;
    private String email;
}
