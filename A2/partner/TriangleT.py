## @file TriangleT.py
#  @author Samia Anwar
#  @brief Contains a TriangleT type to represent an equilateral triangle
#  with a mass on a plane
#  @date Feb 2/2021

from Shape import Shape

## @brief TriangleT is used to represent an equilateral Triangle on a plane with a mass
#  to eventually calculate its moment of inertia when called on


class TriangleT(Shape):
    ## @brief constructor for class TriangleT, represents a triangle as its
    #  cartesian coordinates of the center, its side length, and its mass
    #  @param x is a real number representation of the x coordinate of the
    #  centre of the triangle
    #  @param y is a real number representation of the y coordinate of the centre of
    #  the triangle
    #  @param s is a real number representation of all sides of the equilateral triangle
    #  @param m is a real number representation of the mass of the triangle
    #  @details the units of these real number representations is at the discretion
    #  of the user and is no way controlled or represented in this python implementation
    #  @throws ValueError raised if either the mass or side length is defined to be less than
    #  or equal to zero
    def __init__(self, x, y, s, m):
        if (not (s > 0 and m > 0)):
            raise ValueError
        self.x = x
        self.y = y
        self.s = s
        self.m = m

    ## @brief returns the x coordinate of the center of the triangle
    #  @return real number representation of x-coordinate of the centre of the triangle
    def cm_x(self):
        return self.x

    ## @brief returns the y coordinate of the center of the triangle
    #  @return real number representation of x-coordinate of the centre of the triangle
    def cm_y(self):
        return self.y

    ## @brief returns the mass of the triangle
    #  @return real number representation of mass of the triangle
    def mass(self):
        return self.m

    ## @brief returns the mass of the triangle based on a formula using the initialised
    #  mass and side length values
    #  @return real number representation of moment of inertia of the triangle
    def m_inert(self):
        return (self.m * self.s * self.s / 12)
