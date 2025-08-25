package LibraryManagement;

import LibraryManagement.Enum.Constant;

public class Record {
    Book book;
    private int issueDate;
    private int returnDate;
    private double fine;
    boolean finePaid;

    Record(Book book, int issueDate) {
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = -1;
        this.fine = 0.0;
        this.finePaid = false;
    }

    public void printRecord() {
        String s = "";
        if(finePaid) {
            s = " returning date : "+returnDate+" fine : "+this.fine+" paid : "+this.finePaid;
        }

        System.out.println("Book name : "+book.getName()+" issue date : "+this.issueDate+" "+s);
    }

    public double changeRecord(int returnDate) {
        this.returnDate = returnDate;
        finePaid = true;
        return calculateFine(returnDate);
    }

    public double calculateFine(int returnDate) {
        int duration = returnDate-issueDate;
        if(duration <= Constant.MAX_FREE_DAY.value) return 0.0;
        return this.fine =  (duration-Constant.MAX_FREE_DAY.value)*Constant.FINE_PER_DAY.value;
    }
}
