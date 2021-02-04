## @file TriangleT.py
#  @author
#  @brief
#  @date

from Shape import Shape

class TriangleT(Shape):
    x,y,s,m = 0.0,0.0,0.0,0.0

    def __init__(self,xs,ys,ss,ms):
        if (not (ss > 0 and ms > 0)):
            raise ValueError
        self.x, self.y, self.s, self.m = xs, ys, ss, ms

    def cm_x(self):
        return self.x

    def cm_y(self):
        return self.y

    def mass(self):
        return self.m

    def m_inert(self):
        return (self.m * self.s**2)/12
