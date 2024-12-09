import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        Solution solution = new Solution();
        int [][] points = new int[][]{{1,2},{2,9999},{4,4},{5,5}};
        int r = solution.findMaxValueOfEquation(points, 2);
        System.out.println(r);
    }
}
