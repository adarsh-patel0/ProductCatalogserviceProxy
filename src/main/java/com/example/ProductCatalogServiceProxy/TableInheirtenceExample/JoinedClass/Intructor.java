package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.JoinedClass;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "c_jc_instructor")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
public class Intructor extends User {

    private String Company;

}
