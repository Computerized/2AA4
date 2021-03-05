## @file SetOfInt.py
#  @author Your Name
#  @brief Set of integers
#  @date 03/04/2021

class SetOfInt:

    def __init__(self, s):
        self.s = s

    def is_member(self, x):
        return x in self.s #true if x in s, false otherwise

    def to_seq(self):
        return self.__set_to_seq__(self.s) #returns sequence of s

    def union(self, t):
        newList = list(self.s) + t.to_seq() #concatenates two lists
        return SetOfInt(self.__set_to_seq__(newList))
    
    def diff(self, t):
        new_set = []
        for item in self.s: #for every item in set A
            if not(item in t.to_seq()): #if item is not in set B ((B - A) same as A ⋂ ~B)
                new_set.append(item) #add in new set
        return SetOfInt(self.__set_to_seq__(new_set))

    def size(self):
        return len(self.s)

    def empty(self):
        return len(self.s) == 0

    def equals(self, t):
        if len(self.to_seq()) != len(t.to_seq()): #if not same length, automatically unequal
            return False
        for i in range(len(t.to_seq())): 
            if t.to_seq()[i] != self.to_seq()[i]: #compares each item to item in same index in parallel list (lists are sorted)
                return False
        return True

    def __set_to_seq__(self, s):
        return sorted(list(s)) #sorting is for use in equals

    

        