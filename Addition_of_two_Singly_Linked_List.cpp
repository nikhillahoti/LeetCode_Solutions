/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* first = NULL; 
        ListNode* nexxt = NULL;
        ListNode* temp = NULL;
        int value = 0, residue = 0;
        
        while((l1 != NULL) && (l2 != NULL)){
            value = l1->val + l2->val;
            temp = new ListNode((value + residue) % 10);
            
            if(value + residue >= 10){
                residue = 1;
            }
            else{
                residue = 0;
            }
            
            if (first == NULL){
                first = temp;
                nexxt = first;
            }
            else{
                nexxt->next = temp;
                nexxt = nexxt->next;
            }
            l2 = l2->next;
            l1 = l1->next;
        };
        
        if( l1 == NULL){
            while(l2 != NULL){
                value = l2->val;
                temp = new ListNode((value + residue)%10);
                if(value + residue >= 10){
                   residue = 1; 
                }
                else{
                    residue = 0;
                }
                
                if (first == NULL){
                    first = temp;
                    nexxt = first;
                }
                else{
                    nexxt->next = temp;
                    nexxt = nexxt->next;
                }            
                l2 = l2->next;
            };
        }
        
        if( l2 == NULL){
            while(l1 != NULL){
                value = l1->val;
                temp = new ListNode((value + residue)%10);
                if(value + residue >= 10){
                   residue = 1; 
                }
                else{
                    residue = 0;
                }
                
                if (first == NULL){
                    first = temp;
                    nexxt = first;
                }
                else{
                    nexxt->next = temp;
                    nexxt = nexxt->next;
                }         
                l1 = l1->next;
            };
        }
        
        if( residue > 0){
            temp = new ListNode(residue);
            if(first == NULL){
                first = temp; 
            }
            else{
                nexxt->next = temp;
            }
        }
        
        return first;
    }
};