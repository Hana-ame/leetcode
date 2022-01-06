/**
 * Definition for singly-linked list.*/
#include "../leetcode.h"
// #define NULL nullptr



struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
 /**/

 
ListNode* generateList(int n){
    if (n == 0) return NULL;
    ListNode* head = new ListNode(0);
    ListNode* tail = head;
    for (int i = 1; i<n; i++){
        tail->next = new ListNode(i);
        tail = tail->next;
    }
    return head;
}
void printList(ListNode* head){
    while (head){
        cout<<head->val<<'\t';
        head = head->next;
    }
    cout<<endl;
}



class Solution {
public:
    ListNode* delNextNode(ListNode* ptr){
        if (ptr == NULL) return NULL;
        if (ptr->next == NULL) return NULL;
        ListNode* res = ptr->next;
        ptr->next = ptr->next->next;
        res->next = NULL;
        return res;
    }
    void insertNextNode(ListNode* ptr, ListNode* temp){
        if (ptr==NULL) return;
        if (temp==NULL) return;
        if (ptr->next == NULL) {ptr->next = temp; return;}
        temp->next = ptr->next;
        ptr->next = temp;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (k == 1) return head;    
        bool resflag = true;
        ListNode* res = new ListNode();
        ListNode* dummyhead = res;
        ListNode* thistail;
        ListNode* thishead;
        ListNode* t;

        // res = head;
        // nexthead = head;
        // thishead = head;
        dummyhead->next = head;

        // 调整指针位置 dummyhead - 1(thishead) - k(thistail) - k+1(nexthead)
        // 执行完毕之后
        // dummyhead = thishead
        // if(resflag) res = dummyhead->next
        while (true){
            // dummyhead->next = nexthead;
            
            // dummyhead = thishead;
            // thistail = dummyhead;

            thistail = dummyhead;
            thishead = dummyhead->next;
            for (int i = 0; i<k; i++){
                thistail = thistail->next;
                if (thistail == NULL) return res->next;
            }
            // nexthead = thistail->next;
            // 尾插法倒置
            while (thistail != dummyhead->next){
                t = delNextNode(dummyhead);
                insertNextNode(thistail, t);
                // printList(res->next);
            }                    
            // cout<<endl;
            // next
            dummyhead = thishead;
        }
        // 下一次

        return res->next;
    }
};



int main(){
    ListNode* head ;
    head = generateList(8);
    ListNode* t;
    printList(head);
    Solution s = Solution();
    head = s.reverseKGroup(head,4);
    printList(head);
    head = generateList(7);
    head = s.reverseKGroup(head,4);
    printList(head);
    head = generateList(4);
    head = s.reverseKGroup(head,4);
    printList(head);
    head = generateList(2);
    head = s.reverseKGroup(head,4);
    printList(head);
}