package bankplatform.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum AccountType {
    @JsonProperty("checking")
    CHECKING,
    @JsonProperty("saving")
    SAVING;
}
