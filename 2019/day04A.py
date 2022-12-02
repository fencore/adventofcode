from collections import Counter

minVal = 353096
maxVal = 843212
matchingVals = []

def testForSequence(inputVal):
    stringVal = str(inputVal)
    tallyList = Counter(stringVal)
    for digit, quant in tallyList.items():
        if quant == 2:
            return True
    return False

def testForAscend(inputVal):
    stringVal = str(inputVal)
    i = 0
    while i + 1 < len(stringVal):
        if int(stringVal[i]) <= int(stringVal[i+1]):
            i += 1
        else:
            return False
    return True

for testVal in range(minVal, maxVal):
    if testForSequence(testVal) and testForAscend(testVal):
        matchingVals.append(testVal)

print(f'{len(matchingVals)}')
