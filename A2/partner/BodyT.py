## @file BodyT.py
#  @author Samia Anwar
#  @brief Contains a generic BodyT type which has properties of a Shape
#  @date Feb 2/2021

from Shape import Shape

##  @brief Objects of this class represent body of points with mass
#   cartesian placement of physical structures, their masses, and their moments of inertia


class BodyT(Shape):

    ## @brief Constructor method for class BodyT, initialises a Body from their
    #  x, y, and mass values
    #  @param x is the x-coordinates of an object on the cartesian plane, represented
    #  as a sequence of real numbers
    #  @param y is the y-coordinates of an object on the cartesian plane, represented
    #  as a sequence of real numbers
    #  @param m is the mass of each part of an object, represented as a sequence of real
    #  numbers, corresponding to the indices in the x and y lists
    #  @details the constructor method conducts calculations based on the given parameters
    #  to create a numerical self object corresponding to the moment of inertia of the whole
    #  object, the x-y coordinates of the centre of mass of the whole system and the mass of
    #  the whole system
    #  @throws ValueError if parameters are not sequences of the same length, and if members
    #  of sequence m are less than or equal to zero
    def __init__(self, x, y, m):
        if not (len(x) == len(y) and len(x) == len(m)):
            raise ValueError
        for i in m:
            if i <= 0:
                raise ValueError
        self.cmx = self.__cm__(x, m)
        self.cmy = self.__cm__(y, m)
        self.m = self.__sum__(m)
        self.moment = self.__mmom__(x, y, m) - self.m * (self.cmx ** 2 + self.cmy ** 2)

    ## @brief returns the value of the x coordinate of the object's center of mass
    #  @return a real number representation of the x-coordinate
    def cm_x(self):
        return self.cmx

    ## @brief returns the value of the y coordinate of the object's center of mass
    #  @return a real number representation of the y-coordinate of the object's center of mass
    def cm_y(self):
        return self.cmy

    ## @brief returns the value of the total mass of the object
    #  @return a real number representation of the total mass of the object
    def mass(self):
        return self.m

    ## @brief returns the value of the object's moment of inertia
    #  @return real number representation of the object's total moment of inertia
    def m_inert(self):
        return self.moment

    ## @brief Calculates the sum of values in a list of real numbers
    #  @param a is the list composed of real numbers to be added together
    #  @return a real number representation of the sum of the list
    def __sum__(self, a):
        s = 0
        for u in a:
            s = s + u
        return s

    ## @brief Calculates the center of mass of an object on one cartesian axis
    #  @param a is the list composed of real number masses corresponding to parts of an object
    #  @param z is the list composed of real number x-coordinates  corresponding
    #  to parts of an object
    #  @return a real number representation of the center of mass of an object in parts
    def __cm__(self, z, a):
        s = 0
        for i in range(len(a)):
            s = s + (z[i] * a[i])
        return (s / self.__sum__(a))

    ## @brief Calculates some real number value in the moment of inertia equation
    #  @param x is the list of x-coordinates of the parts of a system of objects
    #  @param y is the list of y-coordinates of the parts of a system of objects
    #  @param m is the list of masses of the parts of a system of objects
    #  @returns real number representaion of the sum of m * (x^2 + y^2) at each
    #  index of the corresponding lists
    def __mmom__(self, x, y, m):
        s = 0
        for i in range(len(m)):
            s = s + m[i] * (x[i] * x[i] + y[i] * y[i])
        return s
