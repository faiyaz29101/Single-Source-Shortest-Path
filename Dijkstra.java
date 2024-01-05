import javax.swing.*;
import java.util.*;

public class Dijkstra {
    private List<edge> l = new ArrayList<edge>();
    private int vertices = 0;
    private int source = 0;
    private int destination = 0;
    private int check = 0;
    private List<Integer> way = new ArrayList<Integer>();
    private StringBuffer sb = new StringBuffer();
    private int infinite = 2000000000;

    public Dijkstra(int v, List<edge> list, int s, int d) {
        vertices = v;
        l = list;
        source = s;
        destination = d;
        for (int i = 0; i < l.size(); i++) {
            list.get(i).setWeight(Abs(list.get(i).getWeight()));
        }
        List<edge>[] l = new ArrayList[vertices];
        for(int i=0; i<vertices; i++){
            l[i] = new ArrayList<edge>();
        }
        for(int i = 0; i<list.size(); i++){
                l[list.get(i).getStart()].add(list.get(i));
        }
        for(int i=0; i< vertices; i++){
            l[i].sort(new Comparator<edge>() {
                @Override
                public int compare(edge o1, edge o2) {
                    return o1.weight - o2.weight;
                }
            });
        }
        int[] Parent = new int[vertices];
        int[] cst = new int[vertices];
        for(int i =0; i<vertices; i++){
            Parent[i] = -1 ;
            cst[i] = infinite;
        }
        int temp = source;
        cst[source] = 0;
        Parent[source] = source;
//        for(int i =0; i<vertices; i++){
//            System.out.println("for "+i);
//            for(int j=0; j<l[i].size(); j++){
//                System.out.print(l[i].get(j).print());
//            }
//        }
        List<Integer> visited = new ArrayList<>();
        visited.add(temp);
        Queue<edge> q = new LinkedList<edge>();
        for(int i = 0; i<list.size(); i++) {
//            System.out.println(temp);
            for (int j = 0; j < l[temp].size(); j++) {
//                System.out.println(l[temp].get(j).getStart() + " , " + l[temp].get(j).getEnd());
                q.add(l[temp].get(j));
                if (l[temp].size() != 0) {
                    if (cst[l[temp].get(j).getStart()] + l[temp].get(j).getWeight() < cst[l[temp].get(j).getEnd()]) {
                        cst[l[temp].get(j).getEnd()] = cst[l[temp].get(j).getStart()] + l[temp].get(j).getWeight();
                        Parent[l[temp].get(j).getEnd()] = l[temp].get(j).getStart();
                    }
                }
            }
            while (q.size() != 0) {
                edge te = null;
                try {
                    te = q.remove();

                } catch (Exception e) {

                }
               // te = q.remove();
                if (te != null && !visited.contains(te.getEnd())) {
                    temp = te.getEnd();
                    visited.add(temp);
                    break;
                }
                if (q.size() == 0) {
                    break;
                }
            }
        }


//        for(int i = 0; i< Parent.length; i++){
//            System.out.print(Parent[i] +" ");
//        }
//        System.out.println();
//        for(int i = 0; i< Parent.length; i++){
//            System.out.print(cst[i] +" ");
//        }
        sb.append("Dijkstra Algorithm:\n"+cst[destination]+"\n");
        Stack<Integer> st = new Stack<Integer>();
        int te = destination;
        while(te!=source){
            st.push(te);
            te = Parent[te];
        }
        st.push(te);
        sb.append(st.pop());
        while(!st.isEmpty()){
            sb.append(" -> ");
            sb.append(st.pop());
        }
        //System.out.println(sb);
    }
    public String getString(){
        return sb.toString();
    }

    private int Abs(int num){
        if(num < 0){
            return num*(-1);
        }
        return num;
    }
}
