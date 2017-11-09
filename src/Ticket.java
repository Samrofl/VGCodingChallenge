/**
 *
 * @author sb
 */
public class Ticket {
    double price;
    public Ticket(){
        price=generateRandomPrice();
    }
    private double generateRandomPrice(){
        double random = Math.random()*(100-0.01)+0.01;
        double rounded=(double)Math.round(random*100)/100;
        return rounded;
    }
    public double getPrice() {
        return price;
    }
    
    
}
