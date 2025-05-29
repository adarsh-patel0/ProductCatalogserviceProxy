package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.MappedSuperClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name ;

    private String email;

}
