package com.project.tobe.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(
        name = "seqProduct",
        sequenceName = "seq_product",
        initialValue = 1,
        allocationSize = 1
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduct")
    private Long productNo;
    private String productName;
    private String productWriter;
    private String productCategory;
    private Long productQty;
    private String productType;
    private Long productPrice;
    private Character productYn;
}



