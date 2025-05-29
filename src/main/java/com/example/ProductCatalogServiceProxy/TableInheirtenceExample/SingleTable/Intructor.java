package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.SingleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "c_st_instructor")
@Getter
@Setter
@DiscriminatorValue(value = "3")
public class Intructor extends User {

    private String Company;

}
