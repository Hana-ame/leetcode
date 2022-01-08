思路记录，↑时间靠后 时间靠前↓

----

[51. N-Queens](https://leetcode.com/problems/n-queens/)



----
[37. Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)

deepcopy

    char[][] newboard = new char[9][9];
    for (int i = 0; i<board.length; i++){
        newboard[i] = Arrays.copyOf(board[i], board[i].length);
    }

int to char

    char c = (char)('1'+1);

方法有问题。

----
[36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)

TODO：java set的用法。

memset in java

    Arrays.fill(array, -1);

memcpy in java

    byte[] src = {1, 2, 3, 4};
    byte[] dst = Arrays.copyOf(src, src.length);
    System.out.println(Arrays.toString(dst));
----

[55. Jump Game](https://leetcode.com/problems/jump-game/)

直接复制了45的代码改了改。

----

[1306. Jump Game III](https://leetcode.com/problems/jump-game-iii/)

java，原地修改会稍微快一点。

取index还是有代价的，多使用临时变量会快一些。

----

[45. Jump Game II](https://leetcode.com/problems/jump-game-ii/)

    int max = Math.max(a,b);

逻辑上用BFS会慢，看了答案就知道了。每次跳跃能找到最优的点。

用例应该有改动，memory变大很多。

边界条件吃屎。

----

[1463.  Cherry Pickup II](https://leetcode.com/problems/cherry-pickup-ii/)

应该是动态规划

确实是动态规划

因为边界问题吃了点亏（手残写歪了），34，37，过后看答案（TODO）

----

[30. Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)

java的答案快很多，看一下学习一下，有map的用法。

TODO：Map的用法

