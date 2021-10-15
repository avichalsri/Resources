link to question [https://www.hackerrank.com/challenges/30-class-vs-instance/problem](https://www.hackerrank.com/challenges/30-class-vs-instance/problem)

class Person:
    def __init__(self,initialAge):
        self.initialAge=initialAge
        if initialAge<0:
            initialAge=0
            print('Age is not valid, setting age to 0.')
        else:
            self.initialAge=initialAge
        # Add some more code to run some checks on initialAge
    def amIOld(self):
        a=p.initialAge
        if a<13:
            print("You are young.")

        elif a>=13 and a<18:
            print("You are a teenager.")
        else:
            print("You are old.")
        # Do some computations in here and print out the correct statement to the console
    def yearPasses(self):
        self.initialAge+=1
