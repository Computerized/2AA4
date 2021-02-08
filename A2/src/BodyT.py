## @file BodyT.py
#  @author Alan Scott
#  @brief
#  @date

from Shape import Shape

class BodyT(Shape):

    def __init__(self,xs,ys,ms):
        if (not (len(xs) == len(ys) and (len(ys) == len(ms)))):
            raise ValueError
        for i in range(len(ms)):
            if (ms[i] <= 0):
                raise ValueError
        self.cmx = self.__cm__(xs,ms)
        self.cmy = self.__cm__(ys,ms)
        self.m = sum(ms)
        self.moment = (self.__mmom__(xs,ys,ms) - sum(ms)*(self.__cm__(xs,ms)**2
        + self.__cm__(ys,ms)**2))
        

    def cm_x(self):
        return self.cmx

    def cm_y(self):
        return self.cmy

    def mass(self):
        return self.m

    def m_inert(self):
        return self.moment

    def __cm__(self,z,m):
        sumOut = 0.0
        for i in range(len(m)):
            sumOut += z[i]*m[i]
        return sumOut/sum(m)

    def __mmom__(self,x,y,m):
        sumOut = 0.0
        for i in range(len(m)):
            sumOut += m[i] * (x[i]**2 + y[i]**2)
        return sumOut