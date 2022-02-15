def bezout(a, b):
    """precondition: a and b are integers, not both zero.
    postcondition:  return a tuple (x,y) so that a*x + b*y = gcd(a,b)."""
    s = 0; old_s = 1
    t = 1; old_t = 0
    r = b; old_r = a

    while r != 0:
        quotient = old_r//r 
        old_r, r = r, old_r - quotient*r
        old_s, s = s, old_s - quotient*s
        old_t, t = t, old_t - quotient*t
    return (old_s, old_t)

def main():
    print("Testing the bezout function")
    res = bezout(24,18)
    print(res)
    res = bezout(31,17)
    print(res   )
    
main()     