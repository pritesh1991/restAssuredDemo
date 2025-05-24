package requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {
    private String name;
    private String job;
}
