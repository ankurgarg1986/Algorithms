package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author agarg
 * http://www.geeksforgeeks.org/find-same-contacts-in-a-list-of-contacts/
 * Code to find same contacts in list of contacts
 * the link above uses DFS. This code uses BFS
 *
 */
class Contact
{
	String f1;
	String f2;
	String f3;
	public Contact(String f1,String f2,String f3)
	{
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
	}
}

public class SameContacts {

	private static void findSameContact(Contact[] cList, int n) {
		G4 g = new G4(n);
		buildGraph(g,cList,n);
		//Graph has been created , just do BFS or DFS to find Connected Components
		//Count of connected Components is the count of Same Contacts
		int i;
		int ans = 0;
		boolean[] vis = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		for(i=0;i<n;i++)
		{
			if(!vis[i])
			{
				vis[i] = true;
				BFS(vis,g,q,i);
				ans++;
			}
			//ans++;
		}
		System.out.println(ans);
		
	}

	
	private static void BFS(boolean[] vis, G4 g,Queue<Integer> q,int i) {
		q.add(i);
		//vis[0] = true;
		while(!q.isEmpty())
		{
			int top = q.poll();
			//vis[top] = true;
			Iterator<Integer> it = g.adjList[top].iterator();
			while(it.hasNext())
			{
				int x = it.next();
				if(!vis[x])
				{
				   q.add(x);
				   vis[x] = true;
				}
			}
			
		}
		
	}


	private static void buildGraph(G4 g, Contact[] cList, int n) {
		int i,j;
		for(i=0;i<n;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(cList[i].f1.equalsIgnoreCase(cList[j].f1) || cList[i].f1.equalsIgnoreCase(cList[j].f2) 
						|| cList[i].f1.equalsIgnoreCase(cList[j].f3) || cList[i].f2.equalsIgnoreCase(cList[j].f1) 
						|| cList[i].f2.equalsIgnoreCase(cList[j].f2) || cList[i].f2.equalsIgnoreCase(cList[j].f3)
						|| cList[i].f3.equalsIgnoreCase(cList[j].f1) || cList[i].f3.equalsIgnoreCase(cList[j].f2)
						|| cList[i].f3.equalsIgnoreCase(cList[j].f3)) 
				{
					g.addEdge(i, j);
				}
			}
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Contact[] cList = { new Contact("Gaurav", "gaurav@gmail.com", "gaurav@gfgQA.com"),
               new Contact("Lucky", "gaurav@gmail.com", "+1234567"),
               new Contact("gaurav123", "+5412312", "gaurav123@skype.com"),
               new Contact("gaurav1993", "+5412312", "gaurav@gfgQA.com"),
               new Contact("raja", "+2231210", "raja@gfg.com"),
               new Contact("bahubali", "+878312", "raja")
              };
       int n = cList.length;
       findSameContact(cList,n);
       
	}

	
}
