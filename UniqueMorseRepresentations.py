def uniqueMorseRepresentations(words):
    dict = {}
    values = [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
              ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."]

    count = 0
    for i in range(0, len(words)):
        strr = ""
        singleword = words[i]
        for j in range(0, len(singleword)):
            strr = strr + values[ord(singleword[j]) - 97]
        if not strr in dict:
            count = count + 1
        dict[strr] = True

    return count
