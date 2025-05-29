package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "c_msc_mentor")
@Getter
@Setter
public class Mentor extends User {

    private int noOfHours;
}
