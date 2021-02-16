## @file CircleT.py
#  @author Alan Scott
#  @brief Class representing a Circle Shape
#  @date 11/02/21

from Shape import Shape


class CircleT(Shape):
    x,y,r,m = 0.0,0.0,0.0,0.0

    def __init__(self,xs,ys,rs,ms):
        if (not (rs > 0 and ms > 0)):
            raise ValueError
        self.x = xs
        self.y = ys
        self.r = rs
        self.m = ms

    ## @brief Return function for the x center of mass
    #  @details This function is inherited from the parent class, and returns the
    #           x value of the center of mass.
    def cm_x(self):
        return self.x

    ## @brief Return function for the y center of mass
    #  @details This function is inherited from the parent class, and returns the
    #           y value of the center of mass.
    def cm_y(self):
        return self.y

    ## @brief Return function for the mass of the circle
    #  @details This function is inherited from the parent class, and returns the
    #           mass of the circle.
    def mass(self):
        return self.m

    ## @brief Return function for the moment of intertia of the circle
    #  @details This function is inherited from the parent class, and returns the
    #           moment of inertia of the circle.
    def m_inert(self):
        return (self.m*self.r**2)/2