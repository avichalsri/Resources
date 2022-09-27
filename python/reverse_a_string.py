def reverse(s):
    string = ""
    for i in s:
        str = i + str
    return str


s = "hacktoberfest2022"

print("The original string is : ", end="")
print(s)

print("The reversed string is : ", end="")
print(reverse(s))