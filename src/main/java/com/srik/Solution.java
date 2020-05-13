package com.srik;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {/*

    
     * Complete the missileDefend function below.
     
    static int missileDefend(int[][] missiles) {
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	
    	Arrays.stream(missiles).forEach( a -> 
    	{
    		if(map.containsKey(a[0]))
	    	
	    	{
	    		int count = map.get(a[0]);
	    		map.put(a[0], ++count);
	    	}
	    	else
	    		map.put(a[0], 1);
    	}
    		);
    	Set<Missile> list = new HashSet<>();
    	
        for(int i=0;i<missiles.length;i++)
        {
        	
        	int t = missiles[i][0];
        	int freq = missiles[i][1];
        	Missile m = new Missile(missiles[i][0],missiles[i][1]);
        	if(list.size() == 0)
        		list.add(m);
        	else
        	{
        		for(Missile hack : list)
        		{
        			int temp = hack.getFrequency();
        			if(temp == freq)
        			{
        				if()
        			}
        		}
        	}
        	
        }

    	return list.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int[][] missiles = new int[n][2];

        for (int missilesRowItr = 0; missilesRowItr < n; missilesRowItr++) {
            String[] missilesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            for (int missilesColumnItr = 0; missilesColumnItr < 2; missilesColumnItr++) {
                int missilesItem = Integer.parseInt(missilesRowItems[missilesColumnItr]);
                missiles[missilesRowItr][missilesColumnItr] = missilesItem;
            }
        }

        int result = missileDefend(missiles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
    
    
*/}

class Missile
{
	private int time;
	private int frequency;
	
	
	public Missile(int time, int frequency) {
		super();
		this.time = time;
		this.frequency = frequency;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + frequency;
		result = prime * result + time;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Missile other = (Missile) obj;
		if (frequency != other.frequency)
			return false;
		if (time != other.time)
			return false;
		return true;
	}
	
	
	
	
}