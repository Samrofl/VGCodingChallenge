
import java.util.Comparator;


/**
 * Used for sorting the priority queue
 * @author sam
 */
    public class Checker implements Comparator<Events>
  {
      public int compare(Events o1, Events o2)
      {
          if (o1.getDist() > o2.getDist()){
              return 1;
          } else{
              return -1;
          }
      }
  }
