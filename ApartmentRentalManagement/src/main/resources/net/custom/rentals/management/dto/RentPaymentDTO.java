package net.custom.rentals.management.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RentPaymentDTO {

    private Long id;
    private Long tenantId;
    private BigDecimal amount;
    private LocalDate paymentDate;

    public RentPaymentDTO() {
    }

    public RentPaymentDTO(Long id, Long tenantId, BigDecimal amount, LocalDate paymentDate) {
        this.id = id;
        this.tenantId = tenantId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "RentPaymentDTO{" +
                "id=" + id +
                ", tenantId=" + tenantId +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
