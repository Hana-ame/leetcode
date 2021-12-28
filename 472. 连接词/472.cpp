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

int isConcatenated(DicTree* root, DicTree* ptr, const char * cstr, int begin, int end, int count);

class Solution {
public:
    vector<string> sv;
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        vector<string> res;
        DicTree* root = new DicTree('h');
        for (string s : w){
            int count = isConcatenated(root, root, s.c_str(), 0, s.length(), 0);

            if ( count>1 ){
                res.push_back(s);
            }else{
                root->addString(s);
            }
        }
        return res;
    }
};

bool less_length( const std::string& lhs, const std::string& rhs )
{
    return lhs.length() < rhs.length();
}

int main(){

    test();

    vector<string> res;
    vector<string> w;

    Solution s = Solution();

    w = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdgcat"};
    sort(w.begin(),w.end(),less_length);
    // printStringVector(w);
    
    DicTree* root = new DicTree('h');
    for (string s : w){
        int count = isConcatenated(root, root, s.c_str(), 0, s.length(), 0);
        cout<<s<<" "<<count<<endl;

        if ( count>1 ){
            res.push_back(s);
        }else{
            root->addString(s);
        }
    }
    printStringVector(res);

root->printTree("^");
    // res = s.findAllConcatenatedWordsInADict(w);
    // s.printStringVector();
    // printStringVector(res);
}

void printStringVector(vector<string>& sv){
    if (sv.size()==0){ cout<<"[]"<<endl; return; }
    cout<<"[";
    for (auto s: sv)
        cout<<'"'<<s<<'"'<<",";
    cout<<"\b]"<<endl;
}

void test(){
    vector<string> res;
    DicTree* root = new DicTree('h');
    string s = "abc";
    int count = 0;

    count = isConcatenated(root, root, s.c_str(), 0, s.length(), 0);
    cout<<count<<endl;

    if ( count>1 ){
        res.push_back(s);
    }else{
        root->addString(s);
    }

    root->addString(s);

    count = isConcatenated(root, root, s.c_str(), 0, s.length(), 0);
    cout<<count<<endl;

    root->printTree("^");
    printStringVector(res);
}

int isConcatenated(DicTree* root, DicTree* ptr, const char * cstr, int begin, int end, int count){
    for (int i = begin; i<end; i++){
        // cout<<"i:"<<i<<" char:"<<cstr[i]<<endl;
        ptr = ptr->nextNode(cstr[i]);
        if (ptr == NULL) return 0; 
        if (ptr->tag == 'e') {
            int c1,c2;
            c1 = isConcatenated(root,root,cstr,i+1,end,count+1) ;
            c2 = isConcatenated(root,ptr,cstr,i+1,end,count) ;
            // cout<<c1<<','<<c2<<endl;
            return c1>c2?c1:c2;
        }
    }
    if (ptr->tag == 'e') return count+1;
    return 0;
}
/*
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