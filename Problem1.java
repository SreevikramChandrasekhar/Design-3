//Time Complexity: Next() - O(1); hasNext() - O(depth of nesting)
//Space Complexity: O(depth of nesting)
//Code run successfully on LeetCode.

public class Problem1 {

	public class NestedIterator implements Iterator<Integer> {
	    
	    Stack<Iterator<NestedInteger>> s;
	    NestedInteger nextEl;

	    public NestedIterator(List<NestedInteger> nestedList) {
	        
	        s = new Stack<>();
	        s.push(nestedList.iterator());
	    }

	    @Override
	    public Integer next() {
	        
	        return nextEl.getInteger();
	    }

	    @Override
	    public boolean hasNext() {
	        
	        while(!s.isEmpty()){
	            
	            if(!s.peek().hasNext())
	                s.pop();
	            
	            else if((nextEl = s.peek().next()).isInteger())
	                return true;
	            
	            else
	                s.push(nextEl.getList().iterator());
	        }
	        
	        return false;
	    }
	}
}
