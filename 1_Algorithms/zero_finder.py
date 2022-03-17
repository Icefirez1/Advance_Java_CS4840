
#iiii thiiiink this is right i havent tested it and im too tired to
def zero(a, b, tol, f): 
    middle = (a + b)/2
    while b-a > tol:
        if (f(middle)*f(a) < 0):
            b = middle
        else:
            a = middle
        middle = (a + b)/2
    return middle

# def zero_2(start, end, tol, fun):
#     middle = (start + end) / 2
#     print(middle)
#     while (not check_tol(fun(middle), 0, tol)):
#         middle = (start + end) / 2
#         print(fun(middle))
#         if fun(middle) < 0-tol:
#             print('a')
#             start = middle
#         elif fun(middle) > 0+tol:
#             print('b')
#             end = middle
#     return middle
    

# def check_tol(val, check, tol):
#     return check-tol <= val <= check+tol

def function(num):
    return (num**3) - 100 

def main():
    print(f"The cube root of 100 is {zero(-10, 8, 10**-6, function)} within 1e-6.")
    
main() 