#include <iostream>
#include <vector>

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
        ListNode *head = new ListNode(0);
        ListNode *cur = head;
        int sum=0,carry = 0;

        while (l1 || l2)
        {
            int a = l1 ? l1->val : 0;
            int b = l2 ? l2->val : 0;

            cur  = cur->next;
            
            carry = (a + b + carry) / 10;


        }
        
    }
};


int main(){


}