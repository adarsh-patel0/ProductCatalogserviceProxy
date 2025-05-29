package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.TableForClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "c_tpc_ta")
@Getter
@Setter
public class TA extends User{

    private int ratings;
}
