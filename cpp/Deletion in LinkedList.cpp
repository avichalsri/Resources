#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node* next;
} *head;

struct node *create_list(int n){
    struct node *head;
    head = (struct node *)malloc(sizeof(struct node));
    printf("Enter data of the head node : ");
    scanf("%d", &head->data);
    struct node *temp = head;
    for (int i = 0; i < n - 1; i++){
        struct node* newnode = (struct node *)malloc(sizeof(struct node));
        printf("Enter data of the next node : ");
        scanf("%d", &newnode->data);
        temp->next = newnode;
        newnode->next = NULL;
        temp = newnode;
    }
    return head;
}

void delete_from_front(){
    struct node*p=head;
    head=head->next;
    free(p);
}

void delete_from_end(struct node* head){
    struct node*p=head->next;
    while(p->next){
        head=head->next;
        p=p->next;
    }
    head->next=NULL;
    free(p);
}

//Assuming index starts from 1
void deletion_using_index(int index){
    struct node*p=head->next;
    struct node*q=head;

    if(index==1){
        head=head->next;
        free(q);
        return;
    }

    index=index-2;
    while(index--){
        q=p;
        p=p->next;
    }
    q->next=p->next;
    free(p);
}

void deletion_using_value(int value){
    struct node*p=head;
    struct node*q=NULL;

    int count=0;
    while(value!=p->data){
        q=p;
        p=p->next;
        count=1;
    }

    if(count==0){
        head=head->next;
        free(q);
        return;
    }

    q->next=p->next;
    free(p);
}

void print_linkedlist(struct node* head){
    while(head){
        printf("%d ",head->data);
        head=head->next;
    }
    printf("\n");
}

int main(){
    int value,index,n;
    printf("Enter the initial number of nodes: ");
    scanf("%d",&n);
    head=create_list(n);
    printf("The initial linkedlist is\n");
    print_linkedlist(head);

    printf("After deleting from front new linked list is: ");
    delete_from_front();
    print_linkedlist(head);

    printf("After deleting from end new linked list is: ");
    delete_from_end(head);
    print_linkedlist(head);
    
    printf("Enter the index to delete: ");
    scanf("%d",&index);
    deletion_using_index(index);
    print_linkedlist(head);

    printf("Enter the value to delete: ");
    scanf("%d",&value);
    deletion_using_value(value);
    print_linkedlist(head);

    return 0;
}

