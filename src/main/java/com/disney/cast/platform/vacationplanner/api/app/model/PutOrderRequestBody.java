
package com.disney.cast.platform.vacationplanner.api.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author g.moreno
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PutOrderRequestBody {

    @JsonProperty("entitlementId")
    private String entitlementId;
    @JsonProperty("rewardId")
    private String rewardId;
    @JsonProperty("shippingAddress")
    private ShippingAddress shippingAddress;

    @JsonProperty("entitlementId")
    public String getEntitlementId() {
        return entitlementId;
    }

    @JsonProperty("entitlementId")
    public void setEntitlementId(String entitlementId) {
        this.entitlementId = entitlementId;
    }

    @JsonProperty("rewardId")
    public String getRewardId() {
        return rewardId;
    }

    @JsonProperty("rewardId")
    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    @JsonProperty("shippingAddress")
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @JsonProperty("shippingAddress")
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
