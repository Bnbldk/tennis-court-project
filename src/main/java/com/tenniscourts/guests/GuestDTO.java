package com.tenniscourts.guests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class GuestDTO {

    @ApiModelProperty(name = "id")
    private Long id;

    @ApiModelProperty(name = "name", required = true, value = "Bruno")
    @NotNull(message = "Name cannot be null")
    private String name;
}