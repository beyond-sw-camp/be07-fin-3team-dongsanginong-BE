package org.samtuap.inong.domain.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.samtuap.inong.domain.product.entity.PackageProduct;

@Builder
public record TopPackageGetResponse(@NotNull Long id,
                                    @NotNull String packageName,
                                    @NotNull Long farmId,
                                    @NotNull String farmName,
                                    String imageUrl) {

    public static TopPackageGetResponse fromEntity(PackageProduct packageProduct, String thumbnailUrl) {
        return TopPackageGetResponse.builder()
                .id(packageProduct.getId())
                .packageName(packageProduct.getPackageName())
                .farmId(packageProduct.getFarm().getId())
                .farmName(packageProduct.getFarm().getFarmName())
                .imageUrl(thumbnailUrl)
                .build();
    }

}
