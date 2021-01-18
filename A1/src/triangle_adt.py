#  @file triangle_adt.py
#  @author Alan Scott
#  @brief Contains a class which represents a given triangle
#  @date 01/18/2020

import math
from enum import Enum


#  @brief An ADT for a triangle represented by 3 side lengths
#  @details Triangle defined by 3 side lengths
class TriangleT:
    a, b, c = 0, 0, 0

    #  @brief Constructor for TriangleT
    #  @details Represents a triangle with 3 given sides
    #  @param a An integer representing the length of the first side
    #  @param b An integer representing the length of the second side
    #  @param c An integer representing the length of the third side
    def __init__(self, a, b, c):
        self.a, self.b, self.c = a, b, c

    # @brief Returns the side lengths of the triangle
    #  @return The three side lengths in a tuple
    def get_sides(self):
        return self.a, self.b, self.c

    # @brief Compares the current triangle and a given triangle
    #  @return True if the triangles are equal
    #  @param obj The triangle being compared to
    def equal(self, obj):
        return (self.a, self.b, self.c == obj.get_sides())

    # @brief Sums the side lengths of all 3 sides
    #  @return The perimeter of the triangle
    def perim(self):
        return self.a + self.b + self.c

    # @brief Computes the area of the triangle
    #  @return The area of the triangle
    def area(self):
        p = self.perim()/2
        return math.sqrt(p*(p - self.a)*(p - self.b)*(p - self.c))

    # @brief Determines whether the given triangle is possible in Euclidian space
    #  @return True if the triangle is physically possible
    def is_valid(self):
        return (self.a + self.b > self.c) and (self.a + self.c > self.b) and (self.b + self.c > self.a) and self.a > 0 and self.b > 0 and self.c > 0

    # @brief Determines the type of the triangle
    #  @return A TriType value representing the type of triangle
    def tri_type(self):
        if (self.a == self.b and self.a == self.c):
            return TriType.equilat
        elif (self.a == self.b or self.b == self.c or self.a == self.c):
            return TriType.isosceles
        elif (self.a ** 2 + self.b ** 2 == self.c ** 2 or self.b ** 2 + self.c ** 2 == self.a ** 2 or self.a ** 2 + self.c ** 2 == self.b ** 2):
            return TriType.right
        return TriType.scalene


class TriType(Enum):
    equilat = 1
    isosceles = 2
    scalene = 3
    right = 4
