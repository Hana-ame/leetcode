import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        Solution solution = new Solution();
        String [] qs = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        for (String q:qs){
            solution.match(q, "FB");
        }
        solution.match("SoluoPoo", "SooP");
    }
}
