## @file TriangleT.py
#  @author Alan Scott
#  @brief Triangle Shape Class
#  @date 16/02/21

from Shape import Shape

class TriangleT(Shape):
    x,y,s,m = 0.0,0.0,0.0,0.0

    def __init__(self,xs,ys,ss,ms):
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
        return (self.m * self.s**2)/12
