import static org.junit.Assert.*;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        Solution solution = new Solution();
        assert solution.longestDecomposition("aaa") == 3;
        assert solution.longestDecomposition("abba") == 4;
        assert solution.longestDecomposition("aba") == 3;
        assert solution.longestDecomposition("abcba") == 5;
        assert solution.longestDecomposition("ghiabcdefhelloadamhelloabcdefghi") == 7;
        assert solution.longestDecomposition("merchant") == 1;
        assert solution.longestDecomposition("merchantmerchant") == 2;
        assert solution.longestDecomposition("antaprezatepzapreanta") == 11;


    }
}
