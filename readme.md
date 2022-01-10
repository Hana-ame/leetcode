思路记录，↑时间靠后 时间靠前↓

[306. 累加数](https://leetcode-cn.com/problems/additive-number/)

穷举，神经病题目

----
[1222. Queens That Can Attack the King](https://leetcode.com/problems/queens-that-can-attack-the-king/)

[arr2List](https://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java)

    Arrays.stream(ints).boxed().collect(Collectors.toList());

这个好慢！甚至不如自己遍历。

    List<Integer> list = new ArrayList<>();
    for (int i : ints){
        list.add(i);
    }
    return list;

[提交记录](https://leetcode.com/submissions/detail/616092142/)

----
[52. N-Queens II](https://leetcode.com/problems/n-queens-ii/)

稍稍有点慢，TODO看一下别人代码。

----

[1041. Robot Bounded In Circle](https://leetcode.com/problems/robot-bounded-in-circle/)

成立条件 回到原点 或者 **不面向北方** 

java String to char[]

    char [] cs = s.toCharArray();

----
[49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)

Java [HashMap的用法。](https://www.runoob.com/java/java-hashmap.html)

字符串自己写hash的话会快一点。

    String.length()

`""`内部的是文件的编码格式传进去的（比如文件是utf8，那么一个汉字3byte，一个英字1byte），解释是使用的javac时指定的encoding方式。编码不对会读不出。

汉字 -> 3,3,..,3  -> 2,2,2,..,2 -> GBK格式读（读不出会报错）

所以一个char大概是3byte？并没有sizeof

----
[48. Rotate Image](https://leetcode.com/problems/rotate-image/)

数学题，仔细算就行。

----
[962. Maximum Width Ramp](https://leetcode.com/problems/maximum-width-ramp/)

单调栈

java的类名字起得真是

    Stack<Integer> stack = new Stack<Integer>();
    stack.empty();
    stack.peek();
    stack.push(e);
    stack.pop();

    LinkedList<Integer> stack = new LinkedList<>();
    stack.isEmpty();
    stack.peek()
    stack.push(e);
    stack.pop();

    ArrayList<Integer> stack = new ArrayList<Integer>();

[ArrayList](https://www.w3schools.com/java/java_arraylist.asp)

----

[51. N-Queens](https://leetcode.com/problems/n-queens/)

知道用dfs的话很简单

虚类实例化

    List<List<String>> res;
    res = new ArrayList<List<String>>();

char [] 转 String

    for (char [] cstr : memo){
        String str = new String(cstr);
        result.add(str);
    }

一维数组加速？

----
[37. Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)

deepcopy

    char[][] newboard = new char[9][9];
    for (int i = 0; i<board.length; i++){
        newboard[i] = Arrays.copyOf(board[i], board[i].length);
    }

int to char

    char c = (char)('1'+1);

方法有问题。待续。

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

