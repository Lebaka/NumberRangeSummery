package numberRangeSummerize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {
	
	private int indexIncrement = 0;
	private boolean isSequential;
	private int currentNumber = 0;
	private int nextNumber = 0;
	
	@Override
    public final Collection<Integer> collect(String input) {
        return Arrays.stream(input.split("[,]"))
                .filter(val -> val.matches("^[0-9]*$"))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
	 @Override
	    public final String summarizeCollection(Collection<Integer> input) {

	        ArrayList<Integer> list = new ArrayList<>(input);
	        String str = list.get(0).toString();

	        return summarize(list, indexIncrement, str);
	    }
	    private String summarize(ArrayList<Integer> list, int i, String str){
	        currentNumber = (list.get(i) + 1);
	        nextNumber = list.get(i + 1);

	        if(currentNumber == nextNumber){
	            i++;
	            isSequential = true;
	        }
	        else if(isSequential) {
	            str += "-" + list.get(i);
	            i++;
	            str += ("," + list.get(i));
	            isSequential = false;
	        }
	        else {
	            isSequential = false;
	            i++;
	            str += "," + list.get(i);
	        }
	        return (i <= list.size() - 2 ? summarize(list, i, str) : str) ;
	    }
	}


