import java.util.*;
import java.lang.*;

class activity{
	int si = 0;
	int ei = 0;
	activity(int si, int ei){
		this.si = si;
		this.ei = ei;
	}
}

class actComparator implements Comparator<activity> {
    public int compare(activity p1, activity p2){
        if (p1.ei == p2.ei) return p1.si - p2.si;
        return p1.ei-p2.ei;
    }
}

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// applyig greedy via sorting on basis of endtime early finish
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		while (t-- > 0){
			int n = s.nextInt();
			ArrayList<activity> arrLL = new ArrayList<>();
			for (int i = 0; i < n; i++){
				int start = s.nextInt();
				int end = s.nextInt();
				arrLL.add(new activity(start,end));
			}
			Collections.sort(arrLL, new actComparator());
// 			System.out.println(arrLL);
			int count = 1;
			int currend = arrLL.get(0).ei;   // take 1st smallest activity
			for (int i = 1 ; i < arrLL.size(); i++){
			 //   System.out.println(arrLL.get(i).ei + " "+ arrLL.get(i).si);
				if (arrLL.get(i).si >= currend) {
				    count++;
				    currend = arrLL.get(i).ei;
				}
			}
			System.out.println(count);
		}
		
	}
}