## @file test_All.py
#  @author
#  @brief
#  @date
#  @details

from CircleT import CircleT
from TriangleT import TriangleT

circle = CircleT(1.0, 10.0, 0.5, 1.0)

def test_circle_cmx():
    assert circle.cm_x() == 1.0

def test_circle_cmy():
    assert circle.cm_y() == 10.0

def test_circle_mass():
    assert circle.mass() == 1.0

def test_circle_inert():
    assert circle.m_inert() == (1.0*0.5**2)/2

triangle = TriangleT(1.0, -10.0, 5, 17.5)

def test_triangle_cmx():
    assert triangle.cm_x() == 1.0

def test_triangle_cmy():
    assert triangle.cm_y() == -10.0

def test_triangle_mass():
    assert triangle.mass() == 5

def test_triangle_inert():
    assert triangle.m_inert() == (17.5*5**2)/12



