def is_prime_bad(n):
    for k in range(2, n):
        if n%k == 0:
            return False
    return True

def is_prime_better(n):
    if n == 2: 
        return True
    if n% 2 == 0: 
        return False
    count = 3
    while (count**2 <= n):
        if n%count == 0: 
            return False
        count += 2
    return True 

if __name__ == "__main__":
    print(is_prime_better(997))
    print(is_prime_better(997))
