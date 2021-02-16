## @file BodyT.py
#  @author Alan Scott
#  @brief Body class
#  @date 16/02/21

from Shape import Shape


class BodyT(Shape):

    ## @brief BodyT Constructor
    #  @details This constructor creates an the BodyT object from the parameters of
    #           the center of mass and the mass. If the values of the mass and the
    #           centers of mass are not of equal size, a Value error is thrown. The
    #           center of mass, total mass, and the moment of inertia are calculated
    #           in the constructor using class functions.
    #  @throws ValueError when the lengths of the x, y and mass are not the same.
    #  @param xs The set of x coordinates of the centers of mass
    #  @param ys The set of y coordinates of the centers of mass
    #  @param xs The set of masses
    def __init__(self, xs, ys, ms):
        if (not (len(xs) == len(ys) and (len(ys) == len(ms)))):
            raise ValueError
        for i in range(len(ms)):
            if (ms[i] <= 0):
                raise ValueError
        self.cmx = self.__cm__(xs, ms)
        self.cmy = self.__cm__(ys, ms)
        self.m = sum(ms)
        self.moment = self.__mmom__(xs, ys, ms) - sum(ms)
        self.moment *= (self.__cm__(xs, ms)**2 + self.__cm__(ys, ms)**2)

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

    ## @brief Centre of mass calculation
    #  @details This function takes two arrays and finds the sum of the elements
    #           of two equally sized arrays. It then divides this sum by the sum of
    #           the mass array.
    #  @param z First array
    #  @param m Second array
    def __cm__(self, z, m):
        sumout = 0.0
        for i in range(len(m)):
            sumout += z[i] * m[i]
        return sumout / sum(m)

    ## @brief Pythagorean summation
    #  @details This function sums the square of each element of the x and y arrays
    #           multiplied by the respictive value of the mass.
    #  @param x Array of x values
    #  @param y Array of y values
    #  @param m Array of masses
    def __mmom__(self, x, y, m):
        sumout = 0.0
        for i in range(len(m)):
            sumout += m[i] * (x[i]**2 + y[i]**2)
        return sumout
