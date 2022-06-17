package fact.it.restaurantappstart.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    LocalDate date;
    boolean payed;
    @Transient
    PaymentStrategy paymentStrategy;
    @ManyToOne
    Table table;
    @ManyToOne
    Waiter waiter;
    @OneToMany(mappedBy="order")
    List<OrderItem> orderItemList;

    public Order() {
        this.orderItemList =new ArrayList<OrderItem>();
        this.paymentStrategy = new NormalPayment();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void addItem(Dish dish, int quantity) {
        OrderItem newItem = new OrderItem();
        newItem.dish = dish;
        newItem.quantity = quantity;
        newItem.setAppliedPrice(paymentStrategy.getAppliedPrice(dish.currentPrice));
        orderItemList.add(newItem);
    }
    public double getTotal() {
        double totalPrice = 0;
        for (OrderItem item : orderItemList){
            totalPrice = totalPrice + item.getAppliedPrice()*item.quantity;
        }
        return totalPrice;
    }
    public void isHappyHour(boolean option){
        paymentStrategy = option? new HappyHourPayment(): new NormalPayment();
    }

    public void setPaymentStrategy(PaymentStrategy newPaymentStrategy) {
        paymentStrategy = newPaymentStrategy;
    }
}
//
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    LocalDate date;
//    boolean payed;
////    @Transient
////    PaymentStrategy paymentStrategy;
//    @ManyToOne
//    Table table;
//    @ManyToOne
//    Waiter waiter;
//    @OneToMany(mappedBy="order")
//    ArrayList<OrderItem> orderItemList;
//
//    public Order() {
////        this.paymentStrategy = new NormalPayment();
//        this.orderItemList =new ArrayList<OrderItem>();
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public boolean isPayed() {
//        return payed;
//    }
//
//    public void setPayed(boolean payed) {
//        this.payed = payed;
//    }
//
//    public Table getTable() {
//        return table;
//    }
//
//    public void setTable(Table table) {
//        this.table = table;
//    }
//
//    public Waiter getWaiter() {
//        return waiter;
//    }
//
//    public void setWaiter(Waiter waiter) {
//        this.waiter = waiter;
//    }
//
//    public ArrayList<OrderItem> getOrderItemList() {
//        return orderItemList;
//    }
//
//    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
//        this.orderItemList = orderItemList;
//    }
//
//    public void addItem(Dish dish, int quantity) {
//    }
//
//    public double getTotal() {
////        double totalPrice = 0;
////        for (OrderItem item : orderItemList){
////            totalPrice = totalPrice + paymentStrategy.getAppliedPrice(item.dish.currentPrice);
////        }
////        return totalPrice;
//        return 0;
//    }
////    public void isHappyHour(boolean option){
////        paymentStrategy = option? new HappyHourPayment(): new NormalPayment();
////    }
//}
