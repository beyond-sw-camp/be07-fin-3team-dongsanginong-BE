package org.samtuap.inong.domain.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.samtuap.inong.domain.member.dto.PackageProductResponse;
import org.samtuap.inong.domain.subscription.entity.Subscription;

import java.util.List;

public record SubscriptionListGetResponse(List<SubscriptionGetResponse> subscriptions) {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SubscriptionGetResponse {
        private Long packageId;
        private Long memberId;

        public static SubscriptionGetResponse fromEntity(Subscription subscription) {
            return SubscriptionGetResponse.builder()
                    .packageId(subscription.getPackageId())
                    .memberId(subscription.getMember().getId())
                    .build();
        }
    }


}