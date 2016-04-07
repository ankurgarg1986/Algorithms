package topcoderProblems;

import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author agarg
 *  Solution to DivII 500 point problem asked in SRM 687 
 *  The idea is to store indexes of all occurences of Q U A C and K in seperate Lists
 *  Then checking if the characters occur in order i.e. k after c , c after a and so on
 *  After k we search for next Q so that the sound is from the same duck and repeat the above process
 *  If no q occurs after k's Index , we are done with that duck and the new sound is from different duck.
 *  So we increment the count of duck here.
 */
public class Quacking {
    public static int quack(String s) {
        int res = 0;
        int i = 0;
        List<Integer> QList = new LinkedList<Integer>();
        List<Integer> UList = new LinkedList<Integer>();
        List<Integer> AList = new LinkedList<Integer>();
        List<Integer> CList = new LinkedList<Integer>();
        List<Integer> KList = new LinkedList<Integer>();
       // Map<char,Integer> tm = new TreeMap<char,Integer>();//Map to Store Indexes of quack in increasing order
        for(i=0;i<s.length();i++)
        {
        	if(s.charAt(i) ==  'q')
        	{
        		QList.add(i);
        	}
        	else if(s.charAt(i) ==  'u')
        	{
        		UList.add(i);
        	}
        	if(s.charAt(i) ==  'a')
        	{
        		AList.add(i);
        	}
        	if(s.charAt(i) ==  'c')
        	{
        		CList.add(i);
        	}
        	if(s.charAt(i) ==  'k')
        	{
        		KList.add(i);
        	}
        }
        if(QList.size() != UList.size() || UList.size() != AList.size() || AList.size() != CList.size() || CList.size() != KList.size())
        {
        	return -1;
        }
      //  int s = QList.size();
        i = 0;
        boolean flag = false;
        while(QList.size()>0)
        {
        	int qIndex = QList.remove(i);
        	int uIndex = UList.remove(i);
        	int aIndex = AList.remove(i);
        	int cIndex = CList.remove(i);
        	int kIndex = KList.remove(i);
        	if(qIndex < uIndex && uIndex < aIndex && aIndex < cIndex && cIndex < kIndex)
        	{
        		flag = false;
        		//if any i exists in qIndex after kIndex 
        		for(int j=0;j<QList.size();j++)
        		{
        			if(kIndex < QList.get(j))
        			{
        				i=j;
        				flag = true;
        				break;
        			}
        		}
        		if(!flag)
        		{
        			res++;
        			i=0;//start from beginning
        		}
        	}
        	else
        	{
        		return -1;
        	}
        }
        
        
        return res;
    }
    
    public static void main(String[] args)
    {
    	String  s = "quqacukqauackck";
    	System.out.println(quack(s));
    			
    }
}
    
    
