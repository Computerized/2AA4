## @file test_All.py
#  @author
#  @brief
#  @date
#  @details

from CircleT import CircleT

total = 0
g = 9.81  # accel due to gravity (m/s^2)
m = 1  # mass (kg)

def Fx(t):
    return 5 if t < 5 else 0


def Fy(t):
    return -g * m if t < 3 else g * m

circle = CircleT(1.0, 10.0, 0.5, 1.0)

def test_circle():
    assert circle.cm_x() == 1.0
    assert circle.cm_y() == 10.0
    assert circle.mass() == 1.0
    assert circle.m_inert() == (1.0*0.5**2)/2



test_circle()

