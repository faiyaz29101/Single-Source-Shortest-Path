import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Bellman_Ford {
    private List<edge> l = new ArrayList<edge>();
    private int vertices = 0;
    private int source = 0;
    private int destination = 0;
    private int check = 0;
    private List<Integer> way = new ArrayList<Integer>();
    private StringBuffer sb = new StringBuffer();
    public Bellman_Ford(int v, List<edge> list, int s, int d) {
        vertices = v;
        l = list;
        source = s;
        destination = d;
        int infinite = 2000000000;
        int[] Array = new int[vertices];
        int[] Parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            if (i == source) {
                Array[i] = 0;
            } else {
                Array[i] = infinite;
            }
        }
        for (int i = 0; i < vertices-1; i++) {
            for (int j = 0; j < l.size(); j++) {
                if (Array[l.get(j).getStart()] < Array[l.get(j).getEnd()] - l.get(j).getWeight()) {
                    Array[l.get(j).getEnd()] = Array[l.get(j).getStart()] + l.get(j).getWeight();
                    Parent[l.get(j).getEnd()] = l.get(j).getStart();
                }
            }
//            System.out.println("Iteration - "+i);
//            for(int k =0; k < vertices; k++)
//            {
//                System.out.print(Array[k]+" ");
//            }
//            System.out.println();
//            for(int k =0; k < vertices; k++)
//            {
//                System.out.print(Parent[k]+" ");
//            }
//            System.out.println();
        }
        for (int j = 0; j < l.size(); j++) {
            if (Array[l.get(j).getStart()] < Array[l.get(j).getEnd()] - l.get(j).getWeight()) {
                check = 1;
            }
        }
        if(Array[destination] == infinite )
        {
            check = -1;
        }
//        for(int i =0; i<vertices; i++)
//        {
//            System.out.println(Array[i]);
//        }
//        System.out.println(check);
        sb.append("Bellman Ford Algorithm:\n");
        if(check == 1){
            sb.append("Negative weight cycle present");
        }
        else if(check == -1){
            sb.append("No Path Found");
        }
        else{
            sb.append(Array[destination]+"\n");
            Stack<Integer> st = new Stack<Integer>();
            int temp = destination;
            while (temp != source) {
                st.push(temp);
                temp = Parent[temp];
            }
            st.push(temp);

            while (true) {
                sb.append(st.pop());
                if (st.size() == 0) {
                    break;
                }
                sb.append(" -> ");
            }
        }
//        System.out.println(sb);
    }

    public String getString() {
        return sb.toString();
    }
}
