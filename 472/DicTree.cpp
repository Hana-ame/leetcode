#include<iostream>
#include<string>
#include "DicTree.h"
using namespace std;

class DicTree{

private:
    /* data */
public:
    DicTree *c[26] = {};
    char tag = 0;
    DicTree() = default;
    DicTree(char tag);
    ~DicTree();
    void printNode();
    void printTree(string s);
    DicTree* addAndReturnNewNode(char c, char tag);
    DicTree* addString(string s);
    DicTree* nextNode(char c);
};

DicTree::DicTree(char tag){
    this->tag = tag;
}

DicTree::~DicTree(){
    // cout<<"~DicTree()"<<endl;
    for(DicTree* t : this->c){
        delete t;
    }
}

void DicTree::printNode(){
    for (char c = 'a'; c <= 'z'; c++){
        if (this->c[c-'a'] == NULL) 
            cout << c << " : "<< "NULL" << endl;
        else 
            cout << c << " : " << this->c[c-'a'] << endl;    
    }
}

void DicTree::printTree(string s){
    // bool emptyFlag = true;
    for (char c = 'a'; c <= 'z'; c++){
        if (this->c[c-'a'] == NULL) continue;
        this->c[c-'a']->printTree(s+c);
        // emptyFlag = false;
    }
    if (this->tag == 'e')
        cout << s << endl;
}

DicTree* DicTree::addAndReturnNewNode(char c, char tag){
    // DicTree node = new DicTree(tag);
    this->c[c-'a'] = new DicTree(tag);
    return this->c[c-'a'];
}

DicTree* DicTree::addString(string s){
    DicTree* ptr = this;
    for (char c : s){
        if (ptr->c[c-'a'] != NULL)
            ptr = ptr->c[c-'a'];
        else
            ptr = ptr->addAndReturnNewNode(c,' ');
    }
    ptr->tag = 'e';
    return ptr;    
}

DicTree* DicTree::nextNode(char c){
    return this->c[c-'a'];
}