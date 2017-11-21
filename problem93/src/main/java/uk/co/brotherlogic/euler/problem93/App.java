package uk.co.brotherlogic.euler.problem93;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class App {

	private Integer compute(Integer num1, Integer num2, Integer op) throws NumberFormatException{
		switch (op) {
		case 1: return num1 * num2;
		case 2: return num1 + num2;
		case 3: return num1 - num2;
		case 4: 
			if (num2 == 0 || num1 % num2 != 0) throw new NumberFormatException("Non-Integer Division");
			return num1 / num2;
		}
		
		throw new NumberFormatException("Cannot compute " + op);
	}
	
	private Set<Integer> compute (Integer[] nums, Integer[] ops) {
		Set<Integer> vals = new TreeSet<Integer>();

		// (((a^b)^c)^d)
		try {	
			Integer val = compute(compute(compute(nums[0],nums[1],ops[0]), nums[2], ops[1]), nums[3], ops[2]);
			if (val > 0)
			vals.add(val);
		}catch (NumberFormatException e) {
			//Ignore
		}

		
		return vals;
	}
	
	
	public Integer doMax(Integer[] nums) {
		Set<Integer> answers = new TreeSet<Integer>();
		List<Integer> aList = new LinkedList<Integer>();
		aList.add(nums[0]);
		aList.add(nums[1]);
		aList.add(nums[2]);
		aList.add(nums[3]);
		for(int op1 = 1 ; op1 < 5; op1++) {
			for (int op2 = 1; op2 < 5 ; op2++) {
				for (int op3 = 1; op3 < 5; op3++) {
					for(List<Integer> perm : new Permutations<Integer>().permute(aList)) {
						answers.addAll(compute(perm.toArray(new Integer[] {}), new Integer[] {op1,op2,op3}));
					}

				}
			}
		}
		
		int max_cont = 0;
		Integer pVal = null;
		for (Integer val: answers)
			if (pVal == null) {
				pVal = val;
			} else if (val - pVal == 1) {
				max_cont = val;
				pVal = val;
			} else {
				break;
			}
		
		return max_cont;
	}
	
	public static void main(String[] args) {
		
		App a = new App();
		
		int best = 0;
		for(int n1 = 1; n1 < 10 ; n1++)
			for(int n2 = n1+1; n2 < 10 ; n2++)
				for(int n3 = n2+1; n3 < 10; n3++)
					for (int n4 = n3+1; n4 < 10 ; n4++)
					{
						int val = a.doMax(new Integer[] {n1,n2,n3,n4});
						if (val > best) {
						System.out.println(n1 + "" + n2 + "" + n3 + "" + n4 +" = " + val);
						best = val;
					}}
	}
	
}

//Lazy way to generate permutations - stolen from https://stackoverflow.com/questions/10503392/java-code-for-permutations-of-a-list-of-numbers
 class Permutations<T> {
    public Collection<List<T>> permute(Collection<T> input) {
        Collection<List<T>> output = new ArrayList<List<T>>();
        if (input.isEmpty()) {
            output.add(new ArrayList<T>());
            return output;
        }
        List<T> list = new ArrayList<T>(input);
        T head = list.get(0);
        List<T> rest = list.subList(1, list.size());
        for (List<T> permutations : permute(rest)) {
            List<List<T>> subLists = new ArrayList<List<T>>();
            for (int i = 0; i <= permutations.size(); i++) {
                List<T> subList = new ArrayList<T>();
                subList.addAll(permutations);
                subList.add(i, head);
                subLists.add(subList);
            }
            output.addAll(subLists);
        }
        return output;
    }
}
