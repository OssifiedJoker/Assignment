import java.time.LocalDate;
import java.util.*;
class solution
{
    
    public static void main(String[] args)
    {
       TreeMap<String, Integer> val = new TreeMap<String,Integer>();
       val.put("2019-02-26",106);
       val.put("2019-02-28",115);
       
       TreeMap<String,Integer> res = new TreeMap<String,Integer>();
       res = operation(val);
       System.out.println(res);
    }
    public static TreeMap<String,Integer> operation(TreeMap<String,Integer> val) {     // Required function
        List<LocalDate> totalDates = new ArrayList<>();
        ArrayList key = new ArrayList<Integer>();
        String s[]=new String[val.size()];
        int v[]=new int[val.size()];
        int i=0;
        for(Map.Entry<String,Integer> entry: val.entrySet())
        {
            s[i]=entry.getKey();
            v[i]=entry.getValue();
            i++;
        }
        int j=0,k=j+1;
        while(k<val.size())
        {
            int v1,v2;
            int st = 0;
            
            LocalDate start = LocalDate.parse(s[j]);
            LocalDate end = LocalDate.parse(s[k]);
            if(start.plusDays(1).compareTo(end)==0)
            {
                j++;
                k=j+1;
                continue;
            }
                v1 = v[j];
                v2 = v[k];
                int vd = Math.abs(v2-v1);
                int flag = 1;
                start = start.plusDays(1);
                while (!start.isAfter(end)) {
                    if(start.compareTo(end)==0)
                    break;
                    totalDates.add(start);
                    start = start.plusDays(1);
                    flag++;
                }
                int kk = v1 + (vd/flag);
                for(;kk<v[v.length-1];kk+=(vd/flag))
                key.add(kk);
               
            
            j++;
            k=j+1;
        }
        for(int it = 0;it<totalDates.size();it++)
        {
            String dd = ""+totalDates.get(it);
            int n =(int) key.get(it);
            val.put(dd,n);
        }
       return val;
        
    }
    
}
