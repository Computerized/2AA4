## @file SetOfInt.py
#  @author Your Name
#  @brief Set of integers
#  @date 03/04/2021

class SetOfInt:

    def __init__(self, s):
        self.s = s

    def is_member(self, x):
        return x in self.s

    def to_seq(self):
        return self.__set_to_seq__(self.s)

    def union(self, t):
        newList = list(self.s) + t.to_seq()
        return SetOfInt(self.__set_to_seq__(newList))
    
    def diff(self, t):
        new_set = []
        for item in self.s:
            if not(item in t.to_seq()):
                new_set.append(item)
        return SetOfInt(self.__set_to_seq__(new_set))

    def size(self):
        return len(self.s)

    def empty(self):
        return []

    def equals(self, t):
        if len(self.to_seq()) != len(t.to_seq()):
            return False
        for i in range(len(t.to_seq())):
            if t.to_seq()[i] != self.to_seq()[i]:
                return False
        return True

    def __set_to_seq__(self, s):
        return sorted(list(s))

    

        