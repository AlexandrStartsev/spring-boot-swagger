package edu.alex.springswagger;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class Item {

    @ApiModelProperty(value = "Unique Id of item", required = true)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Name of this item 4 swagger", required = true, example = "Item <whatever>")
    private String name;
}
