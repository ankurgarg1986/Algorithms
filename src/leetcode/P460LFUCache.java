package leetcode;

import java.util.HashMap;
import java.util.List;

public class P460LFUCache {

  int minFrequency = Integer.MAX_VALUE;
  HashMap<Integer, Integer> integerFrequencyMap;
  HashMap<Integer, List<Integer>> frequencyIntegerList;
  HashMap<Integer, Integer> valueMap;
  int cap;

  public P460LFUCache(int c) {
    integerFrequencyMap = new HashMap<Integer, Integer>();
    frequencyIntegerList = new HashMap<Integer, List<Integer>>();
    this.cap = c;
  }

  public int get(int key) {
      
  }

  public void put(int key, int value) {
    if(integerFrequencyMap.get(key) == null){
      integerFrequencyMap.put(key, 1);
      if(cap == valueMap.size()){
        List<Integer> ll = frequencyIntegerList.get(minFrequency);
        ll.remove(0);
        if(ll.size() == 0)
          frequencyIntegerList.remove(minFrequency);
        valueMap.remove(minFrequency);//removing from mapofValues
        integerFrequencyMap.remove(minFrequency);//removing from FrequencyMap
      }
      minFrequency = Math.min(minFrequency, 1);
      valueMap.put(key, value);
      List<Integer> ll = frequencyIntegerList.get(1);
      ll.add(key);
    }else{
      int freq = integerFrequencyMap.get(key);
      integerFrequencyMap.put(key,   freq + 1);
      if(cap == valueMap.size()){
        
      }
      if(minFrequency == freq) minFrequency = freq + 1;
      
      
      
      
      
    }
  }

}
