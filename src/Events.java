/**
 *This class exists for the potential to support multiple events in the same location.
 * @author Sam Berkay
 */
public class Events {
    int x;
    int y;
    int dist;
    Event[] events;
    double cheapestTicket;
    public Events(int numOfEvents,int idStart, int x, int y){
        this.x=x;
        this.y=y;
        events = new Event[numOfEvents];
        for(int i=0;i<numOfEvents;i++){
            events[i] = new Event(idStart+i);
        }
        cheapestTicket=calcCheapestTicket(0);
    }
    
    //Returns cheapest ticket from a specified event within event area, only 0 used in this example.
    private double calcCheapestTicket(int i) {
        double min=events[i].getTickets().get(0).getPrice();
        for(Ticket t: events[i].getTickets()) {
            if(t.getPrice() < min){
                min = t.getPrice();
            }
        }
        return min;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDist() {
        return dist;
    }
    //Returns ID from specified event within event area, only 0 used in this example.
    public int getID(int i){
        return events[i].getEventID();
    }

    public double getCheapestTicket() {
        return cheapestTicket;
    }    
}
