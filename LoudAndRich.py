import collections

def loudAndRich(richer, quiet):
    dicRicher = collections.defaultdict(list)
    for i,j in richer:
        dicRicher[j].append(i)
    res = [-1] * len(quiet)

    def DFS(i):
        if res[i] > -1: return res[i]
        res[i] = i
        for j in dicRicher[i]:
            if quiet[res[i]] > quiet[DFS(j)]:
                res[i] = res[j]
        return res[i]

    for i in range(len(quiet)):
        DFS(i)

    return res

richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]
quiet = [3,2,5,4,6,1,7,0]
print(loudAndRich(richer, quiet))

