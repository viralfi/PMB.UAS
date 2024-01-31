package com.itc.pmb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Stats {
    private int totalCustomers;
//    private int totalUsers;
    private int totalProducts;
}
