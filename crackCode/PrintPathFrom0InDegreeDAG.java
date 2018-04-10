package crackCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import com.assignment.DAGProblem;

public class PrintPathFrom0InDegreeDAG {

    public static Node getNode(LinkedList<Node> nodeList, int value) {
        for (int i = 0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);
            if (node.getValue() == value)
                return node;
        }
        return null;
    }

    public static void main(String args[]) throws IOException {
    	
    	try(BufferedReader buf = new BufferedReader(new FileReader(new File("DAGFile.txt")))){
			int noOfNodes = Integer.parseInt(buf.readLine());
			 LinkedList<Node> nodeList = new LinkedList<Node>();
			Graph graphObject = new Graph();
			
			for (int i = 0; i < noOfNodes; ++i) {
	            Node node = new Node(i);
	            nodeList.add(node);
	        }
			
			String line ="";
			int start;
			int end;
			while((line=buf.readLine()) !=null) {
				String[] edges = line.replaceAll(" ", "").split(",");
				System.out.println("Adding edges "+edges[0]  + " "+edges[1]);
				
				start = Integer.parseInt(edges[0]);
				end = Integer.parseInt(edges[1]);
				
	            Node parentNode = getNode(nodeList, start);
	            Node childNode = getNode(nodeList, end);
	            
	            if (childNode != null)
	                parentNode.getChildList().add(childNode);	           
			}			


        for (int i = 0; i < nodeList.size(); ++i) {
            Node currentNode = nodeList.get(i);
            for (Node n : currentNode.getChildList()) {
                int indegree = n.getInDegree() + 1;
                n.setInDegree(indegree);
            }
        }

        for (int i = 0; i < nodeList.size(); ++i) {
            Node inputNode = nodeList.get(i);
            int currentNodeInDegree = inputNode.getInDegree();
            if (currentNodeInDegree == 0)
                graphObject.getRootList().add(new Tree(inputNode));
        }

        for (Tree tree : graphObject.getRootList()) {
            tree.printPaths(tree.getRoot());
        }

    	}catch(IOException e) {
			
		}
    }
}