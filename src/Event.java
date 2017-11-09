import java.util.ArrayList;
import java.util.List;

/**
 * Class for individual events
 * @author sb
 */
public class Event {
    int eventID;
    List<Ticket> tickets = new ArrayList<>();
    
    //Constructor
    public Event(int id){
        eventID=id;
        //Generates tickets
        for(int i=0;i<generateTicketCount();i++){
            tickets.add(new Ticket());
        }
    }
    
    //Generate zero or more tickets, up to 300.
    private int generateTicketCount(){
        int count=(int)(Math.random()*(300));
        return count;
    }

    public int getEventID() {
        return eventID;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
