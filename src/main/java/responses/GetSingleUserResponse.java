package responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import core.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetSingleUserResponse extends BaseResponse {
    public Data data;
    public Support support;

    @lombok.Data
    public static class Data {
        public int id;
        public String email;
        @JsonProperty(value = "first_name")
        public String firstName;
        @JsonProperty(value = "last_name")
        public String lastName;
        public String avatar;
    }


    @lombok.Data
    public static class Support {
        public String url;
        public String text;
    }
}
