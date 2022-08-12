

print("                                                          Welcome To The National Voting System")

print("--------------------------------------------------------------------------------------------------------------------------------------------------------")

#This List Is Used For Storing The Names Who Will Be Casting The Vote

voter=["Chanchal:0191CS191047","ayush:0191IT191048","kishti:0191CS191049"]

#This List Stores For Bjp

party1=[]

#This List Stores For Congress

part2=[]

#This List Stores For Aam Admi Party

part3=[]

#This List Stores The No Of Persons Who Have Casted The Vote

voted=[]

while(True):

    print("Press 1 For Login\nPress 2 For Result")

    press=int(input())

    if press==1:

        print("Please Enter Your Name Along With Voter-Id Eg Chanchal:0191CS191047")

        name=input()

        if name in voted:

            print("----------------------------------------------------------------------------------------------------------------------------------------------------")

            print("Already Voted")

            print("------------------------------------------------------------------------------------------------------------------------------------------------------")

        else:

            if name not in voted:

                    if name in voter:

                        print("-------------------------------------------------------------------------------------------------------------------------------------------------------------")

                        print("                                                     Welcome To The E-Voting System",name)

                        print("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------")

                        print("Press 1 For BJP\nPress 2 For Congress\nPress 3 For Aam Admi Party")

                        choise=int(input())

                        if choise==1:

                            party1.append("BJP")

                            voted.append(name)

                            print("---------------------------------------------------------------------------------------------------------------------------------------------------------")

                            print("Thanks For Casting Vote")

                            print("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")

                            import os

                            os.system("cls")

                        if choise==2:

                            part2.append("Congress")

                            voted.append(name)

                            print("Thanks For Casting Vote")

                            import os

                            os.system("cls")

                        if choise==3:

                            part3.append("Aam Admi Party")

                            part3.append(name)

                            print("Thanks For Casting Vote")

                            import os

                            os.system("cls")

                    else:

                        print("Go out")

    if press==2:

        print("Please Enter The Password to acess")

        password=int(input())

        if password==70000522673:

            print("Acess Granted")

            print("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")

            print("BJP's Vote is",len(party1))

            print("Congresse's vote is",len(part2))

            print("Aam Admi Party's Vote is",len(part3))

            print("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")

Footer

© 2022 GitHub, Inc.

Footer navigation

Terms

Privacy

Security

Status

Docs

Contact GitHub

