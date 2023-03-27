#!/bin/bash

# echo $0 // ./*.sh
# echo $1 // first parameter

mkdir $1
echo "import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
" > "$1/Solution.java"

code $1
