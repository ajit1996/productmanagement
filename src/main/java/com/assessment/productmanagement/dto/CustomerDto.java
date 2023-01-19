package com.assessment.productmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDto {
    @JsonProperty("id")
    private Integer customerId;
    @NotBlank
    @JsonProperty( "customer_name")
    private String name;
    @JsonProperty("company")
    private String companyName;
}
