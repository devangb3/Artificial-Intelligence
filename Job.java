import java.util.*;
public class Job{
    String jobId;
    int deadline;
    int profit;
    public Job(String jobId,int deadline,int profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }
    static ArrayList<Job> jobList = new ArrayList<Job>();
    public int getProfit() {
        return profit;
    }
    public static Comparator<Job> JobComparator = new Comparator<>() {
        public int compare(Job j1, Job j2) {
            int j1Profit = j1.getProfit();
            int j2Profit = j2.getProfit();
            return j2Profit-j1Profit;
        }
    };
    public static void addJob(Job job) {
        jobList.add(job);
    }
    public static void printJob(String[] jobList) {
        for(String jb : jobList) {
            System.out.println(jb);
        }
    }
    public static void greedySearch(ArrayList<Job> jobList) {
        jobList.sort(JobComparator);
        int n = jobList.size();
        boolean[] result = new boolean[n];
        String[] job = new String[n];
        for(int i =0; i<n ; i++) {
            for(int j=Math.min(n-1, jobList.get(i).deadline-1);j>=0;j--) {
                if(!result[j]) {
                    result[j] = true;
                    job[j] = jobList.get(i).jobId;
                    break;
                }
            }
        }
        printJob(job);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Jobs : ");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            String jobId = "J"+i;
            System.out.println("Enter the deadline for "+jobId + " : ");
            int deadline = sc.nextInt();
            System.out.println("Enter the profit for "+jobId + " : ");
            int profit = sc.nextInt();
            Job job = new Job(jobId,deadline,profit);
            addJob(job);
        }
        greedySearch(jobList);
    }
} 