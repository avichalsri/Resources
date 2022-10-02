#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct queueUsingArray{
    int top,front,size;
    int *arr;
};

bool is_full(struct queueUsingArray *ptr){
    if(ptr->top==ptr->size-1)
        return true;
    else
        return false;
}

bool isempty(struct queueUsingArray *ptr){
    if(ptr->top==ptr->front)
        return true;
    else
        return false;
}

void push(struct queueUsingArray *ptr){
    int data;
    printf("Enter the value to be pushed into the queue: ");
    scanf("%d",&data);

    if(is_full(ptr))
        printf("Stack is Full\n");  

    else{
        ptr->top++;
        ptr->arr[ptr->top]=data;
    }
}

void pop(struct queueUsingArray *ptr){
    if(isempty(ptr))
        printf("Stack is empty\n");

    else{
        ptr->front++;
        printf("The popped out element is %d \n",ptr->arr[ptr->front]);
    }
}

int main(){
    int x;
    struct queueUsingArray *q=(struct queueUsingArray *)malloc(sizeof(struct queueUsingArray));
    printf("Enter the size of the queue: ");
    scanf("%d",&x);
    q->size=x;
    q->arr=(int*)malloc((q->size)*sizeof(int*));
    q->top=-1;
    q->front=-1;
    
    for(int i=0;i<q->size;i++){
        push(q);
    }
    printf("Suppose we push another number after the set limit\n");
    push(q);

    for(int i=0;i<q->size;i++){
        pop(q);
    }
    printf("Suppose we pop another element now\n");
    pop(q);
}
