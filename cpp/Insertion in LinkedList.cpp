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

void delete_from_front(struct node* head){
    struct node*p=head;
    head=head->next;
    free(p);
}

void print_linkedlist(struct node* head){
    while(head){
        printf("%d ",head->data);
        head=head->next;
    }
    printf("\n");
}

void insert_first(int value){
    
    struct node *ptr=(struct node*)malloc(sizeof(struct node));
    ptr->data=value;
    ptr->next=head;
    head=ptr;
}

void insert_end(int value){
    struct node *ptr, *temp;
    ptr=(struct node*)malloc(sizeof(struct node));
    temp=head;
    while(temp->next){
        temp=temp->next;
    }
    temp->next=ptr;
    ptr->data=value;
    ptr->next=NULL;
}

void insert_at_given_index(int index,int value){
    struct node *ptr,*temp=head;
    ptr = (struct node *)malloc(sizeof(struct node));

    if (index == 0){
        ptr->data=value;
        ptr->next = head;
        head = ptr;
        return;
    }

    for (int i = 0; i < index - 1; i++){
        temp = temp->next;
    }
    ptr->data=value;
    ptr->next = temp->next;
    temp->next = ptr;
    return;
}


int main(){
    int data,index,n;
    printf("Enter the initial number of nodes: ");
    scanf("%d",&n);
    head=create_list(n);
    printf("The initial linkedlist is\n");
    print_linkedlist(head);

    printf("Enter the value to insert at beginning: ");
    scanf("%d",&data);
    insert_first(data);
    printf("The new linkedlist is\n");
    print_linkedlist(head);

    printf("Enter the value to insert at end: ");
    scanf("%d",&data);
    insert_end(data);
    printf("The new linkedlist is\n");
    print_linkedlist(head);

    printf("Enter the index and the value to insert at that index respectively: ");
    scanf("%d%d",&index,&data);
    insert_at_given_index(index,data);
    printf("The new linkedlist is\n");
    print_linkedlist(head);

    return 0;
}

"Inserting in a singly linked list at beginning"
1. Pass the value to a function named insert_first().
2. Dynamically create a struct node type pointer (say ptr).
3. Set the ptr data to the value passed to the function in the function call
        i.e, ptr->data=value;
4. Now set the ptr->next to the head of the linkedlist;
5. Now point the head to ptr. (head=ptr)
  

"Inserting in a singly linked list at end"
1. Pass the value to a function named insert_end().
2. Create 2 struct node type pointers (ptr and temp).
3. Point temp to head
4. Dynamically allocate memory for ptr
5. Iterate the linkedlist using temp while temp->next!=NULL
6. Now point temp->next to ptr
7. Assign ptr->data to value passed to the function
8. Finally to terminate the list perform ptr->next=NULL.

"Inserting in a singly linked list at a given index"
1. Pass the index and value to a function named insert_at_given_index().
2. Create 2 struct node type pointers (ptr and temp).
3. Point temp to head.
4. Dynamically allocate memory for ptr.
5. if(index==0) perform:
        ptr->data=value;
        ptr->next = head;
        head = ptr;
        return; (to exit from function)
6. else iterate the linkedlist using temp pointer and stop at index-1.
7. Now perform the followong operation to insert ptr in the linkedlist
        ptr->data=value;
        ptr->next = temp->next;
        temp->next = ptr;
        return;
