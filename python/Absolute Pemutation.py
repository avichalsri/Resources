#  https://www.hackerrank.com/challenges/absolute-permutation/problem

def absolutepermutation(n, k):
    arr = []

    if k == 0:
        return " ".join(str(x) for x in range(1, n + 1))

    elif n % (2 * k) != 0:
        return -1

    else:
        for i in range(n):
            if (i // k) % 2 == 0:
                arr.append(i + k + 1)

            else:
                arr.append(i - k + 1)

    return " ".join(str(x) for x in arr)
cases = int(input())
for i in range(cases):
    n, k = map(int, input().split())
    print(absolutepermutation(n, k))
