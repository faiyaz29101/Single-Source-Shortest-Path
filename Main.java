import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "input3.txt";
    private static final String OUTPUT_FILE1_NAME = "Bellman-Ford.txt";
    private static final String OUTPUT_FILE2_NAME = "Dijkstra.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(OUTPUT_FILE1_NAME));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(OUTPUT_FILE2_NAME));
        String line = br.readLine();
        String[] nums = line.split(" ");
        int vertices = Integer.parseInt(nums[0]);
        int edges = Integer.parseInt(nums[1]);
        List<edge> edgelist = new ArrayList<edge>();
        for (int i = 0; i < edges; i++) {
            line = br.readLine();
            nums = line.split(" ");
            edge temp = new edge(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2]));
            edgelist.add(temp);
        }
        line = br.readLine();
        nums = line.split(" ");
        Bellman_Ford bf = new Bellman_Ford(vertices, edgelist, Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        bw1.append(bf.getString());
        Dijkstra d = new Dijkstra(vertices, edgelist, Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        bw2.append(d.getString());
        bw1.close();
        bw2.close();



    }

    }