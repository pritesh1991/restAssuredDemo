package responses;

import core.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserResponse extends BaseResponse {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}
