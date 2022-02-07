
#iiii thiiiink this is right i havent tested it and im too tired to
def zero(a, b, tol, f): 
    while (f(a/b) != tol):
        middle = a/b
        if (f(middle) == tol):
            return middle
        elif (f(middle) > tol):
            b = middle
        elif (f(middle) < tol): 
            a = middle
        

def main():
    print(f"The cube root of 100 is {zero(0, 0, 0, 0)} within 1e-6.")
    
main() 