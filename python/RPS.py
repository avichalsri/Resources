import random
def choices():

    player_choice = input("Enter a choice (rock,paper,scissors): ")
    options = ["rock", "paper", "scissors"]
    computer_choice = random.choice(options)
    choices = {"player": player_choice, "computer": computer_choice}
    return choices

def check_win(player_choice, computer_choice):
    print(f"player chose {player_choice} and computer chose {computer_choice}")
    
    if player_choice == computer_choice:
        return "it's a tie"
   
    elif player_choice == "rock":
        if computer_choice == "paper":
            return("computer wins")
        elif computer_choice == "scissors":
            return("player wins")
   
    elif player_choice == "paper":
        if computer_choice == "scissors":
            return("computer wins")
        elif computer_choice == "rock":
            return("player wins")

    elif player == "scissors":
        if computer_choice == "paper":
            return("player wins")
        elif computer_choice == "rock":
            return("computer  wins")    

choices=choices()    
print(check_win( choices["player"], choices["computer"]) )
