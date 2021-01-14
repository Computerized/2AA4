## @file triangle_adt.py
#  @author 
#  @brief 
#  @date

import math
from enum import Enum

class TriangleT:
    a,b,c = 0,0,0

    def __init__(self,a,b,c):
        self.a,self.b,self.c = a,b,c

    def get_sides(self):
        return self.a,self.b,self.c

    def equal(self,obj):
        return (self.a,self.b,self.c == obj.get_sides())

    def perim(self):
        return self.a + self.b + self.c

    def area(self):
        p = perim()
        return math.sqrt(p*(p - self.a)*(p - self.b)*(p - self.c))

    def is_valid(self):
        return (self.a + self.b > self.c) and (self.a + self.c > self.b) and (self.b + self.c > self.a)

    def tri_type(self):
        return TriType[1]

class TriType(Enum):
    equilat = 1
    isosceles = 2
    scalene = 3
    right = 4
        