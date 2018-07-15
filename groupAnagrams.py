

def groupAnagrams(strs):
    dict = {}

    for i in range(len(strs)):
        str = "".join(sorted(strs[i]))

        if str in dict:
            dict[str] = dict[str] + [strs[i]]
        else:
            dict[str] = [strs[i]]

    final = []
    for key in dict:
        final.append(dict[key])

    return final



strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
print(groupAnagrams(strs))
