package org.samtuap.inong.domain.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.samtuap.inong.domain.common.BaseEntity;
import org.samtuap.inong.domain.farm.entity.Farm;

@Entity
@SQLDelete(sql = "UPDATE package_product SET delYn = 'Y' WHERE id = ?")
public class PackageProduct extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id")
    private Farm farm;

    @NotNull
    private String packageName;

    @NotNull
    private Integer delivery_cycle;

    @NotNull
    private Long price;
}
