package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "c_st_mentor")
@Getter
@Setter
@DiscriminatorValue(value = "2")
public class Mentor extends User {

    private int noOfHours;
}
