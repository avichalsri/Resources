f=open("testfile.txt","r")
t_data=[]
for line in f:
    for ch in line.split():
        t_data.append(ch)
no_of_spamfiles=2
no_of_nspamfiles=2
total_files=no_of_spamfiles+no_of_nspamfiles
spam1=['Horoscope','Aries','Tarus']
spam2=['Product','Offer','Discount']
spam=spam1+spam2
nspam1=['IIT','NIT','Faculties']
nspam2=['NIT','Conference','Paper']
nspam=nspam1+nspam2

vocab=set(spam1+spam2+nspam1+nspam2)
vocab_size=len(vocab)
print("Vocabulary Size: "+str(vocab_size))
print("Total words in Spam File: "+str(len(spam)))
print("Total words in Non-Spam File: "+str(len(nspam)))
print("--------------------------------------")
print("nk values for each word:")
sl=[]
nsl=[]
for ch in set(spam):
    sl.append((ch,spam.count(ch)))
for ch in set(nspam):
    nsl.append((ch,nspam.count(ch)))
final=sl+nsl
for ch in sl:
    print(ch[0],ch[1])
for ch in nsl:
    print(ch[0],ch[1])
print("--------------------------------------");
P_spam=no_of_spamfiles/total_files
P_nspam=no_of_nspamfiles/total_files
print("Prior_Probability(Spam): "+str(P_spam))
print("Prior_Probability(Non-Spam): "+str(P_nspam))
def check(word,typ):
    if typ=='spam':
        r=(spam.count(word)+1)/(len(spam)+vocab_size)
    else:
        r=(nspam.count(word)+1)/(len(nspam)+vocab_size)
    return r
def poster(lis,typ):
    if typ=='spam':
        r=P_spam
        for ch in lis:
            r=r*check(ch,'spam')
    else:
        r=P_nspam
        for ch in lis:
            r=r*check(ch,'nspam')
    return r
ps=poster(t_data,'spam')
pns=poster(t_data,'nspam')
print("Posterior(Spam): "+str(ps))
print("Posterior(Non-Spam): "+str(pns))
if(ps>pns):
    print("The file is Spam...")
else:
    print("The file is Non-Spam...")
    
        

        
    
