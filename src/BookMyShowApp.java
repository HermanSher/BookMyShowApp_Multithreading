class BookTickets {
    static int totalSeat = 20;

   static synchronized void bookSeat(int seat) {
        if (totalSeat >= seat) {
            System.out.println(seat + " Seats booked succsessfully");
            totalSeat = totalSeat - seat;
            System.out.println(totalSeat + " seats left");
        } else {
            System.out.println("Seats cannot be booked");
            System.out.println(totalSeat+" seats left");
        }
    }
}

class MyThread1 extends Thread{
     BookTickets b;
     int seat;
     MyThread1(BookTickets b, int seat){
        this.b = b;
        this.seat = seat;
     }
    public void run(){
        b.bookSeat(seat);
    }
}

class MyThread2 extends Thread{
    BookTickets b;
    int seat;
    MyThread2(BookTickets b, int seat){
       this.b = b;
       this.seat = seat;
    }
   public void run(){
       b.bookSeat(seat);
   }
}


public class BookMyShowApp {
    public static void main(String[] args) {
        BookTickets b1 = new BookTickets();
        MyThread1 t1 = new MyThread1(b1, 7);
        t1.start();
        MyThread2 t2 = new MyThread2(b1, 3);
        t2.start();
        //---------------------------------

        BookTickets b2 = new BookTickets();
        MyThread1 t3 = new MyThread1(b2, 6);
        t3.start();
        MyThread2 t4 = new MyThread2(b2, 2);
        t4.start();
    }
}

