## @file test_driver.py
#  @author Alan Scott
#  @brief Test driver for classes
#  @date

from complex_adt import ComplexT
from triangle_adt import TriangleT, TriType
import math

c1 = ComplexT(3,4)
c2 = ComplexT(3,4)
c3 = ComplexT(2,4)
c4 = ComplexT(0,0)
c5 = ComplexT(4,0)
c6 = ComplexT(8,-6)

def real_test():
    if (c1.real() == 3):
        print("Passed real() test")
        return 1
    else:
        print("Failed real() test")
        return 0

def imag_test():
    if (c1.imag() == 4):
        print("Passed imag() test")
        return 1
    else:
        print("Failed imag() test")
        return 0

def get_r_test():
    if (c1.get_r() == 5):
        print("Passed get_r() test")
        return 1
    else:
        print("Failed get_r() test")
        return 0

def get_phi_test():
    did_pass = 1
    if (c1.get_phi() != 2*math.atan(4/(math.sqrt(3**2 + 4**2)+3))):
        print("Failed get_phi():regular test")
        did_pass = 0
    if (c4.get_phi() != None):
        print("Failed get_phi():divide by zero test")
        did_pass = 0
    if (did_pass == 1):
        print("Passed get_phi() test")
        return 1
    return 0

def equal_test():
    did_pass = 1
    if (not c1.equal(c2)):
        print("Failed equal():equal test")
        did_pass = 0
    if (c1.equal(c6)):
        print("Failed equal():not equal test")
        did_pass = 0
    if (did_pass == 1):
        print("Passed equal() test")
        return 1
    return 0

def conj_test():
    if (c1.conj().equal(ComplexT(3,-4))):
        print("Passed conj() test")
        return 1
    else:
        print("Failed conj() test")
        return 0

def add_test():
    if (c1.add(ComplexT(3,4)).equal(ComplexT(6,8))):
        print("Passed add() test")
        return 1
    else:
        print("Failed add() test")
        return 0

def sub_test():
    if (c1.sub(ComplexT(1,2)).equal(ComplexT(2,2))):
        print("Passed sub() test")
        return 1
    else:
        print("Failed sub() test")
        return 0

def mult_test():
    did_pass = 1
    if (not c1.mult(ComplexT(0,0)).equal(ComplexT(0,0))):
        print("Failed mult():by zero test")
        did_pass = 0
    if (not c1.mult(c1).equal(ComplexT(-7,24))):
        print("Failed mult():normal test")
        did_pass = 0
    if (did_pass == 1):
        print("Passed mult() test")
        return 1
    return 0

def recip_test():
    did_pass = 1
    if (not c3.recip().equal(ComplexT(1/10,-2/10))):
        print("Failed recip():normal test")
        did_pass = 0
    if (c4.recip() != None):
        print("Failed recip():divide by 0 test")
        did_pass = 0
    if (did_pass == 1):
        print("Passed recip() test")
        return 1
    return 0

def div_test():
    did_pass = 1
    if (not c1.div(c1).equal(ComplexT(1,0))):
        print("Failed div():self-cancellation test")
        did_pass = 0
    if (c1.div(c4) != None):
        print("Failed div():divide by zero test")
        did_pass = 0
    if (did_pass == 1):
        print("Passed div() test")
        return 1
    return 0

def sqrt_test():
    did_pass = 1
    if (not c6.sqrt().equal(ComplexT(3,-1))):
        print("Failed sqrt():regular test")
        did_pass = 0
    if (not c4.sqrt().equal(ComplexT(0,0))):
        print("Failed sqrt():empty complex number test")
        did_pass = 0
    if (not c5.sqrt().equal(ComplexT(2,0))):
        print("Failed sqrt():empty imaginary component test")
        did_pass = 0
    if (did_pass == 1):
        print("Passed sqrt() test")
        return 1
    return 0

print("complex_adt: -----------------")
passed = real_test() + imag_test() + get_r_test() + get_phi_test() + equal_test() + conj_test() + add_test() + sub_test() + mult_test() + recip_test() + div_test() + sqrt_test()
print("complex_adt: Passed " + str(passed) + " tests out of 12")

tr1 = TriangleT(3,4,5)
tr2 = TriangleT(1,1,1)
tr3 = TriangleT(1,1,10)
tr4 = TriangleT(4,6,9)
tr5 = TriangleT(0,1,1)
tr6 = TriangleT(2,2,1)

def get_sides_test():
    correct = 3, 4, 5
    if (tr1.get_sides() == correct):
        print("Passed get_sides() test")
        return 1
    else:
        print("Failed get_sides() test")
        return 0

def triangle_equal_test():
    did_pass = 1
    if (not tr1.equal(TriangleT(3,4,5))):
        print("Failed equal() test")
        did_pass = 0
    if (not tr1.equal(TriangleT(5,4,3))):
        print("Failed equal() test")
        did_pass = 0
    if (tr1.equal(TriangleT(1,1,1))):
        print("Failed equal() test")
        did_pass = 0
    if (did_pass == 1):
        print("Passed equal() test")
        return 1
    return 0

def perim_test():
    if (tr1.perim() == 12):
        print("Passed perim() test")
        return 1
    else:
        print("Failed perim() test")
        return 0

def area_test():
    if (tr1.area() == 6):
        print("Passed area() test")
        return 1
    else:
        print("Failed area() test")
        return 0

def is_valid_test():
    did_pass = 1
    if (tr1.is_valid() == False):
        print("Failed is_valid() test")
        did_pass = 0
    if (tr3.is_valid() == True):
        print("Failed is_valid() test")
        did_pass = 0
    if (did_pass == 1):
        print("Passed is_valid() test")
        return 1
    return 0

def tri_type_test():
    did_pass = 1
    if (tr1.tri_type() != TriType.right):
        print("Failed tri_type():right test")
        did_pass = 0
    if (tr2.tri_type() != TriType.equilat):
        print("Failed tri_type():equilateral test")
        did_pass = 0
    if (tr3.tri_type() != None):
        print("Failed tri_type():invalid side length test")
        did_pass = 0
    if (tr4.tri_type() != TriType.scalene):
        print("Failed tri_type():scalene test") 
        did_pass = 0
    if (tr5.tri_type() != None):
        print("Failed tri_type():zero length test")
        did_pass = 0
    if (tr6.tri_type() != TriType.isosceles):
        print("Failed tri_type():isosceles test")
        did_pass = 0
    if (did_pass == 1):
        print("Passed tri_type() test")
        return 1
    return 0

print("triangle_adt: ----------------")
passed = get_sides_test() + triangle_equal_test() + perim_test() + area_test() + is_valid_test() + tri_type_test()
print("triangle_adt: Passed " + str(passed) + " tests out of 6")
