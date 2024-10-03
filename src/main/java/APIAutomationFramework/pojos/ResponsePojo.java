package APIAutomationFramework.pojos;

public class ResponsePojo {
    private String bookingid;
    private BookingPojo booking;

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }




}
