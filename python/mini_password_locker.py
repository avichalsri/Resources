#! python3

# modules 
# re module is to search for the patterns in the text
# sys module is to grab the arguments from user
# pyperclip module used to copy the text to the clipboard
# shelve module is used to store the variables in binary file
# password_generator module is used to generate new strong password
# cryptography module is used to encrypt and decrypt the passwords

# import re, sys, pyperclip, shelve
# from password_generator.password import Password
# from cryptography.fernet import Fernet

try:
    import re
    import sys
    import shelve
    import pyperclip
    from password_generator.password import Password
    from cryptography.fernet import Fernet
except:
    import subprocess
    if sys.platform in ['win32', 'cygwin']:
        subprocess.check_output("python -m pip install --upgrade pip", shell=True)
        subprocess.check_output("python -m pip install pyperclip", shell=True)
        subprocess.check_output("python -m pip install password-generator-module", shell=True)
        subprocess.check_output("python -m pip install cryptography", shell=True)
    else:
        subprocess.check_output("pip install --upgrade pip", shell=True)
        subprocess.check_output("pip install pyperclip", shell=True)
        subprocess.check_output("pip install password-generator-module", shell=True)
        subprocess.check_output("pip install cryptography", shell=True)
    import pyperclip
    from password_generator.password import Password
    from cryptography.fernet import Fernet

p = Password()
locker = shelve.open('locker')

# password strength check pattern
passwordPattern = re.compile(r'''
  ^(?=.*?[A-Z])                   # at least 1 capital letter
  (?=.*?[a-z])                    # at least 1 lower case letter
  (?=.*?[0-9])                    # at least 1 digit
  (?=.*?[#?!@$%^&*()\-_=+./\\])   # at least 1 special character
  .{8,}$                          # at least 8 characters long
''', re.VERBOSE)

def usage():
    f = "[+] python mini_password_locker.py"
    print("[=] Usage")
    print(f"[+] {f} delete -> to delete all the passwords")
    print(f"[+] {f} list -> to list all the sites stored in the file")
    print(f"[+] {f} copy <site> -> copies the site password to the clipboard if present")
    print(f"[+] {f} delete <site> -> deletes the password of the site")
    print(f"[+] {f} save <site> <password> -> saves the password to the keyword site mentioned")
    print(f"[+] {f} update <site> <password> -> updates the site password to new password")
    print(f"[+] {f} new <site> <length> -> generates a new password and stores it in the file")
    locker.close()
    sys.exit()

def suggestions():
    print("[+] Here are some suggestions")
    print("[+] password must contain")
    print("\t[+] atleast one capital letter\n\t[+] atleast one small letter\n\t[+] atleast one letter\n\t[+] atleast one special character\n\t[+] atleast should be 8 characters long")
    sys.exit()

def badPassword():
    print("[-] Bad Password")
    locker.close()
    suggestions()

def encryptPassword(userPassword):
    key = Fernet.generate_key()
    crypter = Fernet(key)
    encrypt = crypter.encrypt(userPassword.encode('utf8'))
    safeBox = {"key":key,"password":encrypt}
    return safeBox

def decryptPassword(safeBox):
    crypter = Fernet(safeBox['key'])
    decrypt = str(crypter.decrypt(safeBox['password']),'utf8')
    return decrypt

if len(sys.argv) == 2:
    if sys.argv[1].lower() == 'delete':
        for i in locker:
            del locker[i]
        print("[-] Deleted all the saved passwords")

    elif sys.argv[1].lower() == 'list':
        print(list(locker.keys()))

    elif sys.argv[1].lower() == 'passwordsuggestions':
        suggestions()
    else:
        usage()

elif len(sys.argv) == 3:
    if sys.argv[1].lower() not in ['copy', 'delete']:
        usage()

    elif sys.argv[2] in locker.keys():
        if sys.argv[1].lower() == 'copy':
            pyperclip.copy(decryptPassword(locker[sys.argv[2]]))
            print("[+] Password copied to clipboard")
    
    elif sys.argv[1].lower() == 'delete':
        del locker[sys.argv[2]]
        print("[+] Successfully deleted the password from locker")
  
    else:
        print("[-] No such site exists in locker")
        print("[+] Use 'python passwordLoacker.py list' -> (to list all the sites saved in locker)")

elif len(sys.argv) == 4:
    if sys.argv[1].lower() == 'new':
        if int(sys.argv[3]) < 8:
            print("[-] Bad choice of length of password")
            print("[-] Length of password should be atleast 8")
    
        else:
            while True:
                newPassword = p.generate_password(int(sys.argv[3]))
                if passwordPattern.search(newPassword):
                    safeBox = encryptPassword(newPassword)
                    if sys.argv[2] in locker.keys():
                        print("[-] Site password is already present in locker, old password is overwritten by new one")
                    locker[sys.argv[2]] = safeBox
                    pyperclip.copy(newPassword)
                    print("[+] Generated password is copied to clipboard")
                    break
  
    elif passwordPattern.search(sys.argv[3]):
        if sys.argv[1].lower() not in ['save', 'update']:
            usage()

        elif sys.argv[1].lower() == 'save':
            print("[+] Password saved in locker successfully")
    
        elif sys.argv[1].lower() == 'update':
            if sys.argv[2] not in locker.keys():
                print("[-] There is no such stored credentials found in locker, creating new credentials in locker")
            print("[+] Updated credentials in locker")

        safeBox = encryptPassword(sys.argv[3])
        locker[sys.argv[2]] = safeBox
    else:
        badPassword()

else:
    usage()

locker.close()
sys.exit()