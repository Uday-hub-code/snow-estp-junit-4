package com.disney.cast.platform.vacationplanner.api.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PutFaqRateRequestBody {

    @JsonProperty("faq")
    private String faq;
    @JsonProperty("helpful")
    private Boolean helpful;

    @JsonProperty("faq")
    public String getFaq() {
        return faq;
    }

    @JsonProperty("faq")
    public void setFaq(String faq) {
        this.faq = faq;
    }

    @JsonProperty("helpful")
    public Boolean getHelpful() {
        return helpful;
    }

    @JsonProperty("helpful")
    public void setHelpful(Boolean helpful) {
        this.helpful = helpful;
    }

}
