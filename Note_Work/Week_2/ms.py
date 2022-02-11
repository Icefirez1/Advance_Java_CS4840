from sys import argv
from random import shuffle
def swap(x, j, k):
    if j != k:
        x[j],x[k] = x[k],x[j]
def zipper(x, y):
    out = []
    px = 0
    py = 0
    while px < len(x) and py < len(y):
        if x[px] < y[py]:
            out.append(x[px])
            px += 1
        else:
            out.append(y[py])
            py += 1
    out.extend(x[px:])
    out.extend(y[py:])
    return out
def merge_sort(x):
    if len(x) < 2:
        return x
    ## Stupid Questions for $2,000
    n = len(x)//2
    first = x[:n]
    second = x[n:]
    return zipper(merge_sort(first), merge_sort(second))
def main():
    n = int(argv[1])
    x = list(range(n))
    shuffle(x)
    print(x)
    print(merge_sort(x))
if __name__ == "__main__":
    main()