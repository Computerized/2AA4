## @file complex_adt.py
#  @author scotta30
#  @brief Contains a class for representing a complex number
#  @date 2021-01-13

import math

## @brief An ADT for complex numbers
# @details This class represents a complex number composed of real and
#          imaginary components
class ComplexT:
    x, y = 0, 0

    ## @brief Constructor for ComplexT class
    # @details This constructor creates an object which represents a complex
    #          number in the form a + bi.
    # @param x The real value of the complex number
    # @param y The imaginary value of the complex number
    def __init__(self, x, y):
        self.x = x
        self.y = y

    ## @brief Returns the real value of the complex number
    # @details This function returns the stored real value of the complex number.
    # @return The real value of the number
    def real(self):
        return self.x

    ## @brief Returns the real value of the complex number
    # @details This function returns the stored imaginary value of the complex number.
    # @return The imaginary value of the number
    def imag(self):
        return self.y

    ## @brief Returns radius of the complex number
    # @details This function returns the polar length of the complex number
    # @return The radius of the complex number
    def get_r(self):
        return math.sqrt(self.x**2 + self.y**2)

    ## @brief Returns angle of the complex number
    # @details This function returns the angle of the complex number
    # @return The angle of the complex number
    # @throws ZeroDivisionError if the denominator comes out to zero
    #         (such as in the case of 0 + 0i)
    def get_phi(self):
        try:
            out = 2*math.atan(self.y/(math.sqrt(self.x**2 + self.y**2)+self.x))
            return out
        except ZeroDivisionError:
            print("Cannot divide by zero")
            return None

    ## @brief Checks if two numbers are equal
    # @details This function determines if two complex numbers are equal by
    #          checking their respective real and imaginary values against
    #          eachother
    # @returns True if the two numbers are equivalent
    # @param obj Complex number being checked against
    def equal(self, obj):
        return (obj.real() == self.x) and (obj.imag() == self.y)

    ## @brief Calculates the conjugate of the complex number
    # @details This function returns the reciprocal of the function by
    #          duplicating the current ComplexT, but with a negative imaginary
    # @return The reciprocal of the complex number
    def conj(self):
        return ComplexT(self.x, -self.y)

    ## @brief Adds two complex numbers
    # @details This function returns the sum of two complex numbers by
    #          by creating a new complex number with the real and imaginary
    #          components respectively summed
    # @return The sum of the complex numbers
    def add(self, obj):
        return ComplexT(self.x + obj.real(), self.y + obj.imag())

    ## @brief Subtracts two complex numbers
    # @details This function returns the difference of two complex numbers by
    #          by creating a new complex number with the real and imaginary
    #          components respectively subtracted
    # @return The difference of the complex numbers
    def sub(self, obj):
        return ComplexT(self.x - obj.real(), self.y - obj.imag())

    ## @brief Multiplies two complex numbers
    # @details This function returns the product of two complex numbers by
    #          by creating a new complex number with the respective components
    #          multiplied by expansion.
    # @return The product of the complex numbers
    # @param obj The second factor of the multiplication
    def mult(self, obj):
        r = self.x * obj.real() - self.y * obj.imag()
        i = self.x * obj.imag() + self.y * obj.real()
        return ComplexT(r, i)

    ## @brief Reciprocal function
    # @details This function returns the reciprocal of the current complex
    #          number.
    # @throws ZeroDivisionError when x = y = 0
    # @return The reciprocal of the complex number
    def recip(self):
        denom = self.x ** 2 + self.y ** 2
        try:
            out = ComplexT(self.x/denom, -self.y/denom)
            return out
        except ZeroDivisionError:
            print("Cannot divide by zero")
            return None

    ## @brief Divides two complex numbers
    # @details This function returns the quotient of two complex numbers by
    #          by creating a new complex number that is the result of the
    #          complex number multiplied by the reciprocal of the input
    # @return The quotient of the complex numbers
    # @param obj The divisor
    def div(self, obj):
        rec = obj.recip()
        if (rec == None):
            return None
        return self.mult(rec)

    ## @brief Square root of the complex number
    # @details This function returns the square root of the complex number
    #          by computing the value of each respective component.
    # @return The square root of the complex number
    def sqrt(self):
        if (self.y == 0):
            return ComplexT(math.sqrt(self.x),0)
        r = self.get_r()
        real = math.sqrt((r + self.x)/2)
        imag = (abs(self.y)/self.y)*math.sqrt((r - self.x)/2)
        return ComplexT(real, imag)
