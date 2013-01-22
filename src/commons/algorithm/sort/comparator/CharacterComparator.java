package commons.algorithm.sort.comparator;

import java.util.Comparator;

public class CharacterComparator implements Comparator<Character> {
	
    /**
     * 
     * @param   c1 <code>Character</code>
     * @param   c2 <code>Character</code>
     * 
     * @return  
	 */
	public int compare(Character c1, Character c2) {
		return c1 - c2;
	}


}
