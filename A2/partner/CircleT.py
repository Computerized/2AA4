## @file CircleT.py
#  @author Samia Anwar
#  @brief Contains a CircleT type to represent a circle with a mass on a plane
#  @date February 2, 2021

from Shape import Shape

## @brief CircleT is used to represent a circle on a plane with a mass
#  to calculate its moment of inertia


class CircleT(Shape):
    ## @brief constructor for class CircleT, represents circles as their
    #  cartesian coordinates of the center, their radius, and their mass
    #  @param x is a real number representation of the x coordinate of the
    #  centre of the circle
    #  @param y is a real number representation of the y coordinate of the centre of
    #  the circle
    #  @param r is a real number representation of the radius of the circle
    #  @param m is a real number representation of the mass of the circle
    #  @details the units of these real number representations is at the discretion
    #  of the user and is no way controlled or represented in this python implementation
    #  @throws ValueError raised if either the mass or radius is defined to be less than
    #  or equal to zero
    def __init__(self, x, y, r, m):
        if (m <= 0 or r <= 0):
            raise ValueError
        self.x = x
        self.y = y
        self.r = r
        self.m = m

    ## @brief returns the x coordinate of the center of the circle
    #  @return real number representation of x-coordinate of the centre of the circle
    def cm_x(self):
        return self.x

    ## @brief returns the y coordinate of the center of the circle
    #  @return real number representation of x-coordinate of the centre of the circle
    def cm_y(self):
        return self.y

    ## @brief returns the mass of the circle
    #  @return real number representation of mass of the circle
    def mass(self):
        return self.m

    ## @brief returns the mass of the circle based on a formula using the initialised
    #  mass and radius values
    #  @return real number representation of moment of inertia of the circle
    def m_inert(self):
        return (self.m * self.r * self.r) / 2
