#  https://www.hackerrank.com/challenges/insertion-sort/problem?h_r=internal-search

def inv_count(arr):
    def sorting(i, j):
        if j - i < 2:
            return 0
        else:
            mid = (i + j) // 2
            res = sorting(i, mid) + sorting(mid, j)
            temp = []
            left, right = i, mid
            while left < mid and right < j:
                if arr[left] > arr[right]:
                    temp.append(arr[right])
                    right += 1
                    res += (mid - left)
                else:
                    temp.append(arr[left])
                    left += 1
            while left < mid:
                temp.append(arr[left])
                left += 1
            while right < j:
                temp.append(arr[right])
                right += 1
            arr[i:j] = temp
            return res

    return sorting(0, len(arr))


test = int(input())
for case in range(test):
    n = int(input())
    arr = list(map(int, input().split()))
    print(inv_count(arr))
