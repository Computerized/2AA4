## @file BodyT.py
#  @author Alan Scott
#  @brief
#  @date

from Shape import Shape

class BodyT(Shape):
    cmx, cmy, m, moment = 0.0, 0.0, 0.0, 0.0

    def __init__(self,xs,ys,ms,):
        if (not (len(xs) == len(ys) and (len(ys) == len(ms)))):
            raise Exception("ValueError")
        for i in range(len(ms)):
            if (ms[i] <= 0):
                raise Exception("ValueError")

    def cm_x(self):
        return self.cmx

    def cm_y(self):
        return self.cmy

    def mass(self):
        return self.m

    def m_inert(self):
        return self.moment

    def sum(self,m):
        sumOut = 0.0
        for i in m:
            sumOut += i
        return sumOut

    def cm(self,z,m):
        sumOut = 0.0
        for i in range(len(m)):
            sumOut += z[i]*m[i]
        return sumOut/sum(m)

    def mmom(self,x,y,m):
        sumOut = 0.0
        for i in range(len(m)):
            sumOut += m[i] * (x[i]**2 + y[i]**2)
        return sumOut