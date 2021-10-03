#include <bits/stdc++.h>
using namespace std;

class node {
public:
    int data;
    node* next;
    
    node(int val){
        data = val;
        next = NULL;
    }
};

void insertAtTail(node* &head, int val){
    
    node* n = new node(val);
    
    if(head==NULL){
        head=n;
        return;
    }
    
    node* temp = head;
    while(temp->next!=NULL){
        temp=temp->next;
    }
    temp->next=n;
}

void display(node* head){
    node* temp = head;
    while(temp!=NULL){
        cout<<temp->data<<"->";
        temp=temp->next;
    }
    cout<<"NULL"<<endl;
}

void deletion(node* &head,int val){
    if (head==NULL){
        return;
    }
    if(head->next==NULL){
        delete head;
        return;
    }
    
    node* temp = head;
    while(temp->next->data!=val){
        temp=temp->next;
    }
    node* todelete = temp->next;
    temp->next = temp->next->next;
    
    delete todelete;
}

void deleteAtHead(node* &head){
    node* todelete = head;
    head = head->next;
    delete todelete;
}

node* reverse(node* &head){
    
    node* prevptr= NULL;
    node* currptr=head;
    node* nextptr;
    
    while(currptr!=NULL){
        nextptr=currptr->next;
        currptr->next=prevptr;
        
        
        prevptr=currptr;
        currptr=nextptr;
    }
    return prevptr;
}

void circularInsertAtHead(node* &head, int val){
    
    node* n=new node(val);
 
    if(head==NULL){
        n->next=n;
        head=n;
        return;
    }
    node* temp=head;
 
    while(temp->next!=head){
        temp=temp->next;
    }
    temp->next=n;
    n->next=head;
    head=n;
}

void circularInsertAtTail(node* &head,int val){
    
    if(head==NULL){
        circularInsertAtHead(head,val);
        return;
    }
 
    node* n = new node(val);
    node* temp=head;
 
    while(temp->next!=head){
        temp=temp->next;
    }
 
    temp->next=n;
    n->next=head;
}



void circularDisplay(node* head){
    
   node* temp=head;
    do
    {
        cout<<temp->data<<" ";
        temp=temp->next;
    } while (temp!=head);
    cout<<endl;
}

void circularDeletion(node* &head, int val){
    
    if(head==NULL){
        return;
    }
    
    if(head->next==head){
        delete head;
        return;
    }
    
     node* temp = head;
    while(temp->next->data!=val){
        temp=temp->next;
    }
    node* todelete = temp->next;
    temp->next = temp->next->next;
    
    delete todelete;
}

void circularDeleteAtHead(node* &head){
    
    node* temp = head;
    while(temp->next!=head){
        temp=temp->next;
    }
    node* todelete = head;
    temp->next=head->next;
    head = head->next;
    delete todelete;
}

int main(){
    
    node* head = NULL;
    
    circularInsertAtTail(head,1);
    circularInsertAtTail(head,2);
    circularInsertAtTail(head,3);
    circularInsertAtTail(head,4);
    circularDisplay(head);
    circularDeletion(head,1);
    circularDeleteAtHead(head);
    circularDisplay(head);
}x
