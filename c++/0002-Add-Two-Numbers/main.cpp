#include <iostream>
#include <vector>


/*
1. 在较短的链表末尾补零
2. 对齐相加考虑进位

*/
using namespace std;

 struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };


class Solution{
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode();
        ListNode* cur = dummy;
        int carry = 0;
        while(l1 || l2 || carry !=0){

            int sum = (l1?l1->val : 0) + (l2 ? l2->val : 0) + carry;
            carry = sum / 10;
            cur->next = new ListNode( sum % 10);
            cur = cur->next;

            l1 = l1 ? l1->next : NULL;
            l2 = l2 ? l2->next : NULL;

        }
        return dummy->next;

}
};


int main(){

    return 0 ;
}
