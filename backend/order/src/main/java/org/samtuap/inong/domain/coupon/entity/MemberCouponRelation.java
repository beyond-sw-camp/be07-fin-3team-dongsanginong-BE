package org.samtuap.inong.domain.coupon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.samtuap.inong.domain.common.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberCouponRelation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    private Long orderId;
    private Long memberId;
    private String useYn;
    private LocalDateTime usedAt;
    private LocalDateTime issuedAt;

    public void updateIsUsed(String yn) {
        this.useYn = yn;
    }

    public void updateUsedAt(LocalDateTime usedAt) {
        this.usedAt = usedAt;
    }

    public void updateOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
