## @file SeqServicesLibrary.py
#  @author Your name
#  @brief Library module that provides functions for working with sequences
#  @details This library assumes that all functions will be provided with arguments of the expected types
#  @date 03/04/2021

def max_val(s):
    if len(s) == 0:
        raise(ValueError)
    max_value = abs(s[0])
    for v in s:
        if abs(v) > max_value:
            max_value = abs(v) #finds largest absolute value in list
    return max_value

def count(t, s):
    if len(s) == 0:
        raise(ValueError)
    count = 0
    for item in s:
        if t == item:
            count += 1 #increment for every matching value of t in s
    return count

def spices(s):
    if len(s) == 0:
        raise(ValueError)
    lst = []
    for item in s:
        if item <= 0:
            lst.append("nutmeg") #append "nutmeg" for non-positive values
        else:
            lst.append("ginger") #append "ginger" for positive values
    return lst

def new_max_val(s, f):
    if len(s) == 0:
        raise(ValueError)
    return max_val(list(map(f,s))) #maps the given function onto s, then puts it through max_val
    

