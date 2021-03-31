package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] dms = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> dm = subdomainVisits(dms);
        for (String d : dm) {
            System.out.println(d);
        }
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> counts = new HashMap<>();
        for (String dm: cpdomains) {
            String[] info = dm.split("\\s");
            //System.out.println(Arrays.toString(info));
            String[] dot = info[1].split("\\.");
            //System.out.println(Arrays.toString(dot));
            int count = Integer.valueOf(info[0]);
            String cur = "";
            for (int i=dot.length-1; i>=0; i--){
                cur = dot[i] + (i<dot.length-1 ? ".":"") +cur;
                //System.out.println(cur);
                counts.put(cur, counts.getOrDefault(cur,0)+count);
            }
        }
        List<String> ans = new ArrayList();
        for (String d: counts.keySet()){
            ans.add(counts.get(d) +" "+ d);
        }
        return ans;

    }
}
