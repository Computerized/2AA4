##  @file triangle_adt.py
#  @author Alan Scott
#  @brief Contains a class which represents a given triangle
#  @date 01/18/2020

import math
from enum import Enum


##  @brief Triangle defined by 3 side lengths
#  @details An ADT for a triangle represented by 3 side lengths
class TriangleT:
    a, b, c = 0, 0, 0

    ##  @brief Constructor for TriangleT
    #  @details This constructor creates a triangle from 3 given side lengths
    #  @param a An integer representing the length of the first side
    #  @param b An integer representing the length of the second side
    #  @param c An integer representing the length of the third side
    def __init__(self, a, b, c):
        self.a, self.b, self.c = a, b, c

    ## @brief Returns the side lengths of the triangle
    #  @details This function returns the three side lengths as a tuple
    #  @return The three side lengths in a tuple
    def get_sides(self):
        sides = self.a, self.b, self.c
        return sides

    ## @brief Compares the current triangle and a given triangle
    #  @details This function checks if two side triangles are equivalent by
    #           checking if the sorted sets of their side lengths are equal
    #  @return True if the triangles are equal
    #  @param obj The triangle being compared to
    def equal(self, obj):
        objsides = obj.get_sides()
        sides = self.a, self.b, self.c
        return sorted(sides) == sorted(objsides)

    ## @brief Sums the side lengths of all 3 sides
    #  @details This function returns the sum of all of the side lengths
    #  @return The perimeter of the triangle
    def perim(self):
        return self.a + self.b + self.c

    ## @brief Computes the area of the triangle
    #  @details Computes the area of the triangle using Heron's theorem. Taken
    #           from: https://www.mathsisfun.com/geometry/herons-formula.html
    #  @return The area of the triangle
    def area(self):
        p = self.perim()/2
        return math.sqrt(p*(p - self.a)*(p - self.b)*(p - self.c))

    ## @brief Determines whether the given triangle is possible in Euclidian space
    #  @details This fuction tests if all the side lengths are greater than 0,
    #           and that no side length is greater than the sum of the other
    #           two.
    #  @return True if the triangle is physically possible, False if otherwise
    def is_valid(self):
        if (self.a + self.b < self.c):
            return False
        if (self.a + self.c < self.b):
            return False
        if (self.b + self.c < self.a):
            return False
        if (self.a > 0 and self.b > 0 and self.c > 0):
            return True
        return False

    ## @brief Determines the type of the triangle
    #  @details This function tests what type of triangle the current object
    #           is. If the triangle is not a possible triangle, it returns
    #           a None type. Due to only being able to return a single value,
    #           right triangles are prioritized over isosclese and scalene
    #           triangles in the case that it happens to be both.
    #  @return A TriType value representing the type of triangle
    def tri_type(self):
        if (self.is_valid() == False):
            return None
        if (self.a == self.b and self.a == self.c):
            return TriType.equilat
        sort_list = [self.a, self.b, self.c]
        sort_list.sort()
        if (sort_list[0]**2 + sort_list[1]**2 == sort_list[2]**2):
            return TriType.right
        if (self.a == self.b or self.b == self.c or self.a == self.c):
            return TriType.isosceles
        return TriType.scalene


## @brief TriType enumerate object type
#  @details This class is an enumerated list which represents one of four
#           different types of triangles. 
class TriType(Enum):
    equilat = 1
    isosceles = 2
    scalene = 3
    right = 4
