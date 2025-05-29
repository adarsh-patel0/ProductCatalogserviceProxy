package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.TableForClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "c_tpc_mentor")
@Getter
@Setter
public class Mentor extends User{

    private int noOfHours;
}
