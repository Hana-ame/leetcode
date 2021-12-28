#include <iostream>     // std::cout
#include <vector>       // std::vector
#include<string>
#include <algorithm>    // std::sort
#include "472.h"
#include "DicTree.cpp"

using namespace std;
/*
typedef struct N *pN;
struct N{
    N(){
        // this->c = {};
    };
    N(char tag){
        this->tag = tag;
    };
    char tag;   //该节点的元素是否为终结
    pN c[26];
};
*/
// typedef DicTree N;
// typedef N* pN;

void test();
// pN addChildAndReturnChild(pN node, char c, char tag);
void printStringVector(vector<string>& sv);
// void printNode(pN node);
// void printTree(pN node, string s);


class Solution {
public:
    vector<string> sv;
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        sv = words;
        printStringVector();
        return words;
    }
    void printStringVector(){
        cout<<"[";
        for (auto s: sv)
            cout<<'"'<<s<<'"'<<',';
        cout<<"\b]"<<endl;
    }
};

int main(){

    test();

    vector<string> res;
    vector<string> w;

    Solution s = Solution();

    w = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdgcat"};
    res = s.findAllConcatenatedWordsInADict(w);
    s.printStringVector();
    printStringVector(res);
}

void printStringVector(vector<string>& sv){
    cout<<"[";
    for (auto s: sv)
        cout<<'"'<<s<<'"'<<',';
    cout<<"\b]"<<endl;
}

void test(){
    DicTree* root = new DicTree('c');
    DicTree* ptr;
    cout<<root->tag<<endl;
    ptr = root;
    vector<string> w = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdgcat"};
    for (string s : w){
        root->addString(s);    
    }
    root->addString("asdfasdf");
    root->addString("asfsfsfd");
    root->addString("abfsfsfd");
    root->printNode();
    ptr ->printNode();
    cout<< (ptr==NULL)<<endl;

    root->printTree("^");

    delete root;
    // N root;    
    // printNode(&root);
    // cout<<"====";
    // printTree(&root,"^");
    // pN ptr;
    // ptr = addChildAndReturnChild(&root,'a','e');

    // printTree(&root,"2:^");
}


/*
pN addChildAndReturnChild(pN node, char c, char tag){
    // pN ptr = node->c[c-'a'];
    if ( node->c[c-'a'] == NULL ){
        node->c[c-'a'] = new N(tag);
        return node->c[c-'a'];
    }
    return node->c[c-'a'];
}

void printNode(pN node){
    for (char c = 'a'; c <= 'z'; c++){
        if (node->c[c-'a'] == NULL) 
            cout << c << " : "<< "NULL" << endl;
        else 
            cout << c << " : " << node->c[c-'a'] << endl;
    }
}

void printTree(pN node, string s){
    cout<<"--"<<s<<"--"<<endl;

    bool emptyFlag = true;
    for (char c = 'a'; c <= 'z'; c++){
        if (node->c[c-'a'] == NULL) {
            cout<<"node if Null:"<<node->c[c-'a']<<endl;
            continue;
        }
        // else {
        cout<<"node:"<<c<<"  "<<node->c[c-'a']<<endl;
        printTree(node->c[c-'a'], s+(c)); // 否则递归
        emptyFlag = false;
        // }
    }
    if (emptyFlag)
        cout<<emptyFlag<<endl;
        cout<< s;
    
    cout<<"-------"<<endl;
}
*/