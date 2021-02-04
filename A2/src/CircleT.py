## @file CircleT.py
#  @author Alan Scott
#  @brief
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

    def cm_x(self):
        return self.x

    def cm_y(self):
        return self.y

    def mass(self):
        return self.m

    def m_inert(self):
        return (self.m*self.r**2)/2