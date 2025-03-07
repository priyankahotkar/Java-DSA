import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }
    public static void main(String[] args) {
        int deadlines[] = {4,1,1,1};
        int profits[] = {20,10,40,30};
        
        ArrayList<Job> jobs= new ArrayList<>();
        for (int i = 0; i < deadlines.length; i++) {
            jobs.add(new Job(i, deadlines[i], profits[i]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit);    //descending order sorting
        ArrayList<Integer> ans = new ArrayList<>();
        int totalProfit = 0;
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job currjob = jobs.get(i);
            if (currjob.deadline > time) {
                totalProfit += currjob.profit;
                ans.add(currjob.id);
                time++;
            }
        }
        System.out.println("Jobs : "+ans);
        System.out.println("Total profit is "+totalProfit);
    }
}
