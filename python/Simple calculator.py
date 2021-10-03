from tkinter import *
import math

def place(val):
    global operator
    operator=operator+str(val)
    text.set(operator)

def cleardisplay():
    global operator
    operator=""
    text.set(operator)
def equals():
    global operator
    try:
        summ=str(eval(operator))
        
    except Exception as e:
        print(e)
        summ="Error"
    text.set(summ)

    

root=Tk()
root.title("Calculator")
operator=""
text=StringVar() #taking input in text


text_entry=Entry(root,font=('arial',20,'bold'),textvariable=text,bd=18,insertwidth=4,
            bg="white",justify='right').grid(columnspan=4)


#########################################################

b7=Button(root,padx=16,pady=16,bd=8,fg="black",text="7",
          font=('arial',20,'bold'),bg="powder blue",
          command=lambda:place("7")).grid(row=1,column=0)


b8=Button(root,padx=16,pady=16,bd=8,fg="black",
          text="8",font=('arial',20,'bold'),bg="powder blue",
          command=lambda:place("8")).grid(row=1,column=1)


b9=Button(root,padx=16,pady=16,bd=8,fg="black",
          text="9",font=('arial',20,'bold'),bg="powder blue",
          command=lambda:place("9")).grid(row=1,column=2)

badd=Button(root,padx=16,pady=16,bd=8,fg="black",
            text="+",font=('arial',20,'bold'),bg="powder blue",
            command=lambda:place("+")).grid(row=1,column=3)


##########################################################

b4=Button(root,padx=16,pady=16,bd=8,fg="black",text="4",
          font=('arial',20,'bold'),bg="powder blue",
          command=lambda:place(4)).grid(row=2,column=0)


b5=Button(root,padx=16,pady=16,bd=8,fg="black",
          text="5",font=('arial',20,'bold'),bg="powder blue",
          command=lambda:place(5)).grid(row=2,column=1)


b6=Button(root,padx=16,pady=16,bd=8,fg="black",
          text="6",font=('arial',20,'bold'),bg="powder blue",
          command=lambda:place(6)).grid(row=2,column=2)

bsub=Button(root,padx=16,pady=16,bd=8,fg="black",
            text="-",font=('arial',20,'bold'),bg="powder blue",
            command=lambda:place("-")).grid(row=2,column=3)
############################################################

b1=Button(root,padx=16,pady=16,bd=8,fg="black",text="1",
          font=('arial',20,'bold'),bg="powder blue",
          command=lambda:place(1)).grid(row=3,column=0)


b2=Button(root,padx=16,pady=16,bd=8,fg="black",
          text="2",font=('arial',20,'bold'),bg="powder blue",
          command=lambda:place(2)).grid(row=3,column=1)


b3=Button(root,padx=16,pady=16,bd=8,fg="black",
          text="3",font=('arial',20,'bold'),bg="powder blue",
          command=lambda:place(3)).grid(row=3,column=2)

bmul=Button(root,padx=16,pady=16,bd=8,fg="black",
            text="*",font=('arial',20,'bold'),bg="powder blue",
            command=lambda:place("*")).grid(row=3,column=3)
############################################################

b0=Button(root,padx=16,pady=16,bd=8,fg="black",text="0",
          font=('arial',20,'bold'),bg="powder blue",
          command=lambda:place(0)).grid(row=4,column=0)


bc=Button(root,padx=16,pady=16,bd=8,fg="black",
          text="C",font=('arial',20,'bold'),bg="powder blue",
          command=lambda:cleardisplay()).grid(row=4,column=1)


bequal=Button(root,padx=16,pady=16,bd=8,fg="black",
          text="=",font=('arial',20,'bold'),bg="powder blue",
          command=lambda:equals()).grid(row=4,column=2)

bdiv=Button(root,padx=16,pady=16,bd=8,fg="black",
            text="/",font=('arial',20,'bold'),bg="powder blue",
            command=lambda:place("/")).grid(row=4,column=3)
############################################################
bdiv=Button(root,padx=16,pady=16,bd=8,fg="black",
            text=".",font=('arial',20,'bold'),bg="powder blue",
            command=lambda:place(".")).grid(row=5,column=3)

bdiv=Button(root,padx=16,pady=16,bd=8,fg="black",
            text="(",font=('arial',20,'bold'),bg="powder blue",
            command=lambda:place("(")).grid(row=5,column=0)

bdiv=Button(root,padx=16,pady=16,bd=8,fg="black",
            text=")",font=('arial',20,'bold'),bg="powder blue",
            command=lambda:place(")")).grid(row=5,column=1)

bdiv=Button(root,padx=16,pady=16,bd=8,fg="black",
            text="%",font=('arial',20,'bold'),bg="powder blue",
            command=lambda:place("%")).grid(row=5,column=2)

root.mainloop()
