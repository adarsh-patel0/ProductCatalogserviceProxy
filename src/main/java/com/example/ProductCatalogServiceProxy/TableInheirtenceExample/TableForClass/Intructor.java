package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.TableForClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "c_tpc_instructor")
@Getter
@Setter
public class Intructor extends User{

    private String Company;

}
