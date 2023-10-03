package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutCompanyInfoRequestDto {
    private String logoImageUrl;
    @NotBlank
    private String bizNumber;
    @NotBlank
    private String companyName;
    @NotBlank
    private String repName;
    @NotBlank
    private String postCode;
    @NotBlank
    private String companyAddress;
    private String companyAddressDetail;
    @NotBlank
    private String telNumber;
    @NotBlank
    private String bizStatus;
    @NotBlank
    private String bizType;
    private String englishName;
    private String homepage;
}
