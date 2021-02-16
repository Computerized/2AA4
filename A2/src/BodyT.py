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
        self.cmx = self.cm(xs,ms)
        self.cmy = self.cm(ys,ms)
        self.m = sum(ms)
        self.moment = (self.mmom(xs,ys,ms) - sum(ms)*(self.cm(xs,ms)**2
        + self.cm(ys,ms)**2))
        
    ## @brief Inherited cm_x function from Shape
    #  @details This function is inherited from the parent class. It returns the x value
    #           of the center of mass.
    def cm_x(self):
        return self.cmx

    ## @brief Inherited cm_y function from Shape
    #  @details This function is inherited from the parent class. It returns the y value
    #           of the center of mass.
    def cm_y(self):
        return self.cmy

    ## @brief Inherited mass function from Shape
    #  @details This function is inherited from the parent class. It returns the value of
    #           the mass.
    def mass(self):
        return self.m

    ## @brief Inherited m_inert function from Shape
    #  @details This function is inherited from the parent class. It returns the value
    #           of the center of moment of intertia.
    def m_inert(self):
        return self.moment

    ## @brief Dual array summation
    #  @details This function takes two arrays and finds the sum of the elements
    #           of two equally sized arrays. It then divides this sum by the sum of
    #           the mass array. 
    #  @param z First array
    #  @param m Second array
    def cm(self,z,m):
        sumOut = 0.0
        for i in range(len(m)):
            sumOut += z[i]*m[i]
        return sumOut/sum(m)

    ## @brief Pythagorean summation
    #  @details This function sums the square of each element of the x and y arrays
    #           multiplied by the respictive value of the mass. 
    #  @param x Array of x values
    #  @param y Array of y values
    #  @param m Array of masses
    def mmom(self,x,y,m):
        sumOut = 0.0
        for i in range(len(m)):
            sumOut += m[i] * (x[i]**2 + y[i]**2)
        return sumOut