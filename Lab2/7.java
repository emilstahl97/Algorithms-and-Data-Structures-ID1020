//README Detta program sorterar en array av tal med hjälp av en länkad lista. 





import java.util.*;


public class Question7<Data> 
{
    //structure:  1-->2-->3-->null
    //where 1 is the first data entered
    //now null<--1<-->2<-->3-->null
    
	private Node first = null;  //första noden i listan, i detta implementation är det största värdet. 
    private Node last = null;  //sista/senaste noden i listan, i detta implementation är det minsta värdet. 
    private int size = 0;

    private class Node
    {
        Data data = null;  //referens till data/tal
        Node next = null;  //pekare till nästa nod
        Node previous = null;  //pekare till föregående nod
    }

    public boolean isEmpty()  //kollar om first == null, booleskt villkor
    {
        return (first == null);
    }

    public void enqueue(Data data)  //adds the data to the "last" node and links it //adderar datan/talet till senaste noden och länkar ihop den med tidigare noder
    {
        Node temp = new Node(); //skapar ny nod
        temp.data = data; //data adderas till temp 

        if (size == 0)
        {
            last = temp; 
            first = last; //om listan är tom är första och sista nod samma
        }
        else
        {
            Node pntr = last; //pekare till sista noden 
            int check1 = (int) data;
            int check2 = (int) (pntr.data);

            while ((check1 > check2) && (pntr.previous != null))
            {
                pntr = pntr.previous; //sätter pekaren till föregående nod
            }

            if (pntr == first) //om pekaren pekar första noden 
            {
                pntr.previous = temp; 
                temp.next = pntr; 
                first = temp; 
            }
            else if (pntr == last) //om pekaren pekar på sista noden
            {
                pntr.next = temp;
                temp.previous = pntr; 
                last = temp;
            }
            else
            {
                pntr.next.previous = temp;
                temp.next = pntr.next.previous;
                pntr.next = temp;
                temp.previous = pntr;

            }
        }

        size++;
    }

    public Data dequeue()  //tar bort noden från första noden och returnerar datan
    {
        Data data = first.data; //hämtar data från första insättningen
        first = first.next;  //går till nästa

        if (isEmpty())  //om slutet så pekar last på null 
        {
            last = null;
        }

        size--;
        return (data);  
    }

    public String toString() //returnerar en snygg output av datan 
    {
        Node pntr = first; //pekar på första elementet, i detta fall 0 
    	String output = "";
    	StringBuilder sb = new StringBuilder();

          while (pntr != null)  //om en nod finns
          {
              sb.append('[').append(pntr.data).append(']'); //hämtar data från pntr
              if(pntr.next != null)
              {
                  sb.append(" --> ");
              } 
              pntr = pntr.next;  //gå till nästa nod
          }

          output = sb.toString();

          return (output);    
     }

    public static void main(String[] args)
    {
        int[] numbers = {2,3,5,7,11,13,17,19};
        Question7 linkedList = new Question7();

        for (int i = 0; i < numbers.length; i++)
        {
            linkedList.enqueue(i);
            System.out.println(linkedList.toString());
        }
    }
}