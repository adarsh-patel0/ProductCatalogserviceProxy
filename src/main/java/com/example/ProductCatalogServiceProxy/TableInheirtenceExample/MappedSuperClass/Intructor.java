package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "c_msc_instructor")
@Getter
@Setter
public class Intructor extends User {

    private String Company;

}
