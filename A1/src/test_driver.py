## @file test_driver.py
#  @author 
#  @brief 
#  @date 

from complex_adt import ComplexT

complex = ComplexT(3,4)
complex2 = ComplexT(3,4)
print(complex.real())
print(complex.imag())
print(complex.get_r())
print(complex.get_phi())
print(complex.equals(complex2))