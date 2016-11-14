import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Julie on 09-11-2016.
 */
public class Run {
    public static void readFile() throws FileNotFoundException{
        int numberOfVertices = 0;

        // Read file
        System.out.println("Indtast navnet på filen:");
        Scanner userInput = new Scanner(System.in);
        String fileName = userInput.next();
        Scanner fileInput = new Scanner(new File("C:\\Users\\Julie\\IdeaProjects\\Graphs\\src\\"+fileName+".txt"));
        numberOfVertices = fileInput.nextInt();


        // New instances of lists of edges and vertices
        String[] vertices = new String[numberOfVertices];
        ArrayList<AbstractGraph.Edge> edges = new ArrayList<>();

        // Add vertices and edges from file
        fileInput.nextLine();
        for (int i = 0; i < numberOfVertices; i++) {
            // Add vertices
            String s = fileInput.nextLine();
            String[] split = s.split("-");
            String first = split[0];
            vertices[i] = first;

            // Add edges
            for (int j = 0; j < split.length; j++) {
                edges.add(new AbstractGraph.Edge(Integer.parseInt(first), Integer.parseInt(split[j])));
            }
        }


        // Create new instance of graph and add vertices and edges
        Graph<String> g = new UnweightedGraph<>(Arrays.asList(vertices), edges);

        // Instance tree
        AbstractGraph.Tree tree = g.dfs(0);

        // Display number of vertices
        System.out.println("Number of vertices: " + numberOfVertices);

        // Display edges
        g.printEdges();

        // Display if graph is connected or not
        if (tree.getNumberOfVerticesFound() == g.getSize()) {
            System.out.println("Graph is connected");
        }
        else {
            System.out.println("Tree is not connected");
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
       readFile();
    }
}
