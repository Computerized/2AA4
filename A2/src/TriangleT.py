## @file TriangleT.py
#  @author Alan Scott
#  @brief Triangle Shape Class
#  @date 16/02/21

from Shape import Shape


class TriangleT(Shape):
    x, y, s, m = 0.0, 0.0, 0.0, 0.0

    ## @brief TriangleT Constructor
    #  @details This constructer creates a TriangleT type object. It takes in parameters
    #           for the x and y coordinates, side lengths and mass. If the side lengths
    #           or mass are below zero, then it throws a ValueError.
    #  @throws ValueError when side lengths or mass are not greater than zero
    #  @param xs x coordinate of the triangle
    #  @param ys y coordinate of the triangle
    #  @param ss side lengths of the triangle
    #  @param ms mass of the triangle
    def __init__(self, xs, ys, ss, ms):
        if (not (ss > 0 and ms > 0)):
            raise ValueError
        self.x, self.y, self.s, self.m = xs, ys, ss, ms

    ## @brief Inherited function for center of mass x
    #  @details This function is inherited from the Shape class. It returns the x value
    #           of the center of mass.
    def cm_x(self):
        return self.x

    ## @brief Inherited function for center of mass y
    #  @details This function is inherited from the Shape class. It returns the y value
    #           of the center of mass.
    def cm_y(self):
        return self.y

    ## @brief Inherited function for mass of the triangle
    #  @details This function is inherited from the Shape class. It returns the value
    #           of the center of mass.
    def mass(self):
        return self.m

    ## @brief Inherited function for moment of inertia of the triangle
    #  @details This function is inherited from the Shape class. It returns the value
    #           of the moment of inertia.
    def m_inert(self):
        return (self.m * self.s**2) / 12
