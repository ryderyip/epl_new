package ict.data_objects.entities;

import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public class BookingApprovedDetails {
    private int id;
    private BigDecimal bookingFee;
    private boolean paymentConfirmed;
    @Nullable
    private String paymentReceipt;

    public BookingApprovedDetails(int id, BigDecimal bookingFee, boolean paymentConfirmed, @Nullable String paymentReceipt) {
        this.id = id;
        this.bookingFee = bookingFee;
        this.paymentConfirmed = paymentConfirmed;
        this.paymentReceipt = paymentReceipt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(BigDecimal bookingFee) {
        this.bookingFee = bookingFee;
    }

    public boolean isPaymentConfirmed() {
        return paymentConfirmed;
    }

    public void setPaymentConfirmed(boolean paymentConfirmed) {
        this.paymentConfirmed = paymentConfirmed;
    }

    public @Nullable String getPaymentReceipt() {
        return paymentReceipt;
    }

    public void setPaymentReceipt(@Nullable String paymentReceipt) {
        this.paymentReceipt = paymentReceipt;
    }
}
