package ict.data_objects.entities;

public class BookingRequestResponse {
    private int id;
    private BookingApprovedDetails approvedDetails;
    private boolean approved;

    public BookingRequestResponse(int id, BookingApprovedDetails approvedDetails, boolean approved) {
        this.id = id;
        this.approvedDetails = approvedDetails;
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookingApprovedDetails getApprovedDetails() {
        return approvedDetails;
    }

    public void setApprovedDetails(BookingApprovedDetails approvedDetails) {
        this.approvedDetails = approvedDetails;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
