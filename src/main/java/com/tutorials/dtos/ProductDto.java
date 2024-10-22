package com.tutorials.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private Integer productId;

    @NotEmpty
    @Size(min = 2,max = 20,message = "Name should be in between 2-20 character")
    private String name;

    @NotEmpty
    @Size(max = 200)
    private String description;

    private double price;

    private String imageName;

    private boolean stock = true;

    private boolean live;

    // here we can't create field like {private CategoryDto categoryDto } we have to create same as below
    private CategoryDto category;

   // private Integer categoryId;

}
