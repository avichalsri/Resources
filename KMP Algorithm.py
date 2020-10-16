def findText(searchContent: str, searchPattern: str) -> int:
    m = len(searchContent)
    n = len(searchPattern)

    # Create lps[] that will hold the longest prefix suffix values for pattern
    lps = [None] * m

    computeLPSArray(searchContent, lps)

    i, j = 0, 0
    res = 0
    next_i = 0

    while i < n:
        if searchContent[j] == searchPattern[i]:
            j = j + 1
            i = i + 1
        if j == m:

            # When we find pattern first time,
            # we iterate again to check if there
            # exists more pattern
            j = lps[j - 1]
            res = res + 1

            if lps[j] != 0:
                next_i = next_i + 1
                i = next_i
                j = 0

        elif (i < n) and (searchContent[j] != searchPattern[i]):

            if j != 0:
                j = lps[j - 1]
            else:
                i = i + 1

    return res


def computeLPSArray(searchContent: str, lps: list) -> None:
    # Length of the previous longest
    # prefix suffix
    length = 0
    i = 1
    lps[0] = 0  # lps[0] is always 0
    m = len(searchContent)
    while i < m:
        if searchContent[i] == searchContent[length]:
            length = length + 1
            lps[i] = length
            i = i + 1

        else:

            if length != 0:
                length = lps[length - 1]

            else:
                lps[i] = length
                i = i + 1

    return


# Driver code
if __name__ == "__main__":
    searchContent = "This is a test"
    searchPattern = "test"
    ans = findText(searchPattern, searchContent)

    print("The input",searchPattern,"occurs", ans, "time(s) in the search content")
