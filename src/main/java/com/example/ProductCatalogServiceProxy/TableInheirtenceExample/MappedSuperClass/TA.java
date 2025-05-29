package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "c_msc_ta")
@Getter
@Setter
public class TA extends User {

    private int ratings;
}
