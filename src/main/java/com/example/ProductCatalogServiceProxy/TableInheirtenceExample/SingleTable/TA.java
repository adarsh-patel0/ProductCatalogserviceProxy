package com.example.ProductCatalogServiceProxy.TableInheirtenceExample.SingleTable;

import com.example.ProductCatalogServiceProxy.TableInheirtenceExample.JoinedClass.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "c_st_ta")
@Getter
@Setter
@DiscriminatorValue(value = "1")
public class TA extends User {

    private int ratings;
}
